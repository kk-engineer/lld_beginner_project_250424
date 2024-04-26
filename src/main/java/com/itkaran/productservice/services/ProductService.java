package com.itkaran.productservice.services;

import com.itkaran.productservice.exceptions.ProductNotFoundException;
import com.itkaran.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
}
