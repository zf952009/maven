package cn.itcast.service.impl;

import cn.itcast.dao.ProductCategoryDaoJpa;
import cn.itcast.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class ProductCategoryServiceImplTest {

    @Autowired
    @Qualifier("productCategoryService")
    private ProductCategoryServiceImpl productCategoryService;

    @Autowired
    private ProductCategoryDaoJpa productCategoryDaoJpa;
    @Test
    public void findOne() {
        ProductCategory one = productCategoryService.findOne(3);
        log.info(String.valueOf(one));
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = productCategoryService.findAll();
        log.info(String.valueOf(all));
    }

    @Test
    public void findBycategoryTypeIn() {
        List<ProductCategory> bycategoryTypeIn = productCategoryService.findBycategoryTypeIn(Arrays.asList(1, 2, 3));
        log.info(String.valueOf(bycategoryTypeIn));
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(1);
        ProductCategory save = productCategoryService.save(productCategory);
        log.info(String.valueOf(save));

    }
}