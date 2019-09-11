package c.z.service.spring.impl;

import c.z.dao.spring.UserDao;
import c.z.service.spring.UserService;
import c.z.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.08.20,13:07
 * @file :c.z.service.mapper.impl.UserServiceImpl.jave
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有数据
     *
     * @return List
     * @author z
     */
    @Override
    public List<User> selectUserAll() {
        List<User> list = userDao.selectUserAll();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }
}
