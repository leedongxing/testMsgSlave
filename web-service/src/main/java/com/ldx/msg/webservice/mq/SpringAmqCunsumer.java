/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: SpringAmqCunsumer.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 20:22
 * @lastdate:
 */

@Component
public class SpringAmqCunsumer {

    @Resource
    private JmsTemplate jmsTemplate;

    private String des = "Test.foo";
    private String desTopic = "Test.topic";

    public String recive(){
        String text = null;
        try {
             jmsTemplate.setPubSubDomain(true);
            TextMessage tm = (TextMessage)jmsTemplate.receive(des);
            text = tm.getText();
        } catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    public String getDes() {
        return des;
    }
}
