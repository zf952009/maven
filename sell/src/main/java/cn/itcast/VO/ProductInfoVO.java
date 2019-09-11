package cn.itcast.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 商品详情
 * codening:utf-8
 *
 * @author :ProductInfoVO
 * @time :2019.09.06,16:16
 * @file :cn.itcast.VO.ProductInfoVO.jave
 */
@Getter
@Setter
@ToString
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
