package com.tracy.web.module.user.service;

import com.tracy.api.order.entity.OrderBean;
import com.tracy.api.order.service.OrderService;
import com.tracy.api.user.entity.UserBean;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.web.module.user.service
 * @since 2019/2/10
 */
@Service
public class UserServiceMock {

    @Autowired
    private com.tracy.api.user.service.UserService userService;

    @Autowired
    private OrderService orderService;

    @Compensable(confirmMethod = "confirmMockOrder", cancelMethod = "cancelMockOrder")
    public Boolean mockOrder(String userId, String productId, Integer count) {
        // 价格
        BigDecimal price = new BigDecimal(10);

        // 订单
        OrderBean orderBean = new OrderBean();
        Random rand = new Random(25);
        orderBean.setId(rand.nextInt());
        orderBean.setCreateTime(new Date());
        orderBean.setNumber("");
        orderBean.setStatus(1);
        orderBean.setProductId(productId);
        BigDecimal amount = price.multiply(new BigDecimal(count));
        orderBean.setTotalAmount(amount);
        orderBean.setCount(count);
        orderBean.setUserId(userId);

        // 用户余额
        UserBean userBean = new UserBean();
        userBean.setId(userId);
        userBean.setAmount(amount);

        orderService.insertOrder(orderBean);
        userService.updateUserBalance(userBean);

        return Boolean.TRUE;
    }

    public void confirmMockOrder(String userId, String productId, Integer count) {
        System.out.println("confirmMakePayment ===============<<<<<<");
        System.out.println(userId.concat("+").concat(productId).concat("+").concat(String.valueOf(count)));
    }

    public void cancelMockOrder(String userId, String productId, Integer count) {
        System.out.println("cancelMakePayment ===============<<<<<<");
        System.out.println(userId.concat("+").concat(productId).concat("+").concat(String.valueOf(count)));
    }

}
