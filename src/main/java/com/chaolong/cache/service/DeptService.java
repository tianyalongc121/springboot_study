package com.chaolong.cache.service;

import com.chaolong.cache.bean.Department;
import com.chaolong.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * Created by Longchao on 2018/5/12
 */
//@CacheConfig(cacheNames = "emp", cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    @Autowired
    DepartmentMapper departmentMapper;

//    @Cacheable(cacheNames = "dept")


    public Department getDeptById(Integer id) {
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getDeptById(id);

        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);

        return department;
    }
}
