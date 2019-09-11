package cn.itcast.service.impl;

import cn.itcast.dao.FileListDao;
import cn.itcast.domain.FileList;
import cn.itcast.service.FileListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * codening:utf-8
 *
 * @author :FileListServiceImpl
 * @time :2019.09.06,23:51
 * @file :cn.itcast.service.impl.FileListServiceImpl.jave
 */

@Service
public class FileListServiceImpl extends ServiceImpl<FileListDao, FileList> implements FileListService {
}
