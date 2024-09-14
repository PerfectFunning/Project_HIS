package com.ruoyi.medicine.service;

import java.util.List;
import com.ruoyi.medicine.domain.HisMedicineDrug;
import com.ruoyi.medicine.mapper.HisMedicineDrugMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品信息Service接口
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
public interface IHisMedicineDrugService 
{
    /**
     * 查询药品信息
     * 
     * @param drugId 药品信息主键
     * @return 药品信息
     */
    public HisMedicineDrug selectHisMedicineDrugByDrugId(Long drugId);

    /**
     * 查询药品信息列表
     * 
     * @param hisMedicineDrug 药品信息
     * @return 药品信息集合
     */
    public List<HisMedicineDrug> selectHisMedicineDrugList(HisMedicineDrug hisMedicineDrug);

    /**
     * 新增药品信息
     * 
     * @param hisMedicineDrug 药品信息
     * @return 结果
     */
    public int insertHisMedicineDrug(HisMedicineDrug hisMedicineDrug);

    /**
     * 修改药品信息
     * 
     * @param hisMedicineDrug 药品信息
     * @return 结果
     */
    public int updateHisMedicineDrug(HisMedicineDrug hisMedicineDrug);

    /**
     * 批量删除药品信息
     * 
     * @param drugIds 需要删除的药品信息主键集合
     * @return 结果
     */
    public int deleteHisMedicineDrugByDrugIds(Long[] drugIds);

    /**
     * 删除药品信息信息
     * 
     * @param drugId 药品信息主键
     * @return 结果
     */
    public int deleteHisMedicineDrugByDrugId(Long drugId);

    int updateDrugStatusService();
}
