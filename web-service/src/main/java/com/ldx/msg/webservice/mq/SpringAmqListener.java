/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: SpringAmqListener.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 20:37
 * @lastdate:
 */

@Component
public class SpringAmqListener {
    private final static Logger logger = LoggerFactory.getLogger(SpringAmqListener.class);

    @JmsListener(destination = "Test.foo",concurrency = "50")
    public void onMessage(String message){
        try {
            logger.info("SpringAmqListener接收到消息message={}", message);
        } catch (Exception e) {
            logger.error("SpringAmqListener.message={} error:", message,e);
            throw e;
        }
    }
}
