package com.krishnacoding.oms.entities;

import com.krishnacoding.oms.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false ,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private Boolean enabled;
    @OneToOne
    @JoinColumn(name="customer_id" ,nullable=false,unique=true)
    private Customer customer;
}
