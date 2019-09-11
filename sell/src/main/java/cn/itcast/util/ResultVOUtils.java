package cn.itcast.util;

import cn.itcast.VO.ResultVO;

/**
 * codening:utf-8
 *
 * @author :ResultVOUtils
 * @time :2019.09.06,17:20
 * @file :cn.itcast.util.ResultVOUtils.jave
 */
public class ResultVOUtils {

    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("ok");
        resultVO.setData(o);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
