package com.lw.bootdemo.common;

import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;

/**
 * @author: langwei
 * @date: 2018-12-01 23:18:04
 **/
public interface ReadMapper<T> extends BaseSelectMapper<T>, SelectByExampleMapper<T>, SelectOneByExampleMapper<T>, SelectCountByExampleMapper<T> {
}
