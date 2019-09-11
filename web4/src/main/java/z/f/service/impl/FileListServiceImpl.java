package z.f.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import z.f.bean.FileList;
import z.f.mapper.FileListMapper;
import z.f.service.FileListService;

import java.util.List;

/**
 * @author z
 */

@Service("fileListService")
@Transactional
public class FileListServiceImpl implements FileListService {
    @Autowired
    private FileListMapper fileListMapper;

    @Override
    public List<FileList> getFileListAll() {
        return fileListMapper.getFileListAll();
    }

    /**
     * 根据id查询tb_file_list_copy的数据
     *
     * @param id integer
     * @return FileList
     * @author z
     */
    @Override
    public FileList findFileListBYID(Integer id) {
        FileList filelist = fileListMapper.findFileListBYID(id);
        return filelist;
    }

    /**
     * 根据id或用户名查询
     *
     * @param name
     * @param id
     * @return List<fileList>
     * @author z
     */
    @Override
    public List<FileList> findFileListBYIDorNname(String name, Integer id) {
        List<FileList> list = fileListMapper.findFileListBYIDorNname(name, id);
        Integer size = list.size();
        if (size >= 1) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 根据用户名模糊查询
     *
     * @param name
     * @return List
     * @author z
     */
    @Override
    public List<FileList> findFileListBYName(String name) {
        List<FileList> list = fileListMapper.findFileListBYName(name);
        Integer size = list.size();
        if (size >= 1) {
            return list;
        } else {

            return null;
        }
    }

    /**
     * 根据id和用户名精确查询
     *
     * @param id
     * @param name
     * @author z
     */
    @Override
    public FileList findFileListByIDandName(Integer id, String name) {
        List<FileList> list = fileListMapper.findFileListByIDandName(id, name);
        Integer size = list.size();
        if (size == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据name用户名精确查询
     *
     * @param name
     * @author z
     */
    @Override
    public FileList getFileListByName(String name) {
        List<FileList> list = fileListMapper.getFileListByName(name);
        Integer size = list.size();
        if (size == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * fileList 分页查询
     *
     * @param statr
     * @param pagenumber
     * @author z
     */
    @Override
    public List<FileList> findFileListPages(Integer statr, Integer pagenumber) {
        statr = statr*pagenumber+1;
        System.out.println(statr);
        List<FileList> pages = fileListMapper.findFileListPages(statr, pagenumber);
        Integer size = pages.size();
        if (size >= 1) {
            return pages;
        } else {
            return null;
        }
    }

    /**
     * fileList 单条记录添加
     *
     * @param fileList
     * @return
     * @author z
     */
    @Override
    public Integer insertFileListOne(FileList fileList) {

        return fileListMapper.insertFileListOne(fileList);
    }

    /**
     * fileList批量天添加
     *
     * @param lists@author z
     */
    @Override
    public List<Integer> insertFileListList(List<FileList> lists) {
        return fileListMapper.insertFileListList(lists);
    }
}
