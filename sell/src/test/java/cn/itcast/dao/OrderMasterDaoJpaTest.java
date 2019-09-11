package cn.itcast.dao;

import cn.itcast.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Iterator;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderMasterDaoJpaTest {

    @Autowired
    private OrderMasterDaoJpa orderMasterDaoJpa;


    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("买家测试7");
        orderMaster.setBuyerPhone("12345612345");
        orderMaster.setBuyerAddress("2收货地址2");
        orderMaster.setBuyerOpenid("654321");
        orderMaster.setOrderAmount(new BigDecimal(19.3));
        OrderMaster master = orderMasterDaoJpa.save(orderMaster);
        System.out.println(master);
    }

    @Test
    public void findByBuyerOpenidTest() {

        PageRequest pageRequest = new PageRequest(0, 2);

        Page<OrderMaster> page = orderMasterDaoJpa.findByBuyerOpenid("123456", pageRequest);

        Iterator<OrderMaster> iterator = page.iterator();
        while (iterator.hasNext()) {
            OrderMaster master = iterator.next();
            System.out.println(master);
        }

    }
}