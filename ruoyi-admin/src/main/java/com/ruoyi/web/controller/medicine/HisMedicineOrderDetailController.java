package com.ruoyi.web.controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.medicine.domain.HisMedicineOrderDetail;
import com.ruoyi.medicine.service.IHisMedicineOrderDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单详情信息Controller
 * 
 * @author ruoyi
 * @date 2024-09-11
 */
@RestController
@RequestMapping("/medicine/detail")
public class HisMedicineOrderDetailController extends BaseController
{
    @Autowired
    private IHisMedicineOrderDetailService hisMedicineOrderDetailService;

    /**
     * 查询订单详情信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        startPage();
        List<HisMedicineOrderDetail> list = hisMedicineOrderDetailService.selectHisMedicineOrderDetailList(hisMedicineOrderDetail);
        return getDataTable(list);
    }

    /**
     * 导出订单详情信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:export')")
    @Log(title = "订单详情信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        List<HisMedicineOrderDetail> list = hisMedicineOrderDetailService.selectHisMedicineOrderDetailList(hisMedicineOrderDetail);
        ExcelUtil<HisMedicineOrderDetail> util = new ExcelUtil<HisMedicineOrderDetail>(HisMedicineOrderDetail.class);
        util.exportExcel(response, list, "订单详情信息数据");
    }

    /**
     * 获取订单详情信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(hisMedicineOrderDetailService.selectHisMedicineOrderDetailByDetailId(detailId));
    }

    /**
     * 新增订单详情信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:add')")
    @Log(title = "订单详情信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        return toAjax(hisMedicineOrderDetailService.insertHisMedicineOrderDetail(hisMedicineOrderDetail));
    }

    /**
     * 修改订单详情信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:edit')")
    @Log(title = "订单详情信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisMedicineOrderDetail hisMedicineOrderDetail)
    {
        return toAjax(hisMedicineOrderDetailService.updateHisMedicineOrderDetail(hisMedicineOrderDetail));
    }

    /**
     * 删除订单详情信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:detail:remove')")
    @Log(title = "订单详情信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(hisMedicineOrderDetailService.deleteHisMedicineOrderDetailByDetailIds(detailIds));
    }
}
