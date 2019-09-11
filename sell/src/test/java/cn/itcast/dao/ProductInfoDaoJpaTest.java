package cn.itcast.dao;

import cn.itcast.dataobject.ProductInfo;
import cn.itcast.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductInfoDaoJpaTest {

    @Autowired
    @Qualifier("productInfoDaoJpa")
    private ProductInfoDaoJpa productInfoDaoJpa;

    @Test
    public void findAllTest() {
        List<ProductInfo> all = productInfoDaoJpa.findAll();
        System.out.println(all);
    }

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("北京烤鸭");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("北京烤鸭，非常好吃");
        productInfo.setProductIcon("http://images.jpg");
        productInfo.setProductPrice(new BigDecimal(25.3));
        productInfo.setProductStock(100);
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        ProductInfo productInfo1 = new ProductInfo();
        productInfo1.setProductId("456789");
        productInfo1.setProductName("北京烤鸭");
        productInfo1.setCategoryType(1);
        productInfo1.setProductDescription("北京烤鸭，非常好吃");
        productInfo1.setProductIcon("http://images.jpg");
        productInfo1.setProductPrice(new BigDecimal(25.3));
        productInfo1.setProductStock(100);
        productInfo1.setProductStatus(ProductStatusEnum.DOWN.getCode());

        ProductInfo info = productInfoDaoJpa.save(productInfo);
        ProductInfo info1 = productInfoDaoJpa.save(productInfo1);
        System.out.println(info);
        System.out.println(info1);
    }

    @Test
    public void findProductStatusTest() {
        List<ProductInfo> status = productInfoDaoJpa.findByProductStatus(ProductStatusEnum.UP.getCode());
        System.out.println(status);
        List<ProductInfo> status1 = productInfoDaoJpa.findByProductStatus(ProductStatusEnum.DOWN.getCode());
        System.out.println(status1);

    }
}