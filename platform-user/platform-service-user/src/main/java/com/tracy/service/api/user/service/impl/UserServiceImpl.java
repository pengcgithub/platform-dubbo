package com.tracy.service.api.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.tracy.service.core.user.dao.UserDao;
import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

//    @Resource(name="jmsTemplate")
//    private JmsTemplate jmsTemplate;

    static AtomicInteger confirmCount = new AtomicInteger(0);

    @Override
    public List<UserBean> queryUserList(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        List<UserBean> userList = userDao.queryAll();
        return userList;
    }

    @Override
    public UserBean queryByPhone(long userPhone) {
        UserBean user = userDao.queryByPhone(userPhone);
        return user;
    }

    @Override
    public void sendMessage(final String msg) {
//        String destination = jmsTemplate.getDefaultDestinationName();
//        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
//        jmsTemplate.send(new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(msg);
//            }
//        });
    }

    @Override
    @Compensable(confirmMethod = "confirmBalance", cancelMethod = "cancelBalance", transactionContextEditor = DubboTransactionContextEditor.class)
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUserBalance(UserBean userBean) {

//        try {
//            throw new Exception("mock user score");
//        } catch (Exception e) {
//             System.out.println("异常错误");
//            throw new RuntimeException(e);
//        }

        try {
            userDao.updateBalance(userBean);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmBalance(UserBean userBean) {
        System.out.println("confirm score========================>"+userBean.getAmount()+"<======================");
        userDao.confirmBalance(userBean);
        final int i = confirmCount.incrementAndGet();
        System.out.println("调用了account confrim " + i + " 次");
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelBalance(UserBean userBean) {
        System.out.println("cancel score========================>"+userBean.getAmount()+"<=======================");
        userDao.cancelBalance(userBean);
    }
}
