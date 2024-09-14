package com.ruoyi.web.controller.medicine;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.medicine.domain.HisMedicineFactory;
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
import com.ruoyi.medicine.domain.HisMedicineSupplier;
import com.ruoyi.medicine.service.IHisMedicineSupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@RestController
@RequestMapping("/medicine/supplier")
public class HisMedicineSupplierController extends BaseController
{
    @Autowired
    private IHisMedicineSupplierService hisMedicineSupplierService;

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisMedicineSupplier hisMedicineSupplier)
    {
        startPage();
        List<HisMedicineSupplier> list = hisMedicineSupplierService.selectHisMedicineSupplierList(hisMedicineSupplier);
        return getDataTable(list);
    }

    /**
     * 获取供应商列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:listAll')")
    @GetMapping("/listAll")
    public TableDataInfo listAll(HisMedicineSupplier hisMedicineSupplier)
    {
        hisMedicineSupplier.setStatus("0");
        List<HisMedicineSupplier> list = hisMedicineSupplierService.selectHisMedicineSupplierList(hisMedicineSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:export')")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisMedicineSupplier hisMedicineSupplier)
    {
        List<HisMedicineSupplier> list = hisMedicineSupplierService.selectHisMedicineSupplierList(hisMedicineSupplier);
        ExcelUtil<HisMedicineSupplier> util = new ExcelUtil<HisMedicineSupplier>(HisMedicineSupplier.class);
        util.exportExcel(response, list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId)
    {
        return success(hisMedicineSupplierService.selectHisMedicineSupplierBySupplierId(supplierId));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisMedicineSupplier hisMedicineSupplier)
    {
        return toAjax(hisMedicineSupplierService.insertHisMedicineSupplier(hisMedicineSupplier));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisMedicineSupplier hisMedicineSupplier)
    {
        return toAjax(hisMedicineSupplierService.updateHisMedicineSupplier(hisMedicineSupplier));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:supplier:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplierIds}")
    public AjaxResult remove(@PathVariable Long[] supplierIds)
    {
        return toAjax(hisMedicineSupplierService.deleteHisMedicineSupplierBySupplierIds(supplierIds));
    }
}
