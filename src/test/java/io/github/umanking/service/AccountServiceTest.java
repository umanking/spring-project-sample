package io.github.umanking.service;

import io.github.umanking.domain.account.Account;
import io.github.umanking.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;
    private Account account;

    @BeforeEach
    void setUp() {
        account = account();
    }

    @Test
    void createAccount() {
        // given
        given(accountRepository.findByEmail(account.getEmail())).willReturn(Optional.empty());
        given(accountRepository.save(account)).willReturn(account);

        // when
        final Account savedAccount = accountService.createAccount(account);

        // then
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getEmail()).isEqualTo(account.getEmail());
        assertThat(savedAccount.getName()).isEqualTo(account.getName());
        assertThat(savedAccount.getPhoneNumber()).isEqualTo(account.getPhoneNumber());
        assertThat(savedAccount.getPassword()).isEqualTo(account.getPassword());
    }

    @Test
    void getAccount() {
    }

    @Test
    void modifyAccount() {
    }

    @Test
    void deleteAccount() {
    }

    private Account account() {
        return new Account("umanking@gmail.com", "1234", "1234", "한건국", "01084604141");
    }
}