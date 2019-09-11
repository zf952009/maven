package cn.itcast.dao;

import cn.itcast.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单操作
 *
 * @author z
 */
@Repository("orderMasterDaoJpa")
public interface OrderMasterDaoJpa extends JpaRepository<OrderMaster, String> {

    /**
     * 根据用户微信的openid查询订单
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
