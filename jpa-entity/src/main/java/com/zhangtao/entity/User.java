package com.zhangtao.entity;

import javassist.SerialVersionUID;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "hg_user1")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    @Temporal(TemporalType.TIMESTAMP)
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String sex;
    private Integer state;
    private String code;
}
