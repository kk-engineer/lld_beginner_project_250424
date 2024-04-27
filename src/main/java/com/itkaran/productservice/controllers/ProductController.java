package com.itkaran.productservice.controllers;

import com.itkaran.productservice.exceptions.ProductNotFoundException;
import com.itkaran.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.itkaran.productservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<> (products, HttpStatus.OK);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
            Product product = productService.getProductById(productId);
            return new ResponseEntity<> (product, HttpStatus.OK);
     }
}
