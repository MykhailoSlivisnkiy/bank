package com.bank.application.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AccountStatus {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "accountStatusIdSeq", sequenceName = "account_status_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountStatusIdSeq")
    private Long id;

    @Column(name = "status_desciption")
    private String description;

    public AccountStatus(String description) {
        this.description = description;
    }
}
