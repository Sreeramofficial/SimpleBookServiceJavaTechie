package net.sreerammanatt.ProductApp.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

//since this is a model
@Entity
@Table(name="product_table")
public class Product {


    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "productId",nullable = false)
    private int id;


    @Column(name = "productName")
    private String name;


    @Column(name = "availableCount")
    private int stockAvailable;



    @Column(name = "currentPrice")
    private int price;


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = false,optional = false)
    @JoinColumn(name = "seller_code")

    private ProductSeller productSeller;



}
