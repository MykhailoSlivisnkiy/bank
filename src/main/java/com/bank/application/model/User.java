package com.bank.application.model;

import com.bank.application.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "date_became_client")
    private LocalDateTime dateOfBecomeCustomer;

    @Column(name = "salary")
    private Integer salary;

    @ElementCollection(targetClass = com.bank.application.model.enums.Role.class)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @Column(name = "role_id", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private List<Role> roles;

    @PrePersist
    public void initData() {
        setDateOfBecomeCustomer(LocalDateTime.now());
    }
}


