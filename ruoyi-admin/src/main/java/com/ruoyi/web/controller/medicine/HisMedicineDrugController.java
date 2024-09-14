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
import com.ruoyi.medicine.domain.HisMedicineDrug;
import com.ruoyi.medicine.service.IHisMedicineDrugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@RestController
@RequestMapping("/medicine/drug")
public class HisMedicineDrugController extends BaseController
{
    @Autowired
    private IHisMedicineDrugService hisMedicineDrugService;

    /**
     * 查询药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisMedicineDrug hisMedicineDrug)
    {
        startPage();
        List<HisMedicineDrug> list = hisMedicineDrugService.selectHisMedicineDrugList(hisMedicineDrug);
        return getDataTable(list);
    }

    /**
     * 导出药品信息列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:export')")
    @Log(title = "药品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisMedicineDrug hisMedicineDrug)
    {
        List<HisMedicineDrug> list = hisMedicineDrugService.selectHisMedicineDrugList(hisMedicineDrug);
        ExcelUtil<HisMedicineDrug> util = new ExcelUtil<HisMedicineDrug>(HisMedicineDrug.class);
        util.exportExcel(response, list, "药品信息数据");
    }

    /**
     * 获取药品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:query')")
    @GetMapping(value = "/{drugId}")
    public AjaxResult getInfo(@PathVariable("drugId") Long drugId)
    {
        return success(hisMedicineDrugService.selectHisMedicineDrugByDrugId(drugId));
    }

    /**
     * 新增药品信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:add')")
    @Log(title = "药品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisMedicineDrug hisMedicineDrug)
    {
        return toAjax(hisMedicineDrugService.insertHisMedicineDrug(hisMedicineDrug));
    }

    /**
     * 修改药品信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:edit')")
    @Log(title = "药品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisMedicineDrug hisMedicineDrug)
    {
        return toAjax(hisMedicineDrugService.updateHisMedicineDrug(hisMedicineDrug));
    }

    /**
     * 删除药品信息
     */
    @PreAuthorize("@ss.hasPermi('medicine:drug:remove')")
    @Log(title = "药品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugIds}")
    public AjaxResult remove(@PathVariable Long[] drugIds)
    {
        return toAjax(hisMedicineDrugService.deleteHisMedicineDrugByDrugIds(drugIds));
    }


}
