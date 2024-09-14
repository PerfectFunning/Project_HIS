package com.ruoyi.medicine.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.medicine.domain.HisMedicineDrug;
import com.ruoyi.medicine.mapper.HisMedicineDrugMapper;
import com.ruoyi.medicine.service.IHisMedicineDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-29
 */
@Service
public class HisMedicineDrugServiceImpl implements IHisMedicineDrugService {
    @Autowired
    private HisMedicineDrugMapper hisMedicineDrugMapper;

    /**
     * 查询药品信息
     *
     * @param drugId 药品信息主键
     * @return 药品信息
     */
    @Override
    public HisMedicineDrug selectHisMedicineDrugByDrugId(Long drugId) {
        return hisMedicineDrugMapper.selectHisMedicineDrugByDrugId(drugId);
    }

    /**
     * 查询药品信息列表
     *
     * @param hisMedicineDrug 药品信息
     * @return 药品信息
     */
    @Override
    public List<HisMedicineDrug> selectHisMedicineDrugList(HisMedicineDrug hisMedicineDrug) {
        return hisMedicineDrugMapper.selectHisMedicineDrugList(hisMedicineDrug);
    }

    /**
     * 新增药品信息
     *
     * @param hisMedicineDrug 药品信息
     * @return 结果
     */
    @Override
    public int insertHisMedicineDrug(HisMedicineDrug hisMedicineDrug) {
        hisMedicineDrug.setCreateTime(DateUtils.getNowDate());
        return hisMedicineDrugMapper.insertHisMedicineDrug(hisMedicineDrug);
    }

    /**
     * 修改药品信息
     *
     * @param hisMedicineDrug 药品信息
     * @return 结果
     */
    @Override
    public int updateHisMedicineDrug(HisMedicineDrug hisMedicineDrug) {
        hisMedicineDrug.setUpdateTime(DateUtils.getNowDate());
        return hisMedicineDrugMapper.updateHisMedicineDrug(hisMedicineDrug);
    }

    /**
     * 批量删除药品信息
     *
     * @param drugIds 需要删除的药品信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineDrugByDrugIds(Long[] drugIds) {
        return hisMedicineDrugMapper.deleteHisMedicineDrugByDrugIds(drugIds);
    }

    /**
     * 删除药品信息信息
     *
     * @param drugId 药品信息主键
     * @return 结果
     */
    @Override
    public int deleteHisMedicineDrugByDrugId(Long drugId) {
        return hisMedicineDrugMapper.deleteHisMedicineDrugByDrugId(drugId);
    }

    @Override
    public int updateDrugStatusService() {
        System.out.println("定时任务启动！");
        return hisMedicineDrugMapper.updateDrugStatusMapper();
    }
}
