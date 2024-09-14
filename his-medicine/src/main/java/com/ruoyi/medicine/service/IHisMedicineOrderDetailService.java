package com.ruoyi.medicine.service;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineOrderDetail;

/**
 * 订单详情信息Service接口
 * 
 * @author ruoyi
 * @date 2024-09-11
 */
public interface IHisMedicineOrderDetailService 
{
    /**
     * 查询订单详情信息
     * 
     * @param detailId 订单详情信息主键
     * @return 订单详情信息
     */
    public HisMedicineOrderDetail selectHisMedicineOrderDetailByDetailId(Long detailId);

    /**
     * 查询订单详情信息列表
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 订单详情信息集合
     */
    public List<HisMedicineOrderDetail> selectHisMedicineOrderDetailList(HisMedicineOrderDetail hisMedicineOrderDetail);

    /**
     * 新增订单详情信息
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 结果
     */
    public int insertHisMedicineOrderDetail(HisMedicineOrderDetail hisMedicineOrderDetail);

    /**
     * 修改订单详情信息
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 结果
     */
    public int updateHisMedicineOrderDetail(HisMedicineOrderDetail hisMedicineOrderDetail);

    /**
     * 批量删除订单详情信息
     * 
     * @param detailIds 需要删除的订单详情信息主键集合
     * @return 结果
     */
    public int deleteHisMedicineOrderDetailByDetailIds(Long[] detailIds);

    /**
     * 删除订单详情信息信息
     * 
     * @param detailId 订单详情信息主键
     * @return 结果
     */
    public int deleteHisMedicineOrderDetailByDetailId(Long detailId);
}
