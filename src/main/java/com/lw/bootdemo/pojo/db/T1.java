package com.lw.bootdemo.pojo.db;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "t1")
public class T1 {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;
}