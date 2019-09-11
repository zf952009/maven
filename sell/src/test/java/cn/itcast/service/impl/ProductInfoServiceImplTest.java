package cn.itcast.service.impl;

import cn.itcast.dataobject.ProductInfo;
import cn.itcast.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findById() {
        ProductInfo productInfo = productInfoService.findById("123456");
        System.out.println(productInfo);
    }

    @Test
    public void findAll() {
        List<ProductInfo> all = productInfoService.findAll();
        System.out.println(all);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("北京烤鸭");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("北京烤鸭，非常好吃");
        productInfo.setProductIcon("http://images.jpg");
        productInfo.setProductPrice(new BigDecimal(25.3));
        productInfo.setProductStock(100);
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        ProductInfo info = productInfoService.save(productInfo);
        System.out.println(info);
    }

    @Test
    public void findPageAllTest() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        Iterator<ProductInfo> iterator = all.iterator();
        while (iterator.hasNext()) {
            ProductInfo productInfo = iterator.next();
            System.out.println(productInfo);
        }
    }
}