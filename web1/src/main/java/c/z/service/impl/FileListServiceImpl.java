package c.z.service.impl;

import c.z.bean.FileList;
import c.z.dao.FileListDao;
import c.z.service.FileListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.08.11,23:36
 * @file :c.z.service.impl.FileListServiceImpl.jave
 */
@Repository("fileListService")
public class FileListServiceImpl implements FileListService {
    @Autowired
    private FileListDao fileListDao;
    /**
     * getFileListAll
     *
     * @return List<FileList>
     */
    @Override
    public List<FileList> getFileListAll() {
        return fileListDao.getFileListAll();
    }

    /**
     * getFileListUserAll
     *
     * @return
     */
    @Override
    public List<FileList> getFileListUserAll() {
        return fileListDao.getFileListUserAll();
    }
}
