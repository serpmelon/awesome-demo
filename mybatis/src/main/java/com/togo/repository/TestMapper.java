package com.togo.repository;

import com.togo.entity.User;

import java.util.Map;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 10:49 下午 2020/4/28
 **/
public interface TestMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(Integer id);
}
