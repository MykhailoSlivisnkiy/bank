package com.bank.application.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Account")
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "accountIdSeq", sequenceName = "accounts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountIdSeq")
    private Long id;

    @Column(name = "account_name", unique = true, nullable = false)
    private String name;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "opened_date")
    private Date openedDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_status", nullable = false)
    private AccountStatus accountStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type", nullable = false)
    private AccountType accountType;
}
