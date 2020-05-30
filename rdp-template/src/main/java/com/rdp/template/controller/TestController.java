package com.rdp.template.controller;
import com.rdp.template.domain.UserMaster;
import com.rdp.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 10011531
 */
@RestController
//@Slf4j需要使用lombok插件
@Slf4j
public class TestController {

    class JsonObj{
        public String userName;
        public String userId;
    }

    @Autowired
    private UserService userService;


    @GetMapping(value = "/testObj")
    public JsonObj testObj() {
        return new JsonObj();
    }


    @GetMapping(value = "/test1")
    public String test1() {
        log.debug("TestController/test1");
        log.debug("罗梯");
        return userService.selectByPrimaryKey("10030753").getUserName();
    }

    @GetMapping(value = "/testInsert")
    public String testInsert() {
        log.debug("TestController/test1");
        UserMaster user = new UserMaster();
        user.setUserId("100203695");
        user.setUserName("罗梯");

        return userService.insertSelective(user) + "";
    }


    @GetMapping(value = "/test1")
    public String testDevops() {
        return "success";
    }


}