package com.bank.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_attributes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerAttributes {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "clientAttributesIdSeq", sequenceName = "client_attributes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientAttributesIdSeq")
    private Long id;

    @Column(name = "date_became_client")
    private String dateOfBecomeCustomer;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private User user;
}
