/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: HelloRemoteHystrix.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2018/1/31
 */

package com.ldx.msg.webservice.hystrix;

import com.ldx.msg.webservice.feign.UserInfoClient;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2018-01-31 15:46
 * @lastdate:
 */

@Component
public class UserInfoClientHystrix implements UserInfoClient{

        @Override
        public String getUserInfo() {
            return " this messge send failed ";
        }
}
