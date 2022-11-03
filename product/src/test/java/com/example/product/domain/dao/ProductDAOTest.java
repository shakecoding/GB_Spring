package com.example.product.domain.dao;

import com.example.product.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    @Test
    public void findAllTest(){
        productDAO.findAll().stream().map(ProductVO::toString).forEach(log::info);
    }
}
