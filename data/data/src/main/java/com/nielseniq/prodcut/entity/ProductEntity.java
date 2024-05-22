package com.nielseniq.prodcut.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;
    @Column(name = "shopper_id")
    private String shopperId;
    @Column(name = "shelf")
    private String shelf;
}

