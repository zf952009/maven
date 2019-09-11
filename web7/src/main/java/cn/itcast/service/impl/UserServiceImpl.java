package cn.itcast.service.impl;

import cn.itcast.exception.UserException;
import cn.itcast.mapper.UserMapper;
import cn.itcast.model.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.08.15,0:31
 * @file :cn.itcast.service.impl.UserServiceImpl.jave
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户 user
     *
     * @return List<user>
     * @author z
     */
    @Override
    public List<User> findUserAll() {
        List<User> list = userMapper.findUserAll();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * id查询
     *
     * @param userid
     * @return User
     * @author z
     */
    @Override
    public User findUserByID(Integer userid) {
        return userMapper.findUserByID(userid);
    }

    /**
     * 用户名查询 name查询
     *
     * @param username
     * @return user
     * @author z
     */
    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    /**
     * 单条用户数据添
     * 插入之前数据判断
     *
     * @param user
     * @author z
     */
    @Override
    public Integer insertUserOne(User user) throws UserException {
        String username = user.getUsername();
        if (user.getUsername() == null || "".equals(user.getUsername())) {
            throw new UserException("username is empty");
        }
        if (user.getUserpassword() == null || "".equals(user.getUserpassword())) {
            throw new UserException("userpassword is empty");
        }
        User userByName = userMapper.findUserByName(username);
        if (userByName != null || "".equals(userByName)) {
            throw new UserException("username exists");
        }
        return userMapper.insertUserOne(user);
    }

    /**
     * 对象查询
     *
     * @param user
     * @return List<User>
     * @author z
     */
    @Override
    public List<User> findUserByObject(User user) {
        List<User> list = userMapper.findUserByObject(user);
        Integer size = list.size();
        if (size >= 1) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 用户数据批量添加
     * 待实现
     * int size = lists.size();
     * for (int i = 0; i < size; i++) {
     * User user = lists.get(i);
     * if (user.getUsername() == null || "".equals(user.getUsername())) {
     * throw new UserException("username is empty");
     * }
     * if (user.getUserpassword() == null || "".equals(user.getUserpassword())) {
     * throw new UserException("userpassword is empty");
     * }
     * User userByName = userMapper.findUserByName(user.getUsername());
     * if (userByName != null || "".equals(userByName)) {
     * throw new UserException("username exists");
     * }
     * }
     * <p>
     * userMapper.insertUserBatch(lists);
     *
     * @param lists
     * @author z
     */
    @Override
    public void insertUserBatch(List<User> lists) throws UserException {

    }

    /**
     * 单条数据修改
     *
     * @param user
     * @author z
     */
    @Override
    public void updateUserByObject(User user) throws UserException {
        Integer userid = user.getUserid();
        if (userid!=null){
            throw new UserException("userid is empty");
        }
        User user1 = findUserByID(userid);
        if (user1!=null || "".equals(user1)){

        }
    }
}
