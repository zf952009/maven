package cn.itcast.dao;

import cn.itcast.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class ProductCategoryDaoTest {

    @Autowired
    @Qualifier("productCategoryDao")
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findAllTest() {

        List<ProductCategory> all = productCategoryDao.findAll();
        log.info(String.valueOf(all));
    }

    @Test
    public void findByIDTest() {
        ProductCategory productCategory = productCategoryDao.findByID(1);
        log.info(String.valueOf(productCategory));
    }
}