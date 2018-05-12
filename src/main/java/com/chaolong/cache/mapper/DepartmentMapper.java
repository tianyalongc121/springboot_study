package com.chaolong.cache.mapper;

import com.chaolong.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Longchao on 2018/5/11
 */
@Repository
@Mapper
public interface DepartmentMapper {


    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

}
