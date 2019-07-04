package com.montezano.provider.usecase;

import com.montezano.provider.domain.Account;
import com.montezano.provider.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountCrud {

    private final AccountGateway accountGateway;

    public Account findById(final String id) {
        return accountGateway
                .findById(id)
                .orElse(new Account());
//        return accountGateway
//                .findById(id)
//                .orElseThrow(() -> new AccountNotFoundException("Conta não encontrada!"));
    }

    public Account create(final Account account) {
       return accountGateway.save(account);
    }

    public List<Account> findAll() {
        return accountGateway.findAll();
    }

    public void delete(final String id) {
        accountGateway.delete(id);
    }

}
