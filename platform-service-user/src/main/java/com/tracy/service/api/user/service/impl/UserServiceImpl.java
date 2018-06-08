package com.tracy.service.api.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.tracy.service.core.user.dao.UserDao;
import com.tracy.api.user.entity.UserBean;
import com.tracy.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<UserBean> queryUserList(int offset, int limit) {
        PageHelper.startPage(offset, limit); //分页查询
        List<UserBean> userList = userDao.queryAll();
        return userList;
    }

    public UserBean queryByPhone(long userPhone) {
        UserBean user = userDao.queryByPhone(userPhone);
        return user;
    }
}
