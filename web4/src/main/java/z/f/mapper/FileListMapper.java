package z.f.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import z.f.bean.FileList;

import java.util.List;

/**
 * @author
 */
@Mapper
public interface FileListMapper {

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
    FileList findFileListBYID(@Param(value = "id") Integer id);

    /**
     * 根据id或用户名查询
     *
     * @param id
     * @param name
     * @return List<fileList>
     * @author z
     */
    List<FileList> findFileListBYIDorNname(@Param(value = "name") String name, @Param(value = "id") Integer id);

    /**
     * 根据用户名模糊查询
     *
     * @param name
     * @return List
     * @author z
     */
    List<FileList> findFileListBYName(@Param(value = "name") String name);

    /**
     * 根据id和用户名精确查询
     *
     * @param id
     * @param name
     * @return
     * @author z
     */
    List<FileList> findFileListByIDandName(@Param(value = "id") Integer id, @Param(value = "name") String name);

    /**
     * 根据name用户名精确查询
     *
     * @param name
     * @return
     * @author z
     */
    List<FileList> getFileListByName(@Param(value = "name") String name);

    /**
     * fileList 分页查询
     *
     * @param pagenumber
     * @param statr
     * @author z
     */
    List<FileList> findFileListPages(@Param(value = "statr") Integer statr, @Param(value = "pagenumber") Integer pagenumber);

    /**
     * fileList 单条记录添加
     *
     * @param fileList
     * @return
     * @author z
     */
    Integer insertFileListOne(FileList fileList);

    /**
     *
     * fileList批量天添加
     * @param list<fileList>
     * @author z
     * */
    List<Integer> insertFileListList(List<FileList> list);

}
