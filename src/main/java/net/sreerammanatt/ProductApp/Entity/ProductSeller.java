package net.sreerammanatt.ProductApp.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_seller")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSeller {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private int id;


    @Column(name = "seller_name")
    private String name;


}
