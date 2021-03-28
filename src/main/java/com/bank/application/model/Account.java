package com.bank.application.model;

import com.bank.application.model.enums.AccountStatus;
import com.bank.application.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "card_varification_value", nullable = false)
    private String cvv;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "opened_date")
    private LocalDateTime openedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore()
    private User user;

    @Enumerated(value = EnumType.ORDINAL)
    @JoinColumn(name = "account_status", nullable = false)
    private AccountStatus accountStatus;

    @Enumerated(value = EnumType.ORDINAL)
    @JoinColumn(name = "account_type", nullable = false)
    private AccountType accountType;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactions;

    @PrePersist()
    public void createOpenedDate() {
        setOpenedDate(LocalDateTime.now());
    }
}
