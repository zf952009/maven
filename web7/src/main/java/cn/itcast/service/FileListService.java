package cn.itcast.service;

import cn.itcast.exceptions.QueryException;
import cn.itcast.model.FileList;

import java.util.List;

/**
 * @author z
 */
public interface FileListService {

    /**
     * 批量数据保存
     *
     * @param list
     * @return
     */
    Integer saveBatch(List<FileList> list);

    /**
     * 单个对象保存
     *
     * @param fileList
     * @return
     */
    Integer save(FileList fileList) throws QueryException;

    /**
     * 查询所有
     *
     * @return
     * @author z
     */
    List<FileList> findFileListAll();

    /**
     * 查询总记录数
     *
     * @return count
     * @author z
     */
    Integer count();

    /**
     * 分页查询,指定每页的记录数
     *
     * @param number
     * @param statur
     * @return
     */
    List<FileList> findFileListPage(Integer number, Integer statur) throws QueryException;

    /**
     * 分页查询，根据默认每页的记录数
     *
     * @param statur
     * @return
     * @throws QueryException
     */
    List<FileList> findFileListPage(Integer statur) throws QueryException;

    /**
     * 分页查询第一页,根据配置文件的每页数据记录数
     *
     * @return
     * @throws QueryException
     */
    List<FileList> findFileListFirstPage() throws QueryException;

    /**
     * 分页查询最后一页,根据配置文件的每页数据记录数
     *
     * @return
     * @throws QueryException
     */
    List<FileList> findFileListLastPage() throws QueryException;

    /**
     * 分页查询第一页,指定每页数据的记录数
     *
     * @param number 数据条数
     * @return
     * @throws QueryException
     */
    List<FileList> findFileListFirstPage(Integer number) throws QueryException;

    /**
     * 分页查询最后一页,指定每页数据的记录数
     *
     * @param number 数据条数
     * @return
     * @throws QueryException
     */
    List<FileList> findFileListLastPage(Integer number) throws QueryException;
}
