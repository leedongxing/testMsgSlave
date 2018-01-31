/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: UserInforClient.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2018/1/31
 */

package com.ldx.msg.webservice.feign;

import com.ldx.msg.webservice.hystrix.UserInfoClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2018-01-31 14:29
 * @lastdate:
 */
@FeignClient(name = "${test.msg.master}",fallback = UserInfoClientHystrix.class)
public interface UserInfoClient {

    @RequestMapping(value = "/user/info")
    String getUserInfo();
}
