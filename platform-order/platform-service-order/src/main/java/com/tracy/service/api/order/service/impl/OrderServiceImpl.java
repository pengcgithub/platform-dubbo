package com.tracy.service.api.order.service.impl;

import com.tracy.api.order.entity.OrderBean;
import com.tracy.api.order.service.OrderService;
import com.tracy.service.core.order.dao.OrderDao;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.service.api.order.service.impl
 * @since 2019/2/9
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderBean> listOrder() {
        return orderDao.queryAll();
    }

    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder", transactionContextEditor = DubboTransactionContextEditor.class)
    @Transactional(rollbackFor = Exception.class)
    public void insertOrder(OrderBean orderBean) {
        try {
            orderDao.insertOrder(orderBean);
            System.out.println("try insert order========>"+orderBean.getStatus()+"<=================");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int updateOrder(OrderBean orderBean) {
        return orderDao.updateOrderStatus(orderBean);
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmOrder(OrderBean orderBean) {
        orderBean.setStatus(3);
        orderDao.updateOrderStatus(orderBean);
//        orderDao.confirmOrderStatus(orderBean);
        System.out.println("confirm order==============>"+orderBean.getId()+"<================");
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelOrder(OrderBean orderBean) {
        orderBean.setStatus(2);
        orderDao.updateOrderStatus(orderBean);
        System.out.println("cancel order==============>"+orderBean.getId()+"<================");
    }
}
