package com.zhangtao.entity;

import lombok.Data;

@Data
public class UserVo extends User {
    int page=1;
    int pageSize=3;
}
