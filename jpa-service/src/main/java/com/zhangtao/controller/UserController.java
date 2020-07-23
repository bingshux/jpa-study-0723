package com.zhangtao.controller;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import com.zhangtao.repository.UserRepository;
import com.zhangtao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("testaa")
    public String testAdd() throws ParseException {
        User hgUser = new User();
        hgUser.setUid(1);
        hgUser.setUsername("zzzz");
        hgUser.setPassword("6zz666");
        hgUser.setName("张三zzz");
        hgUser.setEmail("1322zzz2@qq.com");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2020-12-12 20:20:50";
        Date date = simpleDateFormat.parse(String.valueOf(str));
        hgUser.setBirthday(date);
        hgUser.setSex("男");
        hgUser.setTelephone("1324567892");
        hgUser.setCode("1");
        hgUser.setState(0);
        userRepository.save(hgUser);
        return "ok";
    }
    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo userVo)   {
        MyPageImpl<User> page =  userService.list(userVo);
       return page;
    }
}
