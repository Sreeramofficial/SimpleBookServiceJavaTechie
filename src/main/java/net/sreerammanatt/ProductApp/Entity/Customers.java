package net.sreerammanatt.ProductApp.Entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "customer_table")
public class Customers {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;


    @Column(name = "customer_name")
    private String name;


    @Column(name = "email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customers")
    public Product product;


}
