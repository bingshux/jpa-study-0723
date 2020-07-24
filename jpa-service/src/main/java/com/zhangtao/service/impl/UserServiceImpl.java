package com.zhangtao.service.impl;


import com.zhangtao.entity.MyPageImpl;
import com.zhangtao.entity.User;
import com.zhangtao.entity.UserVo;
import com.zhangtao.repository.UserRepository;
import com.zhangtao.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public MyPageImpl<User> list(UserVo userVo) {

        Specification<User> specification = new Specification<User>() {
            //动态的生成查询条件
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                //根据username  生成查询条件
                if (!StringUtils.isEmpty(userVo.getUsername())) {
                    Predicate predicate = criteriaBuilder.like(root.get("username"), "%" + userVo.getUsername() + "%");
                    //查询条件保存到集合中
                    list.add(predicate);
                }
                if (!StringUtils.isEmpty(userVo.getName())) {
                    Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + userVo.getName() + "%");
                    //查询条件保存到集合中
                    list.add(predicate);
                }
                if (userVo.getSex() != 0) {
                    Predicate predicate = criteriaBuilder.equal(root.get("sex"), userVo.getSex());
                    //查询条件保存到集合中
                    list.add(predicate);
                }
                //获取条件的数组
                Predicate[] predicates = list.toArray(new Predicate[list.size()]);
                //把前述的所有条件组成
                Predicate predicateAll = criteriaBuilder.and(predicates);
                return predicateAll;
            }
        };
        //生成分页对象
        Pageable pageable = PageRequest.of(userVo.getPage() - 1, userVo.getPageSize(), Sort.Direction.DESC, "uid");
        // Page<User> userPage = userRepository.findAll(pageable);
        // return new MyPageImpl<User>();
        //使用动态sql 查询的结果
        Page<User> page = userRepository.findAll(specification, pageable);
        return new MyPageImpl<User>(page);
    }

    @Override
    public boolean del(Integer id) {
        try {
            userRepository.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(User user) {
     //   User user1 = userRepository.saveAndFlush(user);
        User user1 = userRepository.save(user);
        try {
            if (user1.getUid() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
