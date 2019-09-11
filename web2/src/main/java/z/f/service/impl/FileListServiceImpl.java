package z.f.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import z.f.bean.FileList;
import z.f.dao.FileListDao;
import z.f.service.FileListService;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.08.10,18:57
 * @file :z.f.service.impl.FileListServiceImpl.jave
 */
@Service("fileListService")
public class FileListServiceImpl implements FileListService {

    @Autowired
    private FileListDao fileListDao;
    /**
     * fileListAll
     */
    @Override
    public List<FileList> getFileListAll() {
        return fileListDao.getFileListAll();
    }
}
