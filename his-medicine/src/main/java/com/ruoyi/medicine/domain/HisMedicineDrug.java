package com.ruoyi.medicine.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品信息对象 his_medicine_drug
 *
 * @author ruoyi
 * @date 2024-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HisMedicineDrug extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private HisMedicineFactory hisMedicineFactory;
    /**
     * 药品ID
     */
    private Long drugId;

    /**
     * 药品名称
     */
    @Excel(name = "药品名称")
    private String drugName;

    /**
     * 药品编码
     */
    @Excel(name = "药品编码")
    private String drugCode;

    /**
     * 药品关键字
     */
    @Excel(name = "药品关键字")
    private String drugKeyword;

    /**
     * 生产厂家ID
     */
    @Excel(name = "生产厂家ID")
    private Long factoryId;

    /**
     * 药品类型
     */
    @Excel(name = "药品类型")
    private String drugType;

    /**
     * 处方类型
     */
    @Excel(name = "处方类型")
    private String drugPrescription;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String drugUnit;

    /**
     * 销售价格--预留字段
     */
    @Excel(name = "销售价格--预留字段")
    private Double drugPrice;

    /**
     * 库存数量
     */
    @Excel(name = "库存数量")
    private Long drugNum;

    //购物车选中药品数量
    private Long cartDrugNum;

    /**
     * 预警值
     */
    @Excel(name = "预警值")
    private Long drugWarn;

    private String drugStatus;
    /**
     * （0正常 1 禁用）
     */
    @Excel(name = "", readConverterExp = "0=正常,1=,禁=用")
    private String status;

}
