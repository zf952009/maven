package c.z.service;

import c.z.bean.User;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserService
 * @time :2019.08.10,15:03
 * @file :c.z.service.UserService.jave
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getUserAll();

    /**
     * id获取
     *
     * @param id
     * @return User
     */
    User getUserByID(Integer id);

    /**
     * 用户名查询
     *
     * @param name
     * @return List<User>
     */
    List<User> findUserByName(String name);

    /**
     * id 或者 name查询
     *
     * @param name
     * @param id
     * @return List<User>
     */
    List<User> findUserByIDorName(Integer id, String name);

    /**
     * 用户保存，单个用户保存
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 批量用户保存
     *
     * @param list
     */
    void saveUserList(List<User> list);

    /**
     * 用户数据更新
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * id 删除
     *
     * @param id
     */
    void deleteUserByID(Integer id);

    /**
     * 对象删除
     *
     * @param user
     */
    void deleteUserByUser(User user);

    /**
     * 批量删除 id
     *
     * @param list
     */
    void updateBatchUserDisbled(List<Integer> list);

    /**
     * 批量启用 id
     *
     * @param list
     */
    void updateBatchUserStart(List<Integer> list);

    /**
     * 批量修改
     *
     * @param list
     */
    void updateBatchUser(List<User> list);

    /**
     * 获取总记录数
     *
     * @return count
     */
    Integer getUserCount();
}
