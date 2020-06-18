package io.github.umanking.service;

import io.github.umanking.domain.Account;
import io.github.umanking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(final Account account) {
        checkExistEmail(account.getEmail());
        account.checkConfirmPassword();
        return accountRepository.save(account);
    }

    private void checkExistEmail(final String email) {
        final Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        if (optionalAccount.isPresent()) {
            throw new RuntimeException("Already exist email : " + email);
        }
    }

    public Account getAccount(final Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist account id :" + id));
    }

    public Account modifyAccount(final Long id, final Account newAccount) {
        final Account existAccount = getAccount(id);
        existAccount.updateAccount(newAccount);
        return accountRepository.save(existAccount);
    }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

}
