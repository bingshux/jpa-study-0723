package com.zhangtao.controller;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import com.zhangtao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin(allowedHeaders = )
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo userVo){
        return  userService.list(userVo);
    }
}
