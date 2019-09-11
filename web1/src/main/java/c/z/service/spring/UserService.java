package c.z.service.spring;

import c.z.user.model.User;

import java.util.List;

/**
 * @author z
 */
public interface UserService {
    /**
     * 查询所有数据
     *
     * @return List
     * @author z
     */
    List<User> selectUserAll();
}
