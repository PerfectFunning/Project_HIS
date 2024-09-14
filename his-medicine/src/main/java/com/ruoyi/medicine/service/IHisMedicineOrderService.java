package com.ruoyi.medicine.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.medicine.domain.HisMedicineOrder;

/**
 * 采购信息Service接口
 * 
 * @author ruoyi
 * @date 2024-08-31
 */
public interface IHisMedicineOrderService 
{
    /**
     * 查询采购信息
     * 
     * @param orderId 采购信息主键
     * @return 采购信息
     */
    public HisMedicineOrder selectHisMedicineOrderByOrderId(Long orderId);

    /**
     * 查询采购信息列表
     * 
     * @param hisMedicineOrder 采购信息
     * @return 采购信息集合
     */
    public List<HisMedicineOrder> selectHisMedicineOrderList(HisMedicineOrder hisMedicineOrder);

    /**
     * 新增采购信息
     */
    public int insertHisMedicineOrder(Map<String,Object> map,Long userId) throws JsonProcessingException;

    /**
     * 修改采购信息
     * 
     * @param hisMedicineOrder 采购信息
     * @return 结果
     */
    public int updateHisMedicineOrder(HisMedicineOrder hisMedicineOrder);

    /**
     * 批量删除采购信息
     * 
     * @param orderIds 需要删除的采购信息主键集合
     * @return 结果
     */
    public int deleteHisMedicineOrderByOrderIds(Long[] orderIds);

    /**
     * 删除采购信息信息
     * 
     * @param orderId 采购信息主键
     * @return 结果
     */
    public int deleteHisMedicineOrderByOrderId(Long orderId);
}
