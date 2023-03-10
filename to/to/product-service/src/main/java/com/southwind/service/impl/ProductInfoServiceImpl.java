package com.southwind.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.entity.ProductCategory;
import com.southwind.entity.ProductInfo;
import com.southwind.enums.ProductEnum;
import com.southwind.exception.ProductException;
import com.southwind.mapper.ProductCategoryMapper;
import com.southwind.mapper.ProductInfoMapper;
import com.southwind.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.util.ResultVOUtil;
import com.southwind.vo.PageVO;
import com.southwind.vo.ProductManageVO;
import com.southwind.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author southwind
 * @since 2020-09-21
 */
@Service
@Slf4j
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public boolean subStock(Integer productId, Integer quantity) {
        ProductInfo productInfo = this.productInfoMapper.selectById(productId);
        Integer result = productInfo.getProductStock() - quantity;
        if(result < 0){
            log.info("【修改库存】库存数量异常！productInfo={}", productInfo);
            throw new ProductException(ProductEnum.PRODUCT_STOCK_ERROR);
        }
        productInfo.setProductStock(result);
        int row = this.productInfoMapper.updateById(productInfo);
        if(row == 1) return true;
        return false;
    }

    @Override
    public PageVO<List<ProductManageVO>> findProductManageVOByPage(Integer page, Integer size) {
        Page<ProductInfo> condition = new Page<>(page,size);
        Page<ProductInfo> productInfoPage = this.productInfoMapper.selectPage(condition, null);
        List<ProductInfo> productInfoList = productInfoPage.getRecords();
        List<ProductManageVO> productManageVOList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            ProductManageVO productManageVO = new ProductManageVO();
            BeanUtils.copyProperties(productInfo, productManageVO);
            //status
            if(productInfo.getProductStatus() == 0) productManageVO.setStatus(false);
            else productManageVO.setStatus(true);
            //categoryName
            productManageVO.setCategoryName(this.productCategoryMapper.findNameByType(productInfo.getCategoryType()));
            productManageVOList.add(productManageVO);
        }
        PageVO<List<ProductManageVO>> result = new PageVO<>();
        result.setContent(productManageVOList);
        result.setSize(productInfoPage.getSize());
        result.setTotal(productInfoPage.getTotal());
        return result;
    }

    @Override
    public ProductManageVO findById(Integer id) {
        ProductInfo productInfo = this.productInfoMapper.selectById(id);
        if(productInfo == null){
            log.info("【查询商品】商品不存在,productInfo={}", productInfo);
            throw new ProductException(ProductEnum.PRODUCT_NOT_EXIST);
        }
        ProductManageVO productManageVO = new ProductManageVO();
        BeanUtils.copyProperties(productInfo, productManageVO);
        //status
        if(productInfo.getProductStatus() == 0) productManageVO.setStatus(false);
        else productManageVO.setStatus(true);
        //productCategory
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(productInfo.getCategoryType());
        productManageVO.setCategory(productCategory);
        return productManageVO;
    }

    @Override
    public boolean updateStatus(Integer id, Boolean status) {
        Integer sta = 0;
        if(status) sta = 1;
        int row = this.productInfoMapper.updateStatus(id, sta);
        if(row == 1) return true;
        return false;
    }

    @Override
    public boolean updateProductManageVO(ProductManageVO productManageVO) {
        ProductInfo productInfo = this.productInfoMapper.selectById(productManageVO.getProductId());
        BeanUtils.copyProperties(productManageVO, productInfo);
        productInfo.setCategoryType(productManageVO.getCategory().getCategoryType());
        if(productManageVO.getStatus()) productInfo.setProductStatus(1);
        else productInfo.setProductStatus(0);
        int row = this.productInfoMapper.updateById(productInfo);
        if(row == 1) return true;
        return false;
    }
}
