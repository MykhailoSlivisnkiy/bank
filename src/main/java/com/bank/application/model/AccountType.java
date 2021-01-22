package com.bank.application.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AccountType {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "accountTypeIdSeq", sequenceName = "account_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountTypeIdSeq")
    private Long id;

    @Column(name = "account_type")
    private String type;

    public AccountType(String type) {
        this.type = type;
    }
}
