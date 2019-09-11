package cn.itcast.dao;

import cn.itcast.dataobject.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :ProductCategoryDao
 * @time :2019.09.05,21:14
 * @file :cn.itcast.dao.ProductCategoryDao.jave
 */
@Mapper
@Repository("productCategoryDao")
public interface ProductCategoryDao extends BaseMapper {


    /**
     * 查询所有
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * id查询
     *
     * @param id
     * @return
     */
    ProductCategory findByID(@Param(value = "id") Integer id);

    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    int insert(ProductCategory entity);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    int deleteById(@Param(value = "id") Integer id);

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    int updateById(ProductCategory entity);
}
