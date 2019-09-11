package cn.itcast.service;

import cn.itcast.exception.UserException;
import cn.itcast.mapper.UserMapper;
import cn.itcast.model.User;

import java.util.List;

/**
 * userService 接口
 *
 * @author z
 */
public interface UserService extends UserMapper {

    /**
     * 查询所有用户 user
     *
     * @return List<user>
     * @author z
     */
    @Override
    List<User> findUserAll();

    /**
     * id查询
     *
     * @param userid
     * @return User
     * @author z
     */
    @Override
    User findUserByID(Integer userid);

    /**
     * 用户名查询 name查询
     *
     * @param username
     * @return user
     * @author z
     */
    @Override
    User findUserByName(String username);

    /**
     * 单条用户数据添加
     *
     * @param user
     * @author z
     */
    @Override
    Integer insertUserOne(User user) throws UserException;

    /**
     * 对象查询，对象id不为空时就按照id精确查询，对象username不为空就按照username模糊查询
     *
     * @param user
     * @return List<User>
     * @author z
     */
    @Override
    List<User> findUserByObject(User user);

    /**
     * 用户数据批量添加
     *
     * @param lists
     * @author z
     */
    @Override
    void insertUserBatch(List<User> lists) throws UserException;

    /**
     * 单条数据修改
     *
     * @param user
     * @author z
     */
    @Override
    void updateUserByObject(User user) throws UserException;
}
