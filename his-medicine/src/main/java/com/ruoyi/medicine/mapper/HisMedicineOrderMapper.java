package com.ruoyi.medicine.mapper;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-31
 */
@Mapper
public interface HisMedicineOrderMapper 
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
     * 
     * @param hisMedicineOrder 采购信息
     * @return 结果
     */
    public int insertHisMedicineOrder(HisMedicineOrder hisMedicineOrder);

    /**
     * 修改采购信息
     * 
     * @param hisMedicineOrder 采购信息
     * @return 结果
     */
    public int updateHisMedicineOrder(HisMedicineOrder hisMedicineOrder);

    /**
     * 删除采购信息
     * 
     * @param orderId 采购信息主键
     * @return 结果
     */
    public int deleteHisMedicineOrderByOrderId(Long orderId);

    /**
     * 批量删除采购信息
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisMedicineOrderByOrderIds(Long[] orderIds);
}
