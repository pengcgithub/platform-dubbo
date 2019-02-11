package com.tracy.service.core.user.dao;

import com.tracy.api.user.entity.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 更新用户余额
     * @param userBean {@link UserBean}
     * @return 更新的条数
     */
    int updateUserBalance(UserBean userBean);

    @Update("update t_user set " +
            "balance = balance - #{amount}, " +
            "freeze_amount= freeze_amount + #{amount} where id = #{id}")
    int updateBalance(UserBean userBean);

    @Update("update t_user set freeze_amount= freeze_amount - #{amount} where id = #{id}")
    int confirmBalance(UserBean userBean);

    @Update("update t_user set balance = balance + #{amount}, " +
            "freeze_amount= freeze_amount -  #{amount} where id = #{id}")
    int cancelBalance(UserBean userBean);

}
