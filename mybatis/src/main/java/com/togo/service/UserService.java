package com.togo.service;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 9:00 上午 2020/4/27
 **/
public class UserService {

    public String select(SQL sql, Map<String, Object> parameterMap) {

        return "select\n" +
                "          id, xx, appid, nickname, passtest, signed_pdf_url\n" +
                "        from wx.user\n" +
                "        where id = '1'";
    }
}
