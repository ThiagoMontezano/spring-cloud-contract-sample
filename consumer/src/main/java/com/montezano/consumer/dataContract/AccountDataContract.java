package com.montezano.consumer.dataContract;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDataContract {

    private String id;

    private String customerId;

    private AccountTypeDataContract type;

    private boolean active;

    private Double transactionLimit;

    private Double balance;
}
