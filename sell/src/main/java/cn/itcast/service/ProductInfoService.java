package cn.itcast.service;

import cn.itcast.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author z
 */
public interface ProductInfoService {

    /**
     * id查询
     *
     * @param id
     * @return
     */
    ProductInfo findById(String id);

    /**
     * 查询所有
     *
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 查询上架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 单个保存
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);
}
