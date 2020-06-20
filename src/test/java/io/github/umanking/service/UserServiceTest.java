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
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(savedUser.getName()).isEqualTo(user.getName());
        assertThat(savedUser.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(savedUser.getPassword()).isEqualTo(user.getPassword());
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

    private User account() {
        return new User("umanking@gmail.com", "1234", "1234", "한건국", "01084604141");
    }
}