package cn.itcast.mapper.spring;


import cn.itcast.model.spring.FileList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author z
 */
@Repository("fileListMapper")
@Mapper
public interface FileListMapper {

    /**
     * id查询
     *
     * @param id
     * @return
     * @author z
     */
    FileList getFileListByID(@Param(value = "id") Integer id);

    /**
     * user_id 查询
     *
     * @param user_id
     * @return List<FileList>
     * @author z
     */
    List<FileList> getFileListByUserID(@Param(value = "user_id") Integer user_id);

    /**
     * 查询所有
     *
     * @return List<FileList>
     * @author z
     */
    List<FileList> selectFileListAll();

    /**
     * 查询所有filelist和user
     *
     * @return List<FileList>
     * @author z
     */
    List<FileList> selectFileListAndUserAll();

    /**
     * 查询所有filelist和user
     * 使用分步查询
     *
     * @return List<FileList>
     * @author z
     */
    List<FileList> selectFileListAndUserAll1();
}
