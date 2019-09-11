package cn.itcast.dao;

import cn.itcast.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductInfoDaoJpa
 *
 * @author z
 */
@Repository(value = "productInfoDaoJpa")
public interface ProductInfoDaoJpa extends JpaRepository<ProductInfo, String> {

    /**
     * 根据状态查询
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
