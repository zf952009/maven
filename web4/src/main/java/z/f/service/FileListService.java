package z.f.service;

import z.f.bean.FileList;

import java.util.List;

/**
 * @author z
 */
public interface FileListService {

    /**
     * 查询tb_file_list_copy所有的数据
     *
     * @return List<fileList>
     * @author z
     */
    List<FileList> getFileListAll();

    /**
     * 根据id查询tb_file_list_copy的数据
     *
     * @param id integer
     * @return FileList
     * @author z
     */
    FileList findFileListBYID(Integer id);

    /**
     * 根据id或用户名查询
     *
     * @param id
     * @param name
     * @return List<fileList>
     * @author z
     */
    List<FileList> findFileListBYIDorNname(String name, Integer id);

    /**
     * 根据用户名模糊查询
     *
     * @param name
     * @return List
     * @author z
     */
    List<FileList> findFileListBYName(String name);

    /**
     * 根据id和用户名精确查询
     *
     * @param id
     * @param name
     * @return
     * @author z
     */

    FileList findFileListByIDandName(Integer id, String name);

    /**
     * 根据name用户名精确查询
     *
     * @param name
     * @return
     * @author z
     */
    FileList getFileListByName(String name);

    /**
     * fileList 分页查询
     *
     * @param pagenumber
     * @param statr
     * @author z
     */
    List<FileList> findFileListPages(Integer statr, Integer pagenumber);
    /**
     * fileList 单条记录添加
     * @param fileList
     * @return
     * @author z
     * */

    Integer insertFileListOne(FileList fileList);


    /**
     *
     * fileList批量天添加
     * @param lists<fileList>
     * @author z
     * */
    List<Integer> insertFileListList(List<FileList> lists);
}
