package com.montezano.provider.gateway.impl;

import com.montezano.provider.domain.Account;
import com.montezano.provider.gateway.AccountGateway;
import com.montezano.provider.gateway.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class AccountGatewayImpl implements AccountGateway {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findById(final String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(final Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void delete(final String id) {
        accountRepository.deleteById(id);

    }
}
