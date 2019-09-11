package cn.itcast.service.impl;

import cn.itcast.dto.OrderDTO;
import cn.itcast.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * codening:utf-8
 *
 * @author :OrderSerivceImpl
 * @time :2019.09.06,19:37
 * @file :cn.itcast.service.impl.OrderSerivceImpl.jave
 */
@Service("orderService")
public class OrderSerivceImpl implements OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 查询单个订单
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    /**
     * 查询订单列表
     *
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    /**
     * 取消订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 完结订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 支付订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
