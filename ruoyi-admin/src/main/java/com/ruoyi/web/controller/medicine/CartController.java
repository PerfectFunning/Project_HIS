package com.ruoyi.web.controller.medicine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.medicine.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hao
 * @date 2024/9/2
 * @time 下午3:42
 **/
@RestController
@RequestMapping("medicine/cart")
public class CartController extends BaseController {
    //声明购物车业务层
    @Autowired
    private ICartService cartService;


    /**
     * 删除药品信息
     */
    @DeleteMapping("/{drugIds}")
    public AjaxResult remove(@PathVariable Long[] drugIds) throws JsonProcessingException {
        //获取当前用户的id
        Long userId = getUserId();
        return toAjax(cartService.deleteCartOptionByIds(userId,drugIds));
    }

    //声明单元方法 更新采购数量
    @PutMapping("/{drugId}/{cartDrugNum}")
    public AjaxResult updateNum(@PathVariable Long drugId, @PathVariable Long cartDrugNum) throws JsonProcessingException {
        Long userId = getUserId();
        return toAjax(cartService.updateCartNumService(userId,drugId,cartDrugNum));
    }

    //声明单元方法 我的采购 查询购物车里的采购信息
    @GetMapping("list")
    public AjaxResult myCart() throws JsonProcessingException {
        //获取当前用户的id
        Long userId = getUserId();
        return success(cartService.myCartListService(userId));
    }

    //声明单元方法：加入购物车 获取要加入购物车的药品id
    @PreAuthorize("@ss.hasPermi('medicine:cart:add')")
    @Log(title = "购物车信息", businessType = BusinessType.DELETE)
    @PostMapping("/{drugIds}")
    public AjaxResult addCart(@PathVariable Long[] drugIds) throws JsonProcessingException {
        //获取当前用户id
        Long userId = getUserId();
        return toAjax(cartService.addCart(userId, drugIds));
    }
}
