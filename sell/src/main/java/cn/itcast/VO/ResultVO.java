package cn.itcast.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回前端结果对象
 * codening:utf-8
 *
 * @author :ResultVO
 * @time :2019.09.06,16:08
 * @file :cn.itcast.VO.ResultVO.jave
 */
@Getter
@Setter
@ToString
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}
