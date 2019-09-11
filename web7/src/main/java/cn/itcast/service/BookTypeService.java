package cn.itcast.service;

import cn.itcast.model.BookType;

import java.util.List;

/**
 * @author z
 */
public interface BookTypeService {
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

    BookType findByID(Integer id);

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