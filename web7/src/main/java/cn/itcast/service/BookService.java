package cn.itcast.service;

import cn.itcast.model.Book;

import java.util.List;

/**
 * bookService
 *
 * @author z
 */
public interface BookService {
    /**
     * 查询所有
     *
     * @return List
     * @author z
     */

    List findAll();

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

    Book findByID(Integer id);

    /**
     * name查询
     *
     * @param name
     * @return
     */

    List<Book> findByName(String name);

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

    void saveBatchObject(List<Object> list);
}
