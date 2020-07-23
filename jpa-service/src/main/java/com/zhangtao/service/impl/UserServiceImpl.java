package com.zhangtao.service.impl;

import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import com.zhangtao.repository.UserRepository;
import com.zhangtao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        //生成分页对象
        Pageable pageable = PageRequest.of(userVo.getPage(), userVo.getPageSize(), Sort.Direction.DESC,"uid" );
        Page<User> userPage = userRepository.findAll(pageable);

        return new MyPageImpl<User>(userPage);
    }
}
