package com.tracy.api.user.service;

import com.tracy.api.user.entity.UserBean;
import org.mengyun.tcctransaction.api.Compensable;
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

    void sendMessage(final String msg);

    /**
     * 更新用户余额
     * @param userBean {@link UserBean}
     */
    @Compensable
    void updateUserBalance(UserBean userBean);

}
