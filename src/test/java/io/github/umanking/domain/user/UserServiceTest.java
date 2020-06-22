package io.github.umanking.domain.user;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

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
    void modifyAccount() {
        // given
        final User modifiedUser = this.user;
        modifiedUser.setEmail("gg.han@gamil.com");

        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));
        given(userRepository.save(any())).willReturn(modifiedUser);

        // when
        final User actual = userService.modifyAccount(anyLong(), modifiedUser);

        // then
        assertThat(actual.getEmail()).isEqualTo(modifiedUser.getEmail());
    }

    @Test
    void deleteAccount() {
        // given
        doNothing().when(userRepository).deleteById(any());

        // when
        userService.deleteAccount(any());

        // then
        verify(userRepository).deleteById(any());
    }

    private User account() {
        return new User("umanking@gmail.com", "1234", "1234", "한건국", "01084604141");
    }

    private void assertUser(final User actual, final User expected) {
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getEmail()).isEqualTo(expected.getEmail());
        assertThat(actual.getPhoneNumber()).isEqualTo(expected.getPhoneNumber());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
    }
}