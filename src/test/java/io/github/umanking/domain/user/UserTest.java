package io.github.umanking.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
class UserTest {

    @Test
    void updateAccount() {
        // given
        final User user = new User("umanking@gmail.com", "1234", "1234", "andrew", "01012341234");
        final User newUser = new User("andrew@gmail.com", "1234", "1234", "andrew han", "01012341234");

        // when
        user.updateAccount(newUser);

        // then
        assertThat(user.getEmail()).isEqualTo(newUser.getEmail());
        assertThat(user.getName()).isEqualTo(newUser.getName());
    }

    @Test
    void checkConfirmPassword() {
        // given
        final User user = new User("umanking@gmail.com", "1234", "4321", "andrew", "01012341234");

        // when, then
        assertThrows(RuntimeException.class, () -> user.checkConfirmPassword());
    }
}