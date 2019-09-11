package cn.itcast.mapper;


import cn.itcast.model.FileList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author z
 */
@Repository("fileListMapper")
@Mapper
public interface FileListMapper {

    /**
     * 单个对象保存
     *
     * @param fileList
     * @return
     */
    Integer save(FileList fileList);

    /**
     * 批量添加
     *
     * @param list
     * @return
     */
    Integer saveBatch(List<FileList> list);


    /**
     * 查询所有
     *
     * @return
     * @author z
     */
    List<FileList> findFileListAll();

    /**
     * 分页查询，待实现
     *
     * @param number 每页显示的条数
     * @param statur 起始页面
     * @return
     */
    List<FileList> findFileListPage(@Param(value = "number") Integer number, @Param(value = "statur") Integer statur);

    /**
     * 查询总记录数
     *
     * @return count
     * @author z
     */
    Integer count();

}
