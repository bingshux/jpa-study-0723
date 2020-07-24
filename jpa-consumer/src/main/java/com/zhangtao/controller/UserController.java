package com.zhangtao.controller;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import com.zhangtao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("list")
    public MyPageImpl<User> list( UserVo userVo){
        return  userService.list(userVo);
    }
    @RequestMapping("del")
    public boolean del(@RequestParam(value = "id") Integer id){
        return  userService.del(id);
    }
    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return  userService.add(user);
    }
}
