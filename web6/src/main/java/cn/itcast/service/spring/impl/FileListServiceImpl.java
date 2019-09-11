package cn.itcast.service.spring.impl;

import cn.itcast.mapper.spring.FileListMapper;
import cn.itcast.model.spring.FileList;
import cn.itcast.service.spring.FileListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.08.20,15:30
 * @file :cn.itcast.service.spring.impl.FileListServiceImpl.jave
 */
@Service("fileListService")
public class FileListServiceImpl implements FileListService {
    @Autowired
    @Qualifier("fileListMapper")
    private FileListMapper fileListMapper;

    /**
     * user_id 查询
     *
     * @param user_id
     * @return List<FileList>
     * @author z
     */
    @Override
    public List<FileList> getFileListByUserID(Integer user_id) {
        List<FileList> list = fileListMapper.getFileListByUserID(user_id);
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }

    /**
     * id查询
     *
     * @param id
     * @return
     * @author z
     */
    @Override
    public FileList getFileListByID(Integer id) {
        return fileListMapper.getFileListByID(id);
    }


    /**
     * 查询所有
     *
     * @return List<FileList>
     * @author z
     */
    @Override
    public List<FileList> selectFileListAll() {
        List<FileList> list = fileListMapper.selectFileListAll();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }

    /**
     * 查询所有filelist和user
     *
     * @return List<FileList>
     * @author z
     */
    @Override
    public List<FileList> selectFileListAndUserAll() {
        List<FileList> list = fileListMapper.selectFileListAndUserAll();
        Integer size = list.size();

        if (size >= 1) {
            return list;
        }
        return null;
    }

    /**
     * 查询所有filelist和user
     * 使用分步查询
     *
     * @return List<FileList>
     * @author z
     */
    @Override
    public List<FileList> selectFileListAndUserAll1() {
        List<FileList> list = fileListMapper.selectFileListAndUserAll1();
        Integer size = list.size();
        if (size >= 1) {
            return list;
        }
        return null;
    }


}
