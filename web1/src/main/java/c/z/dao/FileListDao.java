package c.z.dao;

import c.z.bean.FileList;

import java.util.List;

/**
 * @author z
 * */
public interface FileListDao {

    /**
     * getFileListAll
     *
     * */
    List<FileList> getFileListAll();

    /**
     * getFileListUserAll
     * @return
     * */
    List<FileList> getFileListUserAll();


}
