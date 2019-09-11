package c.z.service;

import c.z.bean.FileList;

import java.util.List;

/**
 * @author z
 * */
public interface FileListService {

    /**
     * getFileListAll
     * @return List<FileList>
     * */
    List<FileList> getFileListAll();

    /**
     * getFileListUserAll
     * @return
     * */
    List<FileList> getFileListUserAll();
}
