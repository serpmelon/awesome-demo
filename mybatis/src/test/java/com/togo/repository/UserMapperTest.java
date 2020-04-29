package com.togo.repository;

import com.togo.asm.MyClassLoader;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void queryById() throws Exception {

//        使用类加载器，加载mybatis的配置文件

        String mapper = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "<mapper namespace=\"com.togo.asm.TestMapper\">\n" +
                "\n" +
                "    <select id=\"queryById\" resultType=\"hashmap\">\n" +
                "        select\n" +
                "          id, xx, appid, nickname, passtest\n" +
                "        from wx.user\n" +
                "        where id = #{id}\n" +
                "    </select>\n" +
                "\n" +
                "\n" +
                "</mapper>";

        InputStream inputStreamXML = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactoryXML = new SqlSessionFactoryBuilder().build(inputStreamXML);
        SqlSession sqlSessionXML = sqlSessionFactoryXML.openSession();
        UserMapper userMapper = sqlSessionXML.getMapper(UserMapper.class);
        System.out.println("xml : " + userMapper.queryById(1));

        InputStream inputStream = new ByteArrayInputStream(mapper.getBytes());
        Configuration configuration = sqlSessionFactoryXML.getConfiguration();

        ErrorContext.instance().resource("resource");
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, "resource", configuration.getSqlFragments());
        mapperParser.parse();
        // 生成二进制字节码
        byte[] bytes = MyClassLoader.dump();

        // 使用自定义的ClassLoader
        MyClassLoader cl = new MyClassLoader();
        // 加载我们生成的 HelloWorld 类
        Class<?> clazz = cl.defineClass("com.togo.asm.TestMapper", bytes);
        configuration.addMapper(clazz);

        Method query = clazz.getMethod("queryById", Integer.class);
        Object testMapper = sqlSessionXML.getMapper(clazz);
        Object result = query.invoke(testMapper, 1);

        System.out.println("dyn : " + result);
    }
}