package com.itkaran.productservice.dtos;

import com.itkaran.productservice.models.Category;
import com.itkaran.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setDescription(description);

        Category productCategory = new Category();
        productCategory.setTitle(category);

        return product;
    }

}
