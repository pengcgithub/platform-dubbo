package com.tracy.service.api.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.tracy.service.core.user.dao.UserDao;
import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @since 2018/6/5
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    public List<UserBean> queryUserList(int offset, int limit) {
        PageHelper.startPage(offset, limit); //分页查询
        List<UserBean> userList = userDao.queryAll();
        return userList;
    }

    public UserBean queryByPhone(long userPhone) {
        UserBean user = userDao.queryByPhone(userPhone);
        return user;
    }

    public void sendMessage(final String msg) {
        String destination = jmsTemplate.getDefaultDestinationName();
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
