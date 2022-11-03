package com.example.product.service;

import com.example.product.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    //    게시글 목록
    public List<ProductVO> show();
}
