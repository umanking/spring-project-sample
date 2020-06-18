package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return accountRepository.save(account);
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
