package cn.itcast.dao;

import cn.itcast.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class ProductCategoryDaoJpaTest {

    @Autowired
    private ProductCategoryDaoJpa productCategoryDaoJpa;

    @Test
    public void findOneTest() {
        List<ProductCategory> all = productCategoryDaoJpa.findAll();
        log.info(String.valueOf(all));
        ProductCategory category = productCategoryDaoJpa.findById(1).get();
        log.info(String.valueOf(category));

    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("邹芳最爱");
        productCategory.setCategoryType(2);
        Integer id = productCategoryDaoJpa.save(productCategory).getCategoryId();
        log.info(String.valueOf(id));
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = productCategoryDaoJpa.findById(1).get();
        productCategory.setCategoryType(3);
        ProductCategory category = productCategoryDaoJpa.save(productCategory);
        Assert.assertNotNull(category);
        Assert.assertNotEquals(null, category);
    }

    @Test
    public void findBycategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<ProductCategory> list1 = productCategoryDaoJpa.findBycategoryTypeIn(list);
        log.info(String.valueOf(list1));
    }

    @Test
    public void findBycaAndCategoryNameInTest(){
        List<String> list = Arrays.asList("1","2");
        List<ProductCategory> bycaAndCategoryNameIn = productCategoryDaoJpa.findByCategoryNameIn(list);
        log.info(String.valueOf(bycaAndCategoryNameIn));
    }


}