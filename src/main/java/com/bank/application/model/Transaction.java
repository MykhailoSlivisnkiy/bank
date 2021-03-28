package com.bank.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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
    private LocalDateTime transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @PrePersist()
    public void createTransactionDate() {
        setTransactionDate(LocalDateTime.now());
    }

    @PreUpdate()
    public void updateTransactionDate() {
        setTransactionDate(LocalDateTime.now());
    }
}
