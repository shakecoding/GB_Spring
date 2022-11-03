package com.example.product.domain.dao;

import com.example.product.domain.vo.ProductVO;
import com.example.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    //    게시글 목록
    public List<ProductVO> findAll(){
        return productMapper.getList();
    }


}
