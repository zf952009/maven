package cn.itcast.controller;

import cn.itcast.VO.ProductInfoVO;
import cn.itcast.VO.ProductVO;
import cn.itcast.VO.ResultVO;
import cn.itcast.dataobject.ProductCategory;
import cn.itcast.dataobject.ProductInfo;
import cn.itcast.service.ProductCategoryService;
import cn.itcast.service.ProductInfoService;
import cn.itcast.util.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家端
 * codening:utf-8
 * <p>
 * 传统方式获取到类目
 * for (ProductInfo productInfo : all) {
 * list.add(productInfo.getCategoryType());
 * }
 * 精简方式获取类目，使用java8 的lamda表达式
 *
 * @author :BuyerProductController
 * @time :2019.09.06,16:18
 * @file :cn.itcast.controller.BuyerProductController.jave
 */
@RestController
@RequestMapping(path = "/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/list")
    public ResultVO list() {

        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //查询类型
        List<Integer> list = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryService.findBycategoryTypeIn(list);

        //数据拼装
        ResultVO resultVO = new ResultVO();
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }
}
