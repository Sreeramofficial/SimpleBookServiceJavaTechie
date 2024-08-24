package net.sreerammanatt.ProductApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Table(name = "User_Address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;


    @Column(name = "HOMENAME")
    private String homeName;

    private @Column(name = "DISTRICT")
    String district;
    private @Column(name = "STATE")
    String state;

    @OneToOne(mappedBy ="address" )
    private User user;


}
