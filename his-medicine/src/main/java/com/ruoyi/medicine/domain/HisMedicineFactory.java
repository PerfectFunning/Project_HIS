package com.ruoyi.medicine.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HisMedicineFactory extends BaseEntity {
    private Long factoryId;
    private String factoryName;
    private String factoryCode;
    private String factoryPerson;
    private String factoryPhone;
    private String factoryKeyword;
    private String factoryAddress;
    private String status;
}
