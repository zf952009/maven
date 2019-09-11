package cn.itcast.service.spring;

import cn.itcast.model.spring.FileList;

import java.util.List;

/**
 * @author z
 */
public interface FileListService {
    /**
     * user_id 查询
     *
     * @param user_id
     * @return List<FileList>
     * @author z
     */
    List<FileList> getFileListByUserID(Integer user_id);


    /**
     * id查询
     *
     * @param id
     * @return
     * @author z
     */
    FileList getFileListByID(Integer id);

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
