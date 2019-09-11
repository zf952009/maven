package cn.itcast.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 *
 * @author z
 */
@Getter
public enum OrderPayStatusEnums {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;
    private String msg;


    private OrderPayStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
