package cn.itcast.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 商品详情+商品类型信息
 * codening:utf-8
 *
 * @author :ProductVO
 * @time :2019.09.06,16:12
 * @file :cn.itcast.VO.ProductVO.jave
 */
@Getter
@Setter
@ToString
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> foods;
}
