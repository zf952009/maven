package z.f.mapper;

import org.apache.ibatis.annotations.Mapper;
import z.f.bean.UserText;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UseerMapper
 * @time :2019.08.14,8:06
 * @file :z.f.mapper.UseerMapper.jave
 */
@Mapper
public interface UseerMapper {

    List<UserText> getUserAll();
}
