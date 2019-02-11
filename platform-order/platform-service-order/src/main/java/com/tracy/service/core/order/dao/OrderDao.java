package com.tracy.service.core.order.dao;

import com.tracy.api.order.entity.OrderBean;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.service.core.order.dao
 * @since 2019/2/9
 */
public interface OrderDao {

    @Select("SELECT id, create_time AS createTime, number, `status`, product_id AS productId, total_amount AS totalAmount, count, user_id AS userId FROM `order`")
    List<OrderBean> queryAll();

    int insertOrder(OrderBean orderBean);

    /**
     * 更新订单状态</br>
     * @param orderBean {@link OrderBean 订单}
     * @return 更新的条数
     */
    int updateOrderStatus(OrderBean orderBean);

    @Update("UPDATE `order`  `status` = #{status} WHERE id = #{id}")
    int confirmOrderStatus(OrderBean orderBean);

}
