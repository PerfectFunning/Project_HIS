package com.ruoyi.medicine.domain;

import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 采购信息对象 his_medicine_order
 * 
 * @author ruoyi
 * @date 2024-08-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HisMedicineOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNum;

    /** 制单人 */
    @Excel(name = "制单人")
    private Long orderPerson;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    private HisMedicineSupplier supplier;
    /** 订单总金额 */
    @Excel(name = "订单总金额")
    private Long orderMoney;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** （0正常 1 禁用） */
    private String status;

    /*
    * 存储订单详情
    * */
    private List<HisMedicineOrderDetail> details;

    //制单人id
    private SysUser user;
}
