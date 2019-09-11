package cn.itcast.mapper;

import cn.itcast.model.Book;
import cn.itcast.query.QueryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * bookMapper
 *
 * @author z
 */
@Mapper
@Repository("bookMapper")
public interface BookMapper extends QueryMapper {
    /**
     * 查询所有
     *
     * @return List
     * @author z
     */
    @Override
    List<Book> findAll();

    /**
     * 查询总记录数
     *
     * @author z
     */
    @Override
    Integer count();

    /**
     * id查询
     *
     * @param id
     * @return
     */
    @Override
    Book findByID(@Param(value = "id") Integer id);

    /**
     * name查询
     *
     * @param name
     * @return
     */
    @Override
    List<Book> findByName(@Param(value = "name") String name);

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    void deleteByID(Integer id);

    /**
     * 根据对象删除
     *
     * @param object
     */
    @Override
    void deleteByObject(Object object);

    /**
     * 单个对象保存
     *
     * @param object
     */
    Integer saveObject(Book object);

    /**
     * 批量保存
     *
     * @param list
     */
    @Override
    void saveBatchObject(List<Object> list);
}
