package cn.itcast.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author z
 */
@Getter
public enum OrderStatusEnums {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String msg;


    private OrderStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
