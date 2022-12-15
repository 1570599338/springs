package com.lquan.boot.mapper;

import com.lquan.boot.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-12-15 18:12
 **/
@Mapper
public interface CityMapper {

    /**
     * 利用xml形式写sql
     * @param city
     */
    void insertHx(City city);


    /**
     * 利用在xml中写sql形式
     * @param id
     * @return
     */
    City findByIdHx(long id);

    /**
     * 插入数据
     * @param city
     */
    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);


    /**
     * 查询数据
     * @param id
     * @return
     */
    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(long id);


    //**************************混合形式配置**********即使xml和注解形式混合写sql




}
