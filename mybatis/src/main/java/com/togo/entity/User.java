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