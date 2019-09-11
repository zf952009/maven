package cn.itcast.service.spring.impl;

import cn.itcast.mapper.spring.UserMapper;
import cn.itcast.model.spring.User;
import cn.itcast.service.spring.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.08.20,14:17
 * @file :cn.itcast.service.mapper.impl.UserServiceImpl.jave
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    /**
     * 查询所有
     *
     * @return List<User>
     * @author z
     */
    @Override
    public List<User> selectUserAll() {
        List<User> list = userMapper.selectUserAll();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }

    /**
     * id查询
     *
     * @param id
     * @author z
     */
    @Override
    public User getUserByID(Integer id) {
        User user = userMapper.getUserByID(id);
        return user;
    }

    /**
     * id查询，查询filelist
     *
     * @param
     * @author z
     */
    @Override
    public List<User> getUserByIDAndFileList() {
        List<User> list = userMapper.getUserByIDAndFileList();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }

    /**
     * discriminator 测试
     * 仅用于鉴别器测试
     *
     * @param id
     * @return User
     * @author z
     */
    @Override
    public User discriminatorByIDTest(Integer id) {
        return userMapper.discriminatorByIDTest(id);
    }
}
