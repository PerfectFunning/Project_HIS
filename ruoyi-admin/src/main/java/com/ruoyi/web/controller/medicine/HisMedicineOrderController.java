package com.ruoyi.web.controller.medicine;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.medicine.domain.HisMedicineOrder;
import com.ruoyi.medicine.service.IHisMedicineOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-31
 */
@RestController
@RequestMapping("/medicine/order")
public class HisMedicineOrderController extends BaseController
{
    @Autowired
    private IHisMedicineOrderService hisMedicineOrderService;

    /**
     * 查询采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisMedicineOrder hisMedicineOrder)
    {
        startPage();
        hisMedicineOrder.setOrderPerson(getUserId());
        List<HisMedicineOrder> list = hisMedicineOrderService.selectHisMedicineOrderList(hisMedicineOrder);
        return getDataTable(list);
    }

    /**
     * 导出采购信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:export')")
    @Log(title = "采购信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisMedicineOrder hisMedicineOrder)
    {
        List<HisMedicineOrder> list = hisMedicineOrderService.selectHisMedicineOrderList(hisMedicineOrder);
        ExcelUtil<HisMedicineOrder> util = new ExcelUtil<HisMedicineOrder>(HisMedicineOrder.class);
        util.exportExcel(response, list, "采购信息数据");
    }

    /**
     * 获取采购信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(hisMedicineOrderService.selectHisMedicineOrderByOrderId(orderId));
    }

    /**
     * 新增采购信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:add')")
    @Log(title = "采购管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Map<String,Object> map) throws JsonProcessingException {
        Long userId = getUserId();
        return toAjax(hisMedicineOrderService.insertHisMedicineOrder(map,userId));
    }

    /**
     * 修改采购信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:edit')")
    @Log(title = "采购信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisMedicineOrder hisMedicineOrder)
    {
        return toAjax(hisMedicineOrderService.updateHisMedicineOrder(hisMedicineOrder));
    }

    /**
     * 删除采购信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:order:remove')")
    @Log(title = "采购信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(hisMedicineOrderService.deleteHisMedicineOrderByOrderIds(orderIds));
    }
}
