package com.ruoyi.web.controller.medicine;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.medicine.domain.HisMedicineFactory;
import com.ruoyi.medicine.service.IHisMedicineFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine/factory")
public class HisMedicineFactoryController extends BaseController {
    //声明业务层属性
    @Autowired
    private IHisMedicineFactoryService hisMedicineFactoryService;

    /**
     * 获取厂家列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisMedicineFactory hisMedicineFactory)
    {
        startPage();
        List<HisMedicineFactory> hisMedicineFactories = hisMedicineFactoryService.selectHisMedicineFactoryList(hisMedicineFactory);
        return getDataTable(hisMedicineFactories);
    }

    /**
     * 获取厂家列表
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:listAll')")
    @GetMapping("/listAll")
    public TableDataInfo listAll(HisMedicineFactory hisMedicineFactory)
    {
        hisMedicineFactory.setStatus("0");
        List<HisMedicineFactory> hisMedicineFactories = hisMedicineFactoryService.selectHisMedicineFactoryList(hisMedicineFactory);
        return getDataTable(hisMedicineFactories);
    }

    /**
     * 根据厂家编号获取详细信
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:query')")
    @GetMapping(value = "/{factoryId}")
    public AjaxResult getInfo(@PathVariable Long factoryId)
    {
        return success(hisMedicineFactoryService.selectHisMedicineFactoryById(factoryId));
    }

    /**
     * 新增厂家
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:add')") //‘*:*:*’
    @Log(title = "生产厂家管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody HisMedicineFactory hisMedicineFactory)
    {

        hisMedicineFactory.setCreateBy(getUsername());
        return toAjax(hisMedicineFactoryService.insertHisMedicineFactory(hisMedicineFactory));
    }

    /**
     * 修改岗位
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:edit')")
    @Log(title = "生产厂家管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody HisMedicineFactory hisMedicineFactory)
    {
        hisMedicineFactory.setUpdateBy(getUsername());
        return toAjax(hisMedicineFactoryService.updateHisMedicineFactory(hisMedicineFactory));
    }
    /**
     * 删除岗位
     */
    @PreAuthorize("@ss.hasPermi('medicine:factory:remove')")
    @Log(title = "生产厂家管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{factoryId}")
    public AjaxResult remove(@PathVariable Long factoryId)
    {
        return toAjax(hisMedicineFactoryService.deleteHisMedicineFactory(factoryId));
    }


}
