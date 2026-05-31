package com.hari.mini_account_management.controller;


import com.hari.mini_account_management.entity.Account;
import com.hari.mini_account_management.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }
    @GetMapping("/version")
    public String version() {
        return "GitOps Trigger v2";
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account update(
            @PathVariable Long id,
            @RequestBody Account account
    ) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteAccount(id);
        return "Account deleted successfully";
    }
}