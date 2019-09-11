package cn.itcast.service.impl;

import cn.itcast.exceptions.QueryException;
import cn.itcast.mapper.FileListMapper;
import cn.itcast.model.FileList;
import cn.itcast.service.FileListService;
import cn.itcast.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.08.26,13:25
 * @file :cn.itcast.service.impl.FileListServiceImpl.jave
 */
@Service("fileListService")
@Transactional(rollbackFor = Exception.class)
public class FileListServiceImpl implements FileListService {

    @Value("${spring.query.number:10}")
    private Integer number;

    @Autowired
    @Qualifier("fileListMapper")
    private FileListMapper fileListMapper;

    /**
     * 批量数据保存
     *
     * @param list
     * @return
     */
    @Override
    @Transactional
    public Integer saveBatch(List<FileList> list) {
        return fileListMapper.saveBatch(list);
    }

    /**
     * 单个对象保存
     *
     * @param fileList
     * @return
     */
    @Override
    @Transactional
    public Integer save(FileList fileList) throws QueryException {
        try {
            if (!ObjectUtils.isEmpty(fileList)) {
                Integer id = fileListMapper.save(fileList);
                return id;
            } else {
                throw new QueryException("The object cannot be empty");
            }
        } catch (Exception e) {
            throw new QueryException(e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     * @author z
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<FileList> findFileListAll() {
        List<FileList> all = fileListMapper.findFileListAll();
        int size = all.size();
        if (size >= 1) {
            return all;
        }
        return null;
    }

    /**
     * 查询总记录数
     *
     * @return count
     * @author z
     */
    @Override
    @Transactional
    public Integer count() {
        return fileListMapper.count();
    }

    /**
     * 分页查询
     *
     * @param number
     * @param statur
     * @return
     */
    @Override
    @Transactional
    public List<FileList> findFileListPage(Integer number, Integer statur) throws QueryException {
        if (statur > 0) {
            statur = number * statur;
        }
        if (statur < 0) {
            throw new QueryException("Start page exception statur:" + statur);
        }
        Integer count = fileListMapper.count();
        if (statur >= 0 && count >= statur) {
            List<FileList> page = fileListMapper.findFileListPage(number, statur);
            int size = page.size();
            if (size >= 1 && size <= number) {
                return page;
            } else {
                throw new QueryException("Query exception,Query results are not in scope,Looking forward to:" + number + " : As a result:" + size);
            }
        }
        return null;
    }

    /**
     * 分页查询，根据默认每页的记录数
     *
     * @param statur
     * @return
     */
    @Override
    @Transactional
    public List<FileList> findFileListPage(Integer statur) throws QueryException {
        return this.findFileListPage(number, statur);
    }

    /**
     * 分页查询第一页,根据配置文件的每页数据记录数
     *
     * @return
     * @throws QueryException
     */
    @Override
    @Transactional
    public List<FileList> findFileListFirstPage() throws QueryException {
        return this.findFileListPage(number, 0);
    }

    /**
     * 分页查询最后一页,根据配置文件的每页数据记录数
     *
     * @return
     * @throws QueryException
     */
    @Override
    @Transactional
    public List<FileList> findFileListLastPage() throws QueryException {
        Integer count = this.count();
        if (count <= number) {
            return this.findFileListPage(number, 0);
        }
        Integer lastCount = count / number;
        return this.findFileListPage(number, lastCount);
    }

    /**
     * 分页查询第一页,指定每页数据的记录数
     *
     * @param number 数据条数
     * @return
     * @throws QueryException
     */
    @Override
    @Transactional
    public List<FileList> findFileListFirstPage(Integer number) throws QueryException {
        return this.findFileListPage(number, 0);
    }

    /**
     * 分页查询最后一页,指定每页数据的记录数
     *
     * @param number 数据条数
     * @return
     * @throws QueryException
     */
    @Override
    @Transactional
    public List<FileList> findFileListLastPage(Integer number) throws QueryException {

        Integer lastCount = this.getLastCount(number);
        return this.findFileListPage(number, lastCount);
    }

    /**
     * 获取最后一页
     *
     * @param number 指定记录数
     * @author z
     */
    private Integer getLastCount(Integer number) {
        return this.count() / number;
    }

    /**
     * 获取最后一页，没有指定记录数
     * 根据配置文件指定记录数
     *
     * @return
     */
    private Integer getLastCount() {
        return this.count() / number;
    }
}
