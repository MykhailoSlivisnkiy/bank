package com.bank.application.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Transaction")
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transaction {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "transactionStatusIdSeq", sequenceName = "transaction_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionStatusIdSeq")
    private Long id;

    @Column(name = "amount_of_money")
    private Integer amount;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
