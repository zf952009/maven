package c.z.user.mapper;


import c.z.user.model.User;

import java.util.List;

/**
 * usermapper
 *
 * @author z
 */
public interface UserMapper {

    /**
     * 查询所有
     *
     * @return
     * @author z
     */
    List<User> getUserAll();
}
