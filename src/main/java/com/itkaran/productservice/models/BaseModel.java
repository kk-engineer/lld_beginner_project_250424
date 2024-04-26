package com.itkaran.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted = false;
}
