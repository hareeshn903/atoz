package com.hari.mini_account_management.repository;
import com.hari.mini_account_management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}