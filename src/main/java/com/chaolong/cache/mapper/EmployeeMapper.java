package com.chaolong.cache.mapper;

import com.chaolong.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by Longchao on 2018/5/11
 */
@Repository
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName}, email=#{email},gender=#{gender}, d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName, email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);
}




