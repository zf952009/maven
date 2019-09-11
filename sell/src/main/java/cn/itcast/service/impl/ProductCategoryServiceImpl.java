package cn.itcast.service.impl;

import cn.itcast.dao.ProductCategoryDaoJpa;
import cn.itcast.dataobject.ProductCategory;
import cn.itcast.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 类目service
 * codening:utf-8
 *
 * @author :ProductCategoryServiceImpl
 * @time :2019.09.05,23:02
 * @file :cn.itcast.service.impl.ProductCategoryServiceImpl.jave
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    @Qualifier("productCategoryDaoJpa")
    private ProductCategoryDaoJpa productCategoryDaoJpa;

    /**
     * @param id
     * @return
     */
    @Override
    public ProductCategory findOne(Integer id) {
        Optional<ProductCategory> productCategorys = productCategoryDaoJpa.findById(id);
        if (productCategorys.isPresent()) {
            return productCategorys.get();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> all = productCategoryDaoJpa.findAll();
        if (all.size() >= 1) {
            return all;
        }
        return null;
    }

    /**
     * @param list
     * @return
     */
    @Override
    public List<ProductCategory> findBycategoryTypeIn(List<Integer> list) {
        List<ProductCategory> categoryList = productCategoryDaoJpa.findBycategoryTypeIn(list);
        if (categoryList.size() >= 1) {
            return categoryList;
        }
        return null;
    }

    /**
     * @param productCategory
     * @return
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategory save = productCategoryDaoJpa.save(productCategory);
        if (save != null || !"".equals(save)) {
            return save;
        }
        return null;
    }
}

