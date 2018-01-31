/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: UserInfoController.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2018/1/31
 */

package com.ldx.msg.webapp.ctroller;

import com.ldx.msg.webservice.feign.UserInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2018-01-31 14:35
 * @lastdate:
 */

@Controller
@RequestMapping(value = "/user")
public class UserInfoController {
    @Autowired
    private UserInfoClient userInfoClient;

    @RequestMapping(value = "/info")
    @ResponseBody
    public String info(HttpServletRequest request, HttpServletResponse response) {
        return userInfoClient.getUserInfo();
    }
}
