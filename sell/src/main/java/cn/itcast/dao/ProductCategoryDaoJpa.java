package cn.itcast.dao;

import cn.itcast.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :ProductCategoryDaoJpa
 * @time :2019.09.05,22:01
 * @file :cn.itcast.dao.ProductCategoryDaoJpa.jave
 */
@Repository("productCategoryDaoJpa")
public interface ProductCategoryDaoJpa extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findBycategoryTypeIn(List<Integer> list);

    List<ProductCategory> findByCategoryNameIn(List<String> list);

}
