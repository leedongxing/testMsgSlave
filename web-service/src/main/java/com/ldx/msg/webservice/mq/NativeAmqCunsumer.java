/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: NativeAmqCunsumer.java project: test-msg-slave
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 15:47
 * @lastdate:
 */

@Component
public class NativeAmqCunsumer {
    @Value("${spring.activemq.broker-url}")
    private String url;

    private String des = "Test.foo";
    private String desTopic = "Test.topic";

    public String recive(){
        String text = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(des);

            MessageConsumer consumer = session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) consumer.receive(1000);
                if(textMessage != null){
                    text += textMessage.getText() + "n/";
                }else {
                    break;
                }
            }
            consumer.close();
            session.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }
    public String reciveTopic(){
        String text = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic  topic  = session.createTopic(desTopic);

            MessageConsumer consumer = session.createConsumer(topic);

            // Wait for a message
            MessageListener listner = new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        if (message instanceof TextMessage) {
                            TextMessage textMessage = (TextMessage) message;
                            System.out.println("Received message"
                                    + textMessage.getText() + "'");
                        }
                    } catch (JMSException e) {
                        System.out.println("Caught:" + e);
                        e.printStackTrace();
                    }
                }
            };

            consumer.setMessageListener(listner);

            consumer.close();
            session.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }
}
