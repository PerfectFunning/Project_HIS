package com.ruoyi.medicine.mapper;

import com.ruoyi.medicine.domain.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Hao
 * @date 2024/9/2
 * @time 下午4:08
 **/
@Mapper
public interface HisMedicineCartMapper {
    //根据用户id查询购物车信息
    /*@Select("select * from his_medicine_cart where userId=#{userId}")*/
    Cart selectHisMedicineCartByUserId(Long userId);

    //新增购物车
    /*@Insert("insert into his_medicine_cart values(default,#{userId},#{cart},#{remark})")*/
    int insertCartInfoMapper(Cart cart);

    //更新购物车
    /*@Update("update his_medicine_cart set cart=#{cart} where id=#{id}")*/
    int updateCartInfoMapper(Cart cart);
}
