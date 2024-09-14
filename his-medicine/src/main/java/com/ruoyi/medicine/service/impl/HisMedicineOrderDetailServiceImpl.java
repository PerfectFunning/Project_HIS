package com.ruoyi.medicine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.medicine.mapper.HisMedicineOrderDetailMapper;
import com.ruoyi.medicine.domain.HisMedicineOrderDetail;
import com.ruoyi.medicine.service.IHisMedicineOrderDetailService;

/**
 * 订单详情信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-11
 */
@Service
public class HisMedicineOrderDetailServiceImpl implements IHisMedicineOrderDetailService 
{
    @Autowired
    private HisMedicineOrderDetailMapper hisMedicineOrderDetailMapper;

    /**
     * 查询订单详情信息
     * 
     * @param detailId 订单详情信息主键
     * @return 订单详情信息
     */
    @Override
    public HisMedicineOrderDetail selectHisMedicineOrderDetailByDetailId(Long detailId)
    {
        return hisMedicineOrderDetailMapper.selectHisMedicineOrderDetailByDetailId(detailId);
    }

    /**
     * 查询订单详情信息列表
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 订单详情信息
     */
    @Override
    public List<HisMedicineOrderDetail> selectHisMedicineOrderDetailList(HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        return hisMedicineOrderDetailMapper.selectHisMedicineOrderDetailList(hisMedicineOrderDetail);
    }

    /**
     * 新增订单详情信息
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 结果
     */
    @Override
    public int insertHisMedicineOrderDetail(HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        hisMedicineOrderDetail.setCreateTime(DateUtils.getNowDate());
        return hisMedicineOrderDetailMapper.insertHisMedicineOrderDetail(hisMedicineOrderDetail);
    }

    /**
     * 修改订单详情信息
     * 
     * @param hisMedicineOrderDetail 订单详情信息
     * @return 结果
     */
    @Override
    public int updateHisMedicineOrderDetail(HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        hisMedicineOrderDetail.setUpdateTime(DateUtils.getNowDate());
        return hisMedicineOrderDetailMapper.updateHisMedicineOrderDetail(hisMedicineOrderDetail);
    }

    /**
     * 批量删除订单详情信息
     * 
     * @param detailIds 需要删除的订单详情信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineOrderDetailByDetailIds(Long[] detailIds)
    {
        return hisMedicineOrderDetailMapper.deleteHisMedicineOrderDetailByDetailIds(detailIds);
    }

    /**
     * 删除订单详情信息信息
     * 
     * @param detailId 订单详情信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineOrderDetailByDetailId(Long detailId)
    {
        return hisMedicineOrderDetailMapper.deleteHisMedicineOrderDetailByDetailId(detailId);
    }
}
