package io.github.umanking.service;

import io.github.umanking.domain.user.User;
import io.github.umanking.domain.user.UserRepository;
import io.github.umanking.domain.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;
    
    private User user;

    @BeforeEach
    void setUp() {
        user = account();
    }

    @Test
    void createAccount() {
        // given
        given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());
        given(userRepository.save(user)).willReturn(user);

        // when
        final User savedUser = userService.createAccount(user);

        // then
        assertUser(savedUser, user);
    }

    @Test
    void getAccount() {
        // given
        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        // when
        final User actual = userService.getAccount(anyLong());

        // then
        assertUser(actual, user);
    }

    private void assertUser(final User actual, final User expected) {
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
        assertThat(actual.getPhoneNumber()).isEqualTo(expected.getPhoneNumber());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
    }

    @Test
    void modifyAccount() {
    }

    @Test
    void deleteAccount() {
    }

    private User account() {
        return new User("umanking@gmail.com", "1234", "1234", "한건국", "01084604141");
    }
}