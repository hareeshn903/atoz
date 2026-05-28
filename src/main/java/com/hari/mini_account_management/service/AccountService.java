package com.hari.mini_account_management.service;


import com.hari.mini_account_management.entity.Account;
import com.hari.mini_account_management.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account updateAccount(Long id, Account updatedAccount) {

        Account existing = getAccountById(id);

        existing.setName(updatedAccount.getName());
        existing.setEmail(updatedAccount.getEmail());
        existing.setPhone(updatedAccount.getPhone());

        return repository.save(existing);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}