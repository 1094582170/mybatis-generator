package com.lw.bootdemo.mapper;

import com.lw.bootdemo.pojo.db.Answer;

import java.util.List;

/**
 * @author langwei
 * @date 2019-01-14 09:15:21
 */
public interface AnswerMapper{

    /**
     * 查询
     *
     * @param id
     * @return
     */
    Answer selectById(Integer id);

    /**
     * 查询
     *
     * @param answer
     * @return
     */
    List<Answer> select(Answer answer);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 删除
     *
     * @param answer
     * @return
     */
    int delete(Answer answer);

    /**
     * 插入
     *
     * @param answer
     * @return
     */
    int insert(Answer answer);

    /**
     * 选择性插入数据
     *
     * @param answer
     * @return
     */
    int insertSelective(Answer answer);

    /**
     * 更新
     *
     * @param answer
     * @return
     */
    int update(Answer answer);

    /**
     * 选择性更新
     *
     * @param answer
     * @return
     */
    int updateSelective(Answer answer);

    
}
