package com.ruoyi.medicine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商信息对象 his_medicine_supplier
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HisMedicineSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商ID */
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商联系人 */
    @Excel(name = "供应商联系人")
    private String supplierPerson;

    /** 供应商方式 */
    @Excel(name = "供应商方式")
    private String supplierPhone;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String supplierBank;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplierAddress;

    /** （0正常 1 禁用） */
    @Excel(name = "", readConverterExp = "0=正常,1=,禁=用")
    private String status;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierPerson(String supplierPerson) 
    {
        this.supplierPerson = supplierPerson;
    }

    public String getSupplierPerson() 
    {
        return supplierPerson;
    }
    public void setSupplierPhone(String supplierPhone) 
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone() 
    {
        return supplierPhone;
    }
    public void setSupplierBank(String supplierBank) 
    {
        this.supplierBank = supplierBank;
    }

    public String getSupplierBank() 
    {
        return supplierBank;
    }
    public void setSupplierAddress(String supplierAddress) 
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() 
    {
        return supplierAddress;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("supplierPerson", getSupplierPerson())
            .append("supplierPhone", getSupplierPhone())
            .append("supplierBank", getSupplierBank())
            .append("supplierAddress", getSupplierAddress())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
