package cn.itcast.service.impl;

import cn.itcast.mapper.BookTypeMapper;
import cn.itcast.model.BookType;
import cn.itcast.service.BookTypeService;
import cn.itcast.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :BookTypeServiceImpl
 * @time :2019.08.28,14:50
 * @file :cn.itcast.service.impl.BookTypeServiceImpl.jave
 */
@Service("bookTypeService")
@Transactional(rollbackFor = Exception.class)
public class BookTypeServiceImpl implements BookTypeService {


    @Autowired
    @Qualifier("bookTypeMapper")
    private BookTypeMapper bookTypeMapper;

    /**
     * 查询所有
     *
     * @return List
     * @author z
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BookType> findAll() {
        List<BookType> all = bookTypeMapper.findAll();
        int size = all.size();
        if (size >= 1) {
            return all;
        }
        return null;
    }

    /**
     * 查询总记录数
     *
     * @author z
     */
    @Override
    public Integer count() {

        return bookTypeMapper.count();
    }

    /**
     * id查询
     *
     * @param id
     * @return
     */
    @Override
    public BookType findByID(Integer id) {
        BookType bookType = bookTypeMapper.findByID(id);
        if (!ObjectUtils.isEmpty(bookType)) {
            return bookType;
        }
        return null;
    }

    /**
     * name查询
     *
     * @param name
     * @return
     */
    @Override
    public BookType findByName(String name) {
        return null;
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void deleteByID(Integer id) {

    }

    /**
     * 根据对象删除
     *
     * @param object
     */
    @Override
    public void deleteByObject(BookType object) {

    }

    /**
     * 单个对象保存
     *
     * @param object
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Integer saveObject(BookType object) {
        return bookTypeMapper.saveObject(object);
    }

    /**
     * 批量保存
     *
     * @param list
     */
    @Override
    public void saveBatchObject(List<Object> list) {

    }
}
