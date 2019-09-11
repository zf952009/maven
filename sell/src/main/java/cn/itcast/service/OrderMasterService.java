package cn.itcast.service;

import cn.itcast.dataobject.OrderMaster;

import java.util.List;

/**
 * 订单service
 *
 * @author z
 */
public interface OrderMasterService {

    /**
     * 单个对象保存
     *
     * @param orderMaster
     * @return
     */
    OrderMaster save(OrderMaster orderMaster);

    /**
     * 查询所有
     *
     * @return
     */
    List<OrderMaster> findAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    OrderMaster findById(Integer id);
}
