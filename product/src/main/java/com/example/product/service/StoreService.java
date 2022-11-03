package com.example.product.service;


import com.example.product.domain.dao.ProductDAO;
import com.example.product.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("store") @Primary
public class StoreService implements ProductService{
    private final ProductDAO productDAO;

    @Override
    public List<ProductVO> show() {
        return productDAO.findAll();
    }
}
