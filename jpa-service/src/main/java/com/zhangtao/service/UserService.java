package com.zhangtao.service;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import org.springframework.data.domain.Page;

public interface UserService {
    MyPageImpl<User> list(UserVo userVo);
}
