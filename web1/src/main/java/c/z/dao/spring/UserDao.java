package c.z.dao.spring;

import c.z.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserDao
 * @time :2019.08.20,13:02
 * @file :c.z.dao.mapper.UserDao.jave
 */
@Repository("userSpringDao")
public interface UserDao {

    /**
     * 查询所有数据
     *
     * @return List
     * @author z
     */
    List<User> selectUserAll();
}
