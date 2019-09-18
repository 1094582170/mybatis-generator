package com.lw.bootdemo.controller;

import com.lw.bootdemo.mapper.read.T1ReadDao;
import com.lw.bootdemo.mapper.read.T2ReadDao;
import com.lw.bootdemo.pojo.db.T2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: langwei
 * @date: 2018-12-01 23:43:54
 **/
@RestController
@RequestMapping({"/home"})
@Slf4j
public class DemoController {

    @Autowired
    private T1ReadDao t1ReadDao;
    @Autowired
    private T2ReadDao t2ReadDao;

    @RequestMapping({"/t1"})
    public String t1(String name) {
        log.info("t1");
        return t1ReadDao.selectAll().toString();
    }

    @PostMapping({"/t2"})
    public List<T2> t2(@RequestBody T2 t2) {
        log.info("t2:{}"+t2);
        return t2ReadDao.select(t2);
    }
}
