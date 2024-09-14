package com.ruoyi.medicine.mapper;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineSupplier;
import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@Mapper
public interface HisMedicineSupplierMapper 
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
     * 删除供应商信息
     * 
     * @param supplierId 供应商信息主键
     * @return 结果
     */
    public int deleteHisMedicineSupplierBySupplierId(Long supplierId);

    /**
     * 批量删除供应商信息
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisMedicineSupplierBySupplierIds(Long[] supplierIds);
}
