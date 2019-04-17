package com.gecx.controller;

import com.gecx.vo.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gecx
 * @Description: TODO
 * @date 2019/4/17 17:50
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand
    public Object get(@PathVariable("name") String name) {
        Users users = new Users();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }

}
