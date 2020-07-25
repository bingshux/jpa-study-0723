package com.zhangtao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javassist.SerialVersionUID;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private Integer state;
    private String code;


    @OneToOne(targetEntity = DriverCard.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",
            insertable = true,updatable = false,nullable = true)
    private DriverCard driverCard;

    //多对一
    @ManyToOne(targetEntity = Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id",referencedColumnName = "id",
                insertable = true,updatable = true,
                nullable = true,
               foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Depart depart;
}
