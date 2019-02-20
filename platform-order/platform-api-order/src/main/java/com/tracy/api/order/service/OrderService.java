package com.tracy.api.order.service;

import com.tracy.api.order.entity.OrderBean;
import org.mengyun.tcctransaction.api.Compensable;
import java.util.List;

/**
 * 订单服务<br/>
 *
 * @author pengc
 * @see com.tracy.api.order.service
 * @since 2019/2/9
 */
public interface OrderService {

    List<OrderBean> listOrder();

    @Compensable
    void insertOrder(OrderBean orderBean);

    int updateOrder(OrderBean orderBean);

}
