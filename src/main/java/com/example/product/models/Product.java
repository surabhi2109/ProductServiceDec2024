package com.example.product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private Double price;
    @ManyToOne
    //@JoinColumn(name = "category_id")
    private Category category;
    private String description;
}
