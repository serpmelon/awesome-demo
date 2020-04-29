package com.togo.entity;

import com.togo.asm.MyClassLoader;
import com.togo.repository.UserMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.lang.reflect.Method;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-27 08:23:32
 */
public class User implements Serializable {
    private static final long serialVersionUID = 203996872765838130L;

    private Integer id;
    /**
     * 已经签章的合同下载地址
     */
    private String xx;

    private String appid;

    private String nickname;

    private Integer passtest;

    private String signedPdfUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPasstest() {
        return passtest;
    }

    public void setPasstest(Integer passtest) {
        this.passtest = passtest;
    }

    public String getSignedPdfUrl() {
        return signedPdfUrl;
    }

    public void setSignedPdfUrl(String signedPdfUrl) {
        this.signedPdfUrl = signedPdfUrl;
    }

    public static void main(String[] args) throws Exception {

//        使用类加载器，加载mybatis的配置文件
        InputStream inputStreamXML = Resources.getResourceAsStream("mybatis-config.xml");

        String mapper = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "<mapper namespace=\"com.togo.asm.TestMapper\">\n" +
                "\n" +
                "    <!--查询单个-->\n" +
                "    <select id=\"queryById\" resultType=\"hashmap\">\n" +
                "        select\n" +
                "          id, xx, appid, nickname, passtest, signed_pdf_url\n" +
                "        from wx.user\n" +
                "        where id = #{id}\n" +
                "    </select>\n" +
                "\n" +
                "\n" +
                "</mapper>";
        // 反射获取 main 方法
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

        String sql = configuration.getMappedStatement("com.togo.repository.UserMapper.queryById").getBoundSql(1).getSql();
        System.out.println(sql);

        sqlSessionXML.selectOne(" select id, xx, appid, nickname, passtest, signed_pdf_url from wx.user");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", xx='" + xx + '\'' +
                ", appid='" + appid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", passtest=" + passtest +
                ", signedPdfUrl='" + signedPdfUrl + '\'' +
                '}';
    }
}