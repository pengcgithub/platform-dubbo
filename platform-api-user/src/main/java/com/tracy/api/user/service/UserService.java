package com.tracy.api.user.service;

import com.tracy.api.user.entity.UserBean;
import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.api.user.service
 * @since 2018/6/5
 */
public interface UserService {

    List<UserBean> queryUserList(int offset, int limit);

    UserBean queryByPhone(long userPhone);

}
