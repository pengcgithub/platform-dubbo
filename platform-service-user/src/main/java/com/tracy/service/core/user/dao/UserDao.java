package com.tracy.service.core.user.dao;

import com.tracy.api.user.entity.UserBean;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.service.core.user.dao
 * @since 2018/6/5
 */
public interface UserDao {

    UserBean queryByPhone(long userPhone);

    List<UserBean> queryAll();

    int insertUser(UserBean userBean);

}
