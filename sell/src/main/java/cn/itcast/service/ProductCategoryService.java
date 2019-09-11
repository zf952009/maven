package cn.itcast.service;

import cn.itcast.dataobject.ProductCategory;

import java.util.List;

/**
 * @author z
 */
public interface ProductCategoryService {

    /**
     * @param id
     * @return
     */
    ProductCategory findOne(Integer id);

    /**
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * @param list
     * @return
     */
    List<ProductCategory> findBycategoryTypeIn(List<Integer> list);

    /**
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);



}
