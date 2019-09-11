package cn.itcast.service.impl;

import cn.itcast.dao.OrderMasterDaoJpa;
import cn.itcast.dataobject.OrderMaster;
import cn.itcast.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :OrderMasterServiceImpl
 * @time :2019.09.06,12:29
 * @file :cn.itcast.service.impl.OrderMasterServiceImpl.jave
 */
@Service("orderMasterService")
public class OrderMasterServiceImpl implements OrderMasterService {


    @Autowired
    @Qualifier("orderMasterDaoJpa")
    private OrderMasterDaoJpa orderMasterDaoJpa;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<OrderMaster> findAll() {
        List<OrderMaster> all = orderMasterDaoJpa.findAll();
        if (all.size() >= 1) {
            return all;
        }
        return null;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public OrderMaster findById(Integer id) {
        return null;
    }

    /**
     * 单个对象保存
     *
     * @param orderMaster
     * @return
     */
    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return null;
    }
}
