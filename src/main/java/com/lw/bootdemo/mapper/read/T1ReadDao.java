package com.lw.bootdemo.mapper.read;

import com.lw.bootdemo.common.ReadMapper;
import com.lw.bootdemo.pojo.db.T1;

public interface T1ReadDao extends ReadMapper<T1> {
    /**
     * 查询名称
     * @param t1
     * @return
     */
    String selectName(T1 t1);
}