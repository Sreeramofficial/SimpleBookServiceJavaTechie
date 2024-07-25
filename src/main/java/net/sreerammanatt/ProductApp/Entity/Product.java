package net.sreerammanatt.ProductApp.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

//since this is a model
@Entity
@Table(name="product_table")
public class Product {


    @Id
    @GeneratedValue
    @Column(name = "productId",nullable = false)
    private int id;


    @Column(name = "productName")
    private String name;


    @Column(name = "availableCount")
    private int stockAvailable;



    @Column(name = "currentPrice")
    private int price;
}
