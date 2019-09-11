package cn.itcast.mapper;

import cn.itcast.exception.UserException;
import cn.itcast.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserMapper
 * @time :2019.08.15,0:19
 * @file :cn.itcast.mapper.UserMapper.jave
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有user数据
     *
     * @return List<user>
     * @author z
     */
    List<User> findUserAll();

    /**
     * id查询
     *
     * @param userid
     * @return User
     * @author z
     */
    User findUserByID(@Param(value = "userid") Integer userid);

    /**
     * 用户名查询 name精确查询
     *
     * @param username
     * @return user
     * @author z
     */
    User findUserByName(@Param(value = "username") String username);
    /**
     * 对象查询
     *
     * @param user
     * @return List<User>
     * @author z
     * */
    List<User> findUserByObject(User user);

    /**
     * 单条用户数据添加
     *
     * @param user
     * @return
     * @author z
     */
    Integer insertUserOne(User user) throws UserException;

    /**
     * 用户数据批量添加
     * @param lists
     * @author z
     * */
    void insertUserBatch(List<User> lists) throws UserException;

    /**
     * 单条数据修改
     * @param user
     * @author z
     * */
    void updateUserByObject(User user) throws UserException;
}
