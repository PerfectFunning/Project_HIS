package com.ruoyi.medicine.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.medicine.mapper.HisMedicineSupplierMapper;
import com.ruoyi.medicine.domain.HisMedicineSupplier;
import com.ruoyi.medicine.service.IHisMedicineSupplierService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@Service
public class HisMedicineSupplierServiceImpl implements IHisMedicineSupplierService 
{
    @Autowired
    private HisMedicineSupplierMapper hisMedicineSupplierMapper;

    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public HisMedicineSupplier selectHisMedicineSupplierBySupplierId(Long supplierId)
    {
        return hisMedicineSupplierMapper.selectHisMedicineSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<HisMedicineSupplier> selectHisMedicineSupplierList(HisMedicineSupplier hisMedicineSupplier)
    {
        return hisMedicineSupplierMapper.selectHisMedicineSupplierList(hisMedicineSupplier);
    }

    /**
     * 新增供应商信息
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int insertHisMedicineSupplier(HisMedicineSupplier hisMedicineSupplier)
    {
        hisMedicineSupplier.setCreateTime(DateUtils.getNowDate());
        return hisMedicineSupplierMapper.insertHisMedicineSupplier(hisMedicineSupplier);
    }

    /**
     * 修改供应商信息
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 结果
     */
    @Override
    public int updateHisMedicineSupplier(HisMedicineSupplier hisMedicineSupplier)
    {
        hisMedicineSupplier.setUpdateTime(DateUtils.getNowDate());
        return hisMedicineSupplierMapper.updateHisMedicineSupplier(hisMedicineSupplier);
    }

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineSupplierBySupplierIds(Long[] supplierIds)
    {
        return hisMedicineSupplierMapper.deleteHisMedicineSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除供应商信息信息
     * 
     * @param supplierId 供应商信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineSupplierBySupplierId(Long supplierId)
    {
        return hisMedicineSupplierMapper.deleteHisMedicineSupplierBySupplierId(supplierId);
    }
}
