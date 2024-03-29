package com.montezano.provider.gateway.repository;

import com.montezano.provider.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {

}
