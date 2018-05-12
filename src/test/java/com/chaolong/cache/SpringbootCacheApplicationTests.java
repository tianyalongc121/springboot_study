package com.chaolong.cache;

import com.chaolong.cache.bean.Employee;
import com.chaolong.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	RedisTemplate redisTemplate; //k-v都是对象

	@Autowired
	StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串

	@Autowired
	RedisTemplate<Object, Employee> employeeRedisTemplate;


	@Test
	public void test01() {
//		stringRedisTemplate.opsForValue().append("msg", "hello");
//		stringRedisTemplate.opsForValue().append("msg", " world");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

		stringRedisTemplate.opsForList().leftPush("mylist", "1");
		stringRedisTemplate.opsForList().leftPush("mylist", "2");

	}

	@Test
	public void test02() {

		Employee empById = employeeMapper.getEmpById(1);
		employeeRedisTemplate.opsForValue().set("emp-01", empById);
	}

	@Test
	public void contextLoads() {
		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}

}
