package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.ProductCategory;
import com.southwind.entity.ProductInfo;
import com.southwind.mapper.ProductCategoryMapper;
import com.southwind.mapper.ProductInfoMapper;
import com.southwind.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.util.EntityToVO;
import com.southwind.vo.ProductCategoryVO;
import com.southwind.vo.ProductInfoVO;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 类目表 服务实现类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ResultVO<List<ProductCategoryVO>> voList() {
        List<ProductCategory> productCategories = this.productCategoryMapper.selectList(null);
        List<ProductCategoryVO> result = new ArrayList<>();
        ProductCategoryVO productCategoryVO;
        for (ProductCategory productCategory : productCategories) {
            //创建分类VO
            productCategoryVO = new ProductCategoryVO();
            //赋值
            productCategoryVO.setName(productCategory.getCategoryName());
            productCategoryVO.setType(productCategory.getCategoryType());
            //查询对应的商品详情
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("category_type", productCategoryVO.getType());
            wrapper.eq("product_status", 1);
            List<ProductInfo> productInfos = this.productInfoMapper.selectList(wrapper);
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            //遍历商品详情集合，要转VO
            for (ProductInfo productInfo : productInfos) {
                productInfoVOS.add(EntityToVO.ProductInfoToProductInfoVO(productInfo));
            }
            productCategoryVO.setFoods(productInfoVOS);
            result.add(productCategoryVO);
        }
        ResultVO<List<ProductCategoryVO>> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(result);
        return resultVO;
    }

    @Override
    public List<ProductCategoryVO> getAllCategoryVO() {
        List<ProductCategory> productCategories = this.productCategoryMapper.selectList(null);
        List<ProductCategoryVO> result = productCategories.stream().map(e -> new ProductCategoryVO(e.getCategoryName(), e.getCategoryType())).collect(Collectors.toList());
        return result;
    }
}
