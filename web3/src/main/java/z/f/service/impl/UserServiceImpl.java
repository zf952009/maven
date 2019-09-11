package z.f.service.impl;

import z.f.bean.User;
import z.f.service.UserService;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserServiceImpl
 * @time :2019.08.11,12:35
 * @file :z.f.service.impl.UserServiceImpl.jave
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUserAll() {
        System.out.println("userServiceImpl run ...");
        return null;
    }
}
