package cn.itcast.mapper.spring;

import cn.itcast.model.spring.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserMapper
 * @time :2019.08.20,14:13
 * @file :cn.itcast.mapper.mapper.UserMapper.jave
 */
@Repository("userMapper")
public interface UserMapper {
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
     * @return
     * @author z
     */
    User getUserByID(@Param(value = "id") Integer id);


    /**
     * id查询，查询filelist
     * @return
     * @author z
     * */
    List<User> getUserByIDAndFileList();

    /**
     * discriminator 测试
     * 仅用于鉴别器测试
     * @param id
     * @return User
     * @author z
     * */
    User discriminatorByIDTest(@Param(value = "id")Integer id);
}
