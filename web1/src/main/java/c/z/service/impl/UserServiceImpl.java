package c.z.service.impl;

import c.z.bean.User;
import c.z.dao.UserDao;
import c.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.08.10,15:09
 * @file :c.z.service.impl.UserServiceImpl.jave
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * id获取
     *
     * @param id
     * @return User
     */
    @Override
    public User getUserByID(Integer id) {
        return userDao.getUserByID(id);
    }

    /**
     * 用户名查询
     *
     * @param name
     * @return List<User>
     */
    @Override
    public List<User> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     * id 或者 name查询
     *
     * @param id
     * @param name
     * @return List<User>
     */
    @Override
    public List<User> findUserByIDorName(Integer id, String name) {
        return userDao.findUserByIDorName(id,name);
    }

    /**
     * 用户保存，单个用户保存
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    /**
     * 批量用户保存
     *
     * @param list
     */
    @Override
    public void saveUserList(List<User> list) {
        userDao.saveUserList(list);
    }

    /**
     * 用户数据更新
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * id 删除
     *
     * @param id
     */
    @Override
    public void deleteUserByID(Integer id) {
        userDao.deleteUserByID(id);
    }

    /**
     * 对象删除
     *
     * @param user
     */
    @Override
    public void deleteUserByUser(User user) {
        userDao.deleteUserByUser(user);
    }

    /**
     * 批量删除 id
     *
     * @param list
     */
    @Override
    public void updateBatchUserDisbled(List<Integer> list) {
        userDao.updateBatchUserDisbled(list);
    }

    /**
     * 批量启用 id
     *
     * @param list
     */
    @Override
    public void updateBatchUserStart(List<Integer> list) {
        userDao.updateBatchUserStart(list);
    }

    /**
     * 批量修改
     *
     * @param list
     */
    @Override
    public void updateBatchUser(List<User> list) {
        userDao.updateBatchUser(list);
    }
    @Override
    public List<User> getUserAll() {
        return userDao.getUserAll();
    }

    /**
     * 获取总记录数
     *
     * @return count
     */
    @Override
    public Integer getUserCount() {
        return userDao.getUserCount();
    }
}
