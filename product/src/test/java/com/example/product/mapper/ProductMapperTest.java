package com.example.product.mapper;

import com.example.product.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void getListTest(){
        productMapper.getList().stream().map(ProductVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("오메가 호근몬");
        productVO.setProductPrice(1);
        productVO.setProductStock(1);
        productVO.setProductBrand("디지몬");
        productMapper.insert(productVO);
    }
}
