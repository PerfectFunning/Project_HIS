package com.ruoyi.medicine.service;

import com.ruoyi.medicine.domain.HisMedicineFactory;

import java.util.List;

public interface IHisMedicineFactoryService {
    //1. 动态查询厂家信息
    List<HisMedicineFactory> selectHisMedicineFactoryList(HisMedicineFactory hisMedicineFactory);
    //2. 根据Id查询厂家信息
    HisMedicineFactory selectHisMedicineFactoryById(Long id);
    //3. 新增厂家
    int insertHisMedicineFactory(HisMedicineFactory hisMedicineFactory);
    //4. 修改厂家
    int updateHisMedicineFactory(HisMedicineFactory hisMedicineFactory);
    //5. 删除厂家
    int deleteHisMedicineFactory(Long id);
}
