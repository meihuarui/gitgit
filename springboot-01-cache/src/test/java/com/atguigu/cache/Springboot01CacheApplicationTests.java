package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串的

    @Test
    public void test2() throws Exception{
        String k3 = stringRedisTemplate.opsForValue().get("k3");
        System.out.println(k3);
    }

    @Test
    public void test() throws Exception{
        stringRedisTemplate.opsForValue().append("k3","git redis");
    }

    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}

