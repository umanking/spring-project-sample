package io.github.umanking.repository;

import io.github.umanking.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
