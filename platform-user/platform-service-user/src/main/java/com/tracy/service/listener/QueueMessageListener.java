package com.tracy.service.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 队列消息的监控<br/>
 *
 * @author pengc
 * @see com.tracy.service.listener
 * @since 2018/7/3
 */
public class QueueMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
