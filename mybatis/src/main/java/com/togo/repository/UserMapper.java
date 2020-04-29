package com.togo.repository;

import com.togo.entity.User;
import com.togo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * (User)表数据库访问层
 *
 * @author taiyn
 * @since 2020-04-27 08:22:20
 */
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    @SelectProvider(value = UserService.class, method = "select")
    Map selectDyn(SQL sql, Map<String, Object> parameterMap);
}