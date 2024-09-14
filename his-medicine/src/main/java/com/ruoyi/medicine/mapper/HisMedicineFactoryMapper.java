package com.ruoyi.medicine.mapper;

import com.ruoyi.medicine.domain.HisMedicineFactory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HisMedicineFactoryMapper {
    //1. 按照条件查询厂家信息
    List<HisMedicineFactory> selectHisMedicineFactoryList(HisMedicineFactory hisMedicineFactory);
    //2. 根据Id查询厂家信息
    HisMedicineFactory selectHisMedicineFactoryById(Long id);
    //3. 新增厂家信息
    int insertHisMedicineFactory(HisMedicineFactory hisMedicineFactory);
    //4. 修改厂家信息
    int updateHisMedicineFactory(HisMedicineFactory hisMedicineFactory);
    //5. 删除厂家信息
    int deleteHisMedicineFactory(Long id);
}
