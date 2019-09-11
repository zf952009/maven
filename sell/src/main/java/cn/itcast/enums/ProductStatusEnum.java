package cn.itcast.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 * codening:utf-8
 *
 * @author :ProductStatusEnums
 * @time :2019.09.06,14:39
 * @file :cn.itcast.enums.ProductStatusEnums.jave
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;
    private String mgs;

    ProductStatusEnum(Integer code, String mgs) {
        this.code = code;
        this.mgs = mgs;
    }
}
