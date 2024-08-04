package net.sreerammanatt.ProductApp.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User_Education")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "education_id")
    private Long id;

    @Column(name = "course")
    private String course;
    @Column(name = "isCompleted")
    private Boolean isCompleted;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;





}
