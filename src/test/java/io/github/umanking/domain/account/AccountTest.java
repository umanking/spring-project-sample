package io.github.umanking.domain.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
class AccountTest {

    @Test
    void updateAccount() {
        // given
        final Account account = new Account("umanking@gmail.com", "1234", "1234", "andrew", "01012341234");
        final Account newAccount = new Account("andrew@gmail.com", "1234", "1234", "andrew han", "01012341234");

        // when
        account.updateAccount(newAccount);

        // 변경된 것
        assertThat(account.getEmail()).isEqualTo(newAccount.getEmail());
        assertThat(account.getName()).isEqualTo(newAccount.getName());
    }

    @Test
    void checkConfirmPassword() {
        // given
        final Account account = new Account("umanking@gmail.com", "1234", "4321", "andrew", "01012341234");

        // when then
        assertThrows(RuntimeException.class, () -> account.checkConfirmPassword());
    }
}