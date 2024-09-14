package com.ruoyi.medicine.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.medicine.domain.*;
import com.ruoyi.medicine.mapper.HisMedicineCartMapper;
import com.ruoyi.medicine.mapper.HisMedicineOrderDetailMapper;
import com.ruoyi.medicine.mapper.HisMedicineOrderMapper;
import com.ruoyi.medicine.mapper.HisMedicineSupplierMapper;
import com.ruoyi.medicine.service.IHisMedicineOrderService;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 采购信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-31
 */
@Service
public class HisMedicineOrderServiceImpl implements IHisMedicineOrderService {
    @Autowired
    private HisMedicineOrderMapper hisMedicineOrderMapper;
    @Autowired
    private HisMedicineOrderDetailMapper hisMedicineOrderDetailMapper;
    @Autowired
    private HisMedicineCartMapper mapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private HisMedicineSupplierMapper supplierMapper;

    /**
     * 查询采购信息
     *
     * @param orderId 采购信息主键
     * @return 采购信息
     */
    @Override
    public HisMedicineOrder selectHisMedicineOrderByOrderId(Long orderId) {
        return hisMedicineOrderMapper.selectHisMedicineOrderByOrderId(orderId);
    }

    /**
     * 查询采购信息列表
     *
     * @param hisMedicineOrder 采购信息
     * @return 采购信息
     */
    @Override
    public List<HisMedicineOrder> selectHisMedicineOrderList(HisMedicineOrder hisMedicineOrder) {
        List<HisMedicineOrder> hisMedicineOrders = hisMedicineOrderMapper.selectHisMedicineOrderList(hisMedicineOrder);
        for (HisMedicineOrder order : hisMedicineOrders) {
            //查询制单人信息
            order.setUser(sysUserMapper.selectUserById(order.getOrderPerson()));
            //查询供应商信息
            order.setSupplier(supplierMapper.selectHisMedicineSupplierBySupplierId(order.getSupplierId()));
        }
        return hisMedicineOrders;
    }

    /**
     * 新增采购信息
     */
    @Transactional
    @Override
    public int insertHisMedicineOrder(Map<String, Object> map, Long userId) throws JsonProcessingException {
        //1. 新增采购单:
        HisMedicineOrder order = new HisMedicineOrder();
        order.setOrderPerson(userId);
        order.setOrderStatus("0");
        order.setSupplierId(Long.parseLong(map.get("supplierId").toString()));
        order.setRemark(map.get("remark").toString());
        order.setCreateTime(new Date());
        order.setOrderNum(IdUtils.orderNum());
        int i = hisMedicineOrderMapper.insertHisMedicineOrder(order);
        //2. 新增采购详情
        ArrayList<Integer> drugIds = (ArrayList<Integer>) map.get("drugIds");
        //System.out.println("------"+drugIds);
        //获取当前用户的购物车
        Cart cart = mapper.selectHisMedicineCartByUserId(userId);
        ObjectMapper objectMapper = new ObjectMapper();//创建ObjectMapper对象
        HashMap<Long, HisMedicineDrug> cartMap = objectMapper.readValue(cart.getCart(), new TypeReference<HashMap<Long, HisMedicineDrug>>() {
        });
        //获取要采购的药品信息，并新增
        for (Integer drugId : drugIds) {
            System.out.println(drugId);
            //获取购物车中的药品信息
            HisMedicineDrug medicineDrug = cartMap.get(Long.parseLong(drugId.toString()));
            System.out.println(medicineDrug);
            //创建采购详情对象
            HisMedicineOrderDetail detail = new HisMedicineOrderDetail();
            detail.setOrderId(order.getOrderId());
            detail.setCreateTime(new Date());
            detail.setDetailNum(medicineDrug.getCartDrugNum());
            detail.setDrugId(medicineDrug.getDrugId());
            //新增
            hisMedicineOrderDetailMapper.insertHisMedicineOrderDetail(detail);
            //删除购物车中的采购项
            cartMap.remove(Long.parseLong(drugId.toString()));
        }
        //更新购物车信息
        String s = objectMapper.writeValueAsString(cartMap);
        cart.setCart(s);
        mapper.updateCartInfoMapper(cart);
        return i;
    }

    /**
     * 修改采购信息
     *
     * @param hisMedicineOrder 采购信息
     * @return 结果
     */
    @Override
    public int updateHisMedicineOrder(HisMedicineOrder hisMedicineOrder) {
        hisMedicineOrder.setUpdateTime(DateUtils.getNowDate());
        return hisMedicineOrderMapper.updateHisMedicineOrder(hisMedicineOrder);
    }

    /**
     * 批量删除采购信息
     *
     * @param orderIds 需要删除的采购信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineOrderByOrderIds(Long[] orderIds) {
        return hisMedicineOrderMapper.deleteHisMedicineOrderByOrderIds(orderIds);
    }

    /**
     * 删除采购信息信息
     *
     * @param orderId 采购信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineOrderByOrderId(Long orderId) {
        return hisMedicineOrderMapper.deleteHisMedicineOrderByOrderId(orderId);
    }
}
