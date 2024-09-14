package com.ruoyi.medicine.mapper;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineOrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-01
 */
@Mapper
public interface HisMedicineOrderDetailMapper 
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
     * 删除订单详情信息
     * 
     * @param detailId 订单详情信息主键
     * @return 结果
     */
    public int deleteHisMedicineOrderDetailByDetailId(Long detailId);

    /**
     * 批量删除订单详情信息
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisMedicineOrderDetailByDetailIds(Long[] detailIds);
}
