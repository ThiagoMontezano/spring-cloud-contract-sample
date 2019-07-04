package com.montezano.provider.gateway;

import com.montezano.provider.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountGateway {

    Optional<Account> findById(final String id);

    Account save(final Account account);

    List<Account> findAll();

    void delete(final String id);
}
