package cn.itcast.mapper;

import cn.itcast.model.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作booktype表底层
 * bookMapper
 *
 * @author z
 */
@Mapper
@Repository("bookTypeMapper")
public interface BookTypeMapper {
    /**
     * 查询所有
     *
     * @return List
     * @author z
     */
    List<BookType> findAll();

    /**
     * 查询总记录数
     *
     * @author z
     */

    Integer count();

    /**
     * id查询
     *
     * @param id
     * @return
     */

    BookType findByID(@Param(value = "id") Integer id);

    /**
     * name查询
     *
     * @param name
     * @return
     */

    BookType findByName(String name);

    /**
     * 根据id删除
     *
     * @param id
     */

    void deleteByID(Integer id);

    /**
     * 根据对象删除
     *
     * @param object
     */
    void deleteByObject(BookType object);

    /**
     * 单个对象保存
     *
     * @param object
     * @return intager
     */
    Integer saveObject(BookType object);

    /**
     * 批量保存
     *
     * @param list
     */

    void saveBatchObject(List<Object> list);
}
