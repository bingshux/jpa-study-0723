package com.zhangtao.service;

import com.zhangtao.entity.Depart;
import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    MyPageImpl<User> list(UserVo userVo);

    boolean del(Integer id);

    boolean add(User user);
    //获取部门列表
    List<Depart> listDeparts();
}
