package z.f.dao;

import z.f.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * */
    List<User> getUserAll();
}
