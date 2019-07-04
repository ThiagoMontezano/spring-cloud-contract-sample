package com.montezano.provider.gateway;

import com.montezano.provider.domain.Account;
import com.montezano.provider.domain.AccountType;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class AccountGatewayInMemory implements AccountGateway {

    private static Map<String, Account> dataStore = new HashMap<>();
    private static String FIXTURE_ID = "1";


    @Override
    public Optional<Account> findById(final String id) {
        if(id.equals(FIXTURE_ID))
            return Optional.of(fixture());
        return Optional.ofNullable(dataStore.get(id));
    }

    @Override
    public Account save(final Account account) {
        if(StringUtils.isBlank(account.getId())){
            account.setId(UUID.randomUUID().toString());
        }
        dataStore.put(account.getId(), account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    @Override
    public void delete(final String id) {
        dataStore.remove(id);
    }

    public void clear() {
        dataStore.clear();
    }

    private Account fixture(){
        Account account = new Account();
        account.setId("1");
        account.setCustomerId("12");
        account.setType(AccountType.CURRENT);
        account.setTransactionLimit(Double.valueOf("1000"));
        account.setBalance(Double.valueOf("0"));
        account.setActive(true);
        return account;
    }
}