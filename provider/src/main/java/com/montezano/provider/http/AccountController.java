package com.montezano.provider.http;


import com.montezano.provider.domain.Account;
import com.montezano.provider.usecase.AccountCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountCrud accountCrud;

    @GetMapping
    public List<Account> all() {
        return accountCrud.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountCrud.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Account> create(@RequestBody Account account){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountCrud.create(account));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        accountCrud.delete(id);
    }
}
