package cn.itcast.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author z
 */
public class WebUtils {


    /**
     * 获取6位随机数
     *
     * @author z
     */
    public static String token() {
        return token(6);
    }

    /**
     * 获取位随机数
     *
     * @param len 随机数长度
     * @author z
     */
    public static String token(int len) {
        if (len > 9 || len < 1) {
            len = 6;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            stringBuffer.append(9);
        }
        Random random = new Random();
        // 生成0-6位的随机数
        int num = random.nextInt(Integer.valueOf(stringBuffer.toString()));
        // 验证码的数位全都要6位数，于是将该随机数转换成字符串，不够位数就添加
        String randomNum = String.valueOf(num);
        // 使用StringBuffer来拼凑字符串
        StringBuffer stringBufferToKen = new StringBuffer();
        for (int i = 0; i < 6 - randomNum.length(); i++) {
            stringBufferToKen.append("0");
        }
        return stringBufferToKen.append(randomNum).toString();
    }

    //获取客户端ip
    public static String getRemortIp(HttpServletRequest request) {
        if (request.getHeader("x-forwarded=for") == null) {
            return request.getRemoteAddr().toString();
        }
        return request.getHeader("x-forwarded-for").toString();
    }

}
