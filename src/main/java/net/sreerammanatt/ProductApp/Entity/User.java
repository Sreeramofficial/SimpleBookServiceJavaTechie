package net.sreerammanatt.ProductApp.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "userName")
     @NotNull(message = "name should not be null")
    private String name;

    @Column(name = "email")
    @Email(message = "should be valid email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false, referencedColumnName = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<Education> education;


}
