package cn.itcast.service.spring;

import cn.itcast.model.spring.User;

import java.util.List;

/**
 * @author z
 */
public interface UserService {
    /**
     * 查询所有
     *
     * @return List<User>
     * @author z
     */
    List<User> selectUserAll();

    /**
     * id查询
     *
     * @author z
     */
    User getUserByID(Integer id);

    /**
     * id查询，查询filelist
     *
     * @return List
     * @author z
     */
    List<User> getUserByIDAndFileList();

    /**
     * discriminator 测试
     * 仅用于鉴别器测试
     *
     * @param id
     * @return User
     * @author z
     */
    User discriminatorByIDTest(Integer id);
}
