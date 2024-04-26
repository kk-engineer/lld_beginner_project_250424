package com.itkaran.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private int id;
    private String title;
    private List<Product> products;
}
