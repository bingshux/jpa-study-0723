package com.zhangtao.service;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * 熔断
 */
@Component
public class UserServiceFailBack implements  UserService{
    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        return null;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }
}
