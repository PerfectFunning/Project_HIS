package com.ruoyi.medicine.service;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineSupplier;

/**
 * 供应商信息Service接口
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
public interface IHisMedicineSupplierService 
{
    /**
     * 查询供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 供应商信息
     */
    public HisMedicineSupplier selectHisMedicineSupplierBySupplierId(Long supplierId);

    /**
     * 查询供应商信息列表
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 供应商信息集合
     */
    public List<HisMedicineSupplier> selectHisMedicineSupplierList(HisMedicineSupplier hisMedicineSupplier);

    /**
     * 新增供应商信息
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 结果
     */
    public int insertHisMedicineSupplier(HisMedicineSupplier hisMedicineSupplier);

    /**
     * 修改供应商信息
     * 
     * @param hisMedicineSupplier 供应商信息
     * @return 结果
     */
    public int updateHisMedicineSupplier(HisMedicineSupplier hisMedicineSupplier);

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的供应商信息主键集合
     * @return 结果
     */
    public int deleteHisMedicineSupplierBySupplierIds(Long[] supplierIds);

    /**
     * 删除供应商信息信息
     * 
     * @param supplierId 供应商信息主键
     * @return 结果
     */
    public int deleteHisMedicineSupplierBySupplierId(Long supplierId);
}
