package com.huan.service;

import com.huan.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Product findOne(Long id);

    void  save(Product product);

    void remove(Long id);

}
