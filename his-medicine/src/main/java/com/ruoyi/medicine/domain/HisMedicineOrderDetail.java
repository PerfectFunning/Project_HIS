package com.ruoyi.medicine.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单详情信息对象 his_medicine_order_detail
 * 
 * @author ruoyi
 * @date 2024-09-01
 */
public class HisMedicineOrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 详情ID */
    private Long detailId;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long drugId;

    /** 数量 */
    @Excel(name = "数量")
    private Long detailNum;

    /** 药品单价 */
    @Excel(name = "药品单价")
    private Double detailMoney;

    /** 批次号 */
    @Excel(name = "批次号")
    private String detailBatch;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** （0正常 1 禁用） */
    @Excel(name = "", readConverterExp = "0=正常,1=,禁=用")
    private String status;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setDetailNum(Long detailNum) 
    {
        this.detailNum = detailNum;
    }

    public Long getDetailNum() 
    {
        return detailNum;
    }
    public void setDetailMoney(Double detailMoney) 
    {
        this.detailMoney = detailMoney;
    }

    public Double getDetailMoney() 
    {
        return detailMoney;
    }
    public void setDetailBatch(String detailBatch) 
    {
        this.detailBatch = detailBatch;
    }

    public String getDetailBatch() 
    {
        return detailBatch;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
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
            .append("detailId", getDetailId())
            .append("drugId", getDrugId())
            .append("detailNum", getDetailNum())
            .append("detailMoney", getDetailMoney())
            .append("detailBatch", getDetailBatch())
            .append("orderId", getOrderId())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
