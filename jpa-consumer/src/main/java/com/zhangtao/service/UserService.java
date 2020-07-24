package com.zhangtao.service;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name ="jpa-service")
public interface UserService {
    @RequestMapping("/user/list")
    MyPageImpl<User>  list(@RequestBody UserVo userVo);
    @RequestMapping("/user/del")
    boolean del(@RequestParam(value = "id")Integer id);
    @RequestMapping("/user/add")
    boolean add(@RequestBody User user);
}
