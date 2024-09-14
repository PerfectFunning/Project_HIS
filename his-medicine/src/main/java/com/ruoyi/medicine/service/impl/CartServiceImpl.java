package com.ruoyi.medicine.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.medicine.domain.Cart;
import com.ruoyi.medicine.domain.HisMedicineDrug;
import com.ruoyi.medicine.mapper.HisMedicineCartMapper;
import com.ruoyi.medicine.mapper.HisMedicineDrugMapper;
import com.ruoyi.medicine.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author Hao
 * @date 2024/9/2
 * @time 下午4:09
 **/
@Service
@Transactional
public class CartServiceImpl implements ICartService {
    //声明mapper层属性
    @Autowired
    private HisMedicineCartMapper mapper;
    @Autowired
    private HisMedicineDrugMapper drugMapper;

    //我的采购
    @Override
    public List<HisMedicineDrug> myCartListService(Long userId) throws JsonProcessingException {
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //1、查询用户的购物车
        Cart cart = mapper.selectHisMedicineCartByUserId(userId);
        //判断购物车是否为空
        if (cart != null) {
            HashMap<Long, HisMedicineDrug> map = objectMapper.readValue(cart.getCart(), new TypeReference<HashMap<Long, HisMedicineDrug>>() {
            });
            Collection<HisMedicineDrug> values = map.values();
            List<HisMedicineDrug> list = new ArrayList<>(values);
            return list;
        }
        return null;
    }

    //更新采购数量
    @Override
    public int updateCartNumService(Long userId, Long drugId, Long cartDrugNum) throws JsonProcessingException {
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //查询用户的购物车
        Cart cart = mapper.selectHisMedicineCartByUserId(userId);
        //获取购物车中采购信息
        HashMap<Long, HisMedicineDrug> map = objectMapper.readValue(cart.getCart(), new TypeReference<HashMap<Long, HisMedicineDrug>>() {
        });
        //通过id拿到具体的采购项
        HisMedicineDrug medicineDrug = map.get(drugId);
        medicineDrug.setCartDrugNum(cartDrugNum);
        String s = objectMapper.writeValueAsString(map);
        cart.setCart(s);
        return mapper.updateCartInfoMapper(cart);
    }

    //删除采购项
    @Override
    public int deleteCartOptionByIds(Long userId, Long[] drugIds) throws JsonProcessingException {
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //查询用户的购物车
        Cart cart = mapper.selectHisMedicineCartByUserId(userId);
        //获取购物车中采购信息
        HashMap<Long, HisMedicineDrug> map = objectMapper.readValue(cart.getCart(), new TypeReference<HashMap<Long, HisMedicineDrug>>() {
        });
        //通过for循环遍历drugIds删除选中的药品列表
        for (Long drugId : drugIds) {
            map.remove(drugId);
        }
        //将map集合转换成字符串,重新赋值购物车的cart属性
        String s = objectMapper.writeValueAsString(map);
        cart.setCart(s);
        return mapper.updateCartInfoMapper(cart);
    }

    //添加药品到购物车
    @Override
    @Transactional
    public int addCart(Long userId, Long[] drugIds) throws JsonProcessingException {
        //创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //1、查询用户的购物车
        Cart cart = mapper.selectHisMedicineCartByUserId(userId);
        //2、判断购物车是否存在
        HashMap<Long, HisMedicineDrug> map = null;//存储用户的购物车集合，k-v:药品id 药品对象
        if (cart == null) {
            map = new HashMap<>();//购物车为空 新建购物车
        } else {
            //购物车存在 获取购物车
            map = objectMapper.readValue(cart.getCart(), new TypeReference<HashMap<Long, HisMedicineDrug>>() {
            });
        }
        //3、添加药品到购物车中
        for (Long drugId : drugIds) {
            //判断购物车中是否有对应的药品 没有则加入购物车，有则不做操作  数量增减操作在后续
            HisMedicineDrug hisMedicineDrug = map.get(drugId);
            if (hisMedicineDrug == null) {
                //购物车中没有的药品，从mapper中通过id获取药品对象加入购物车
                HisMedicineDrug medicineDrug = drugMapper.selectHisMedicineDrugByDrugId(drugId);
                medicineDrug.setCartDrugNum(1L);
                map.put(drugId, medicineDrug);
            }
        }
        //4、存储购物车
        String s = objectMapper.writeValueAsString(map);
        if (cart == null) {
            cart = new Cart();
            cart.setCart(s);
            cart.setUserId(userId);
            return mapper.insertCartInfoMapper(cart);
        } else {
            cart.setCart(s);
            return mapper.updateCartInfoMapper(cart);
        }
    }


}