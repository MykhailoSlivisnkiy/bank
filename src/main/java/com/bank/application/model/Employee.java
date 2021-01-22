package com.bank.application.model;

import lombok.*;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "employeeStatusIdSeq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeStatusIdSeq")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    //add salary it's important
    //ApplicationContext
    //add 'freezed' status to account table
    //good solution to your problem with roles
    //also you can add employee position in company to database
    //try to read this https://dba.stackexchange.com/questions/149904/how-to-model-an-entity-type-that-can-have-different-sets-of-attributes
    //https://dba.stackexchange.com/questions/31193/separate-or-combine-2-tables-with-similar-attributes/31198#31198
    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Client> client;
}
