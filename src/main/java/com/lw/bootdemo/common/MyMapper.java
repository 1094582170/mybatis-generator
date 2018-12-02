package com.lw.bootdemo.common;

import com.lw.bootdemo.provider.MyProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 自定义一个mapper,实现动态sql
 *
 * @author: langwei
 * @date: 2018-12-02 17:26:07
 **/
public interface MyMapper<T> {
    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param clazz
     * @param id
     * @return
     */
    @SelectProvider(type = MyProvider.class, method = "selectOneById")
    T selectOneById(@Param("clazz") Class<T> clazz, @Param("id") int id);

    /**
     * 根据实体中的属性进行查询 and 连接
     *
     * @param t
     * @return
     */
    @SelectProvider(type = MyProvider.class, method = "select")
    List<T> select(@Param("t") T t);
}
