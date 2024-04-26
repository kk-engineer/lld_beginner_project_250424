package com.itkaran.productservice.services;

import com.itkaran.productservice.dtos.FakeStoreProductDto;
import com.itkaran.productservice.exceptions.ProductNotFoundException;
import com.itkaran.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProducts =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class
                );

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts) {
            products.add(fakeStoreProductDto.toProduct());
            System.out.println(fakeStoreProductDto.getId());
        }

        return products;
    }
}
