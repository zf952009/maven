package cn.itcast.service.impl;

import cn.itcast.dao.ProductInfoDaoJpa;
import cn.itcast.dataobject.ProductInfo;
import cn.itcast.enums.ProductStatusEnum;
import cn.itcast.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * codening:utf-8
 *
 * @author :ProductInfoServiceImpl
 * @time :2019.09.06,0:22
 * @file :cn.itcast.service.impl.ProductInfoServiceImpl.jave
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    @Qualifier("productInfoDaoJpa")
    private ProductInfoDaoJpa productInfoDaoJpa;

    @Override
    public ProductInfo findById(String id) {
        Optional<ProductInfo> productInfo = productInfoDaoJpa.findById(id);
        if (productInfo.isPresent()) {
            return productInfo.get();
        }
        return null;
    }

    @Override
    public List<ProductInfo> findAll() {
        List<ProductInfo> all = productInfoDaoJpa.findAll();
        if (all.size() >= 1) {
            return all;
        }
        return null;
    }

    /**
     * 单个保存
     *
     * @param productInfo
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        ProductInfo info = productInfoDaoJpa.save(productInfo);
        if (info != null || !"".equals(productInfo)) {
            return info;
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> page = productInfoDaoJpa.findAll(pageable);
        return page;
    }

    /**
     * 查询上架商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> infos = productInfoDaoJpa.findByProductStatus(ProductStatusEnum.UP.getCode());
        if (infos.size() >= 1) {
            return infos;
        }
        return null;
    }
}
