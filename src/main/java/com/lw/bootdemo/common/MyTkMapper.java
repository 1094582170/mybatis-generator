package com.lw.bootdemo.common;

import com.lw.bootdemo.provider.MyTkProvider;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author: langwei
 * @date: 2018-12-02 22:44:57
 **/
@RegisterMapper
public interface MyTkMapper<T> {
    /**
     * 根据实体中的属性进行查询，or 连接
     *
     * @param record
     * @return
     */
    @SelectProvider(type = MyTkProvider.class, method = "dynamicSQL")
    List<T> selectOr(T record);
}
