package com.shop.shoporder.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.pool.ValidConnectionChecker;
// import com.shop.shoporder.bean.Department;
// import com.shop.shoporder.service.DeptService;
import com.shop.shoporder.service.RedisStringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@RestController
public class StoreController {

    @Autowired
    RedisStringService redisStringService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @GetMapping("/getStore/{id}")
    public String getStore(@PathVariable("id") String id)
    {
        return redisStringService.get(id);
    }

    @GetMapping("/addStore/{id}")
    public String setStore(@PathVariable("id") String id,String val)
    {
        // Map<String, String[]> params = httpRequest.getParameterMap();
        // String id = params['id'];
        return redisStringService.set(id,val);
    }

    // @PostMapping("/minusStore/")
    // public Department minusStore(Department department){
    //     deptService.insertDept(department);
    //      return department;
    // }
}
