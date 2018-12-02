package com.lw.bootdemo.pojo.db;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "t2")
public class T2 {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "userId")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "userName")
    private String userName;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;
}