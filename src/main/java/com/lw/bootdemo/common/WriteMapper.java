package com.lw.bootdemo.common;

import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.example.DeleteByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * @author: langwei
 * @date: 2018-12-01 22:51:39
 **/
public interface WriteMapper<T> extends BaseInsertMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, DeleteByExampleMapper<T>, UpdateByExampleMapper<T>, UpdateByExampleSelectiveMapper<T> {
}
