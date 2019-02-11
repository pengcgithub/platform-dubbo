package com.tracy.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <br/>
 *
 * @author pengc
 * @see
 * @since 2018/5/11
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "application.xml" });
        context.start();
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }

}
