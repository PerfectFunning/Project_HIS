package com.ruoyi.medicine.service.impl;

import com.ruoyi.medicine.domain.HisMedicineFactory;
import com.ruoyi.medicine.mapper.HisMedicineFactoryMapper;
import com.ruoyi.medicine.service.IHisMedicineFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HisMedicineFactoryServiceImpl implements IHisMedicineFactoryService {

    //声明mapper层属性
    @Autowired
    private HisMedicineFactoryMapper hisMedicineFactoryMapper;

    @Override
    public List<HisMedicineFactory> selectHisMedicineFactoryList(HisMedicineFactory hisMedicineFactory) {
        return hisMedicineFactoryMapper.selectHisMedicineFactoryList(hisMedicineFactory);
    }

    @Override
    public HisMedicineFactory selectHisMedicineFactoryById(Long id) {
        return hisMedicineFactoryMapper.selectHisMedicineFactoryById(id);
    }

    @Override
    public int insertHisMedicineFactory(HisMedicineFactory hisMedicineFactory) {
        return hisMedicineFactoryMapper.insertHisMedicineFactory(hisMedicineFactory);
    }

    @Override
    public int updateHisMedicineFactory(HisMedicineFactory hisMedicineFactory) {
        return hisMedicineFactoryMapper.updateHisMedicineFactory(hisMedicineFactory);
    }

    @Override
    public int deleteHisMedicineFactory(Long id) {
        return hisMedicineFactoryMapper.deleteHisMedicineFactory(id);
    }
}
