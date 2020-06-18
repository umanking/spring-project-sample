package com.example.demo.repository;

import com.example.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
