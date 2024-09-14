package com.ruoyi.medicine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hao
 * @date 2024/9/2
 * @time 下午3:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long id;
    private Long userId;
    private String cart;
    private String remark;
}
