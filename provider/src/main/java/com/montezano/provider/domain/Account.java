package com.montezano.provider.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Account {

    @Id
    private String id;

    private String customerId;

    private AccountType type;

    private boolean active;

    private Double transactionLimit;

    private Double balance;

}
