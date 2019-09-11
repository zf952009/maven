package cn.itcast.dao;

import cn.itcast.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单详情操作
 *
 * @author z
 */
@Repository("orderDetailDaoJpa")
public interface OrderDetailDaoJpa extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查询订单
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
