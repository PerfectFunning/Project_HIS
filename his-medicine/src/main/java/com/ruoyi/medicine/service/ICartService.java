package com.ruoyi.medicine.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.medicine.domain.HisMedicineDrug;

import java.util.List;

/**
 * @author Hao
 * @date 2024/9/2
 * @time 下午4:09
 **/
public interface ICartService {
    //添加购物车
    int addCart(Long userId,Long[] drugIds) throws JsonProcessingException;
    //查询购物车里的采购订单详情
    List<HisMedicineDrug> myCartListService(Long userId) throws JsonProcessingException;
    //更新采购数量
    int updateCartNumService(Long userId, Long drugId, Long cartDrugNum) throws JsonProcessingException;

    int deleteCartOptionByIds(Long userId, Long[] drugIds) throws JsonProcessingException;
}
