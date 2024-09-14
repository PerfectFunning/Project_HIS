package com.ruoyi;

import com.ruoyi.medicine.domain.HisMedicineFactory;
import com.ruoyi.medicine.service.IHisMedicineFactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Hao
 * @date 2024/8/29
 * @time 上午8:32
 **/
@SpringBootTest
public class MyTest {
    @Autowired
    private IHisMedicineFactoryService hisMedicineFactoryService;

    @Test
    public  void testAdd() {
        HisMedicineFactory hisMedicineFactory=new HisMedicineFactory();
        hisMedicineFactory.setFactoryName("哈药六厂");
        hisMedicineFactory.setFactoryCode("12306");
        hisMedicineFactory.setFactoryAddress("北京");
        hisMedicineFactory.setFactoryPerson("老王");
        hisMedicineFactory.setFactoryPhone("13532261048");
        hisMedicineFactory.setFactoryKeyword("HYLC");
        hisMedicineFactory.setStatus("0");
        int i=hisMedicineFactoryService.insertHisMedicineFactory(hisMedicineFactory);
        System.out.println(i);

    }

}
