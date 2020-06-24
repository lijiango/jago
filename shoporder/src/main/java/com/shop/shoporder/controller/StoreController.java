package com.shop.shoporder.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.pool.ValidConnectionChecker;
// import com.shop.shoporder.bean.Department;
// import com.shop.shoporder.service.DeptService;
import com.shop.shoporder.service.lib.RedisStringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController
public class StoreController {

    @Autowired
    RedisStringService redisStringService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @ResponseBody
    @RequestMapping(value = "/request/data",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String testpostjson(HttpServletRequest request) {

        //获取到JSONObject
        JSONObject jsonParam = this.getJSONParam(request);

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "request");
        result.put("data", jsonParam);

        return result.toJSONString();
    }

    /**
     * 创建日期:2018年4月6日<br/>
     * 代码创建:黄聪<br/>
     * 功能描述:通过request来获取到json数据<br/>
     * @param request
     * @return
     */
    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }

    @GetMapping("/getStore/{id}")
    public String getStore(@PathVariable("id") String id)
    {
        String Key = "itemstore:" + id;

        return redisStringService.get(Key);
    }

    @GetMapping("/setStore/{id}")
    public String setStore(@PathVariable("id") String id,String val)
    {
        // Map<String, String[]> params = httpRequest.getParameterMap();
        // String id = params['id'];
        String Key = "itemstore:" + id;

        return redisStringService.set(Key,val);
    }

    @GetMapping("/addStore/{id}")
    public Long addStore(@PathVariable("id") String id,Long val)
    {
        String Key = "itemstore:" + id;

        Long rt =  redisStringService.increment(Key,val);
        return rt;
    }

    
    @GetMapping("/minusStore/{id}")
    public Long minusStore(@PathVariable("id") String id,Long val)
    {
        String Key = "itemstore:" + id;
         Long rt =  redisStringService.decrement(Key,val);
         if(rt >= 0){
            return rt;
         }else{
            redisStringService.increment(Key,val);
            return rt;
         }
    }


}
