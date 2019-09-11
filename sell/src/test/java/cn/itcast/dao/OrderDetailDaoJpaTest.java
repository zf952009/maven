package cn.itcast.dao;

import cn.itcast.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoJpaTest {

    @Autowired
    private OrderDetailDaoJpa orderDetailDaoJpa;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderId("12345555");
        orderDetail.setDetailId("1232");
        orderDetail.setProductId("456789");
        orderDetail.setProductName("邹芳");
        orderDetail.setProductQuantity(1);
        orderDetail.setProductPrice(new BigDecimal(0));
        orderDetail.setProductIcon("http://xxxx/jpg");

        OrderDetail detail = orderDetailDaoJpa.save(orderDetail);
        System.out.println(detail);
    }

    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> orderDetails = orderDetailDaoJpa.findByOrderId("12345555");
        System.out.println(orderDetails);

    }

}