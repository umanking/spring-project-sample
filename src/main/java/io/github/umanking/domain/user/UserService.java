package io.github.umanking.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createAccount(final User user) {
        // todo:refactoring
        checkExistEmail(user.getEmail());
        user.checkConfirmPassword();
        return userRepository.save(user);
    }

    private void checkExistEmail(final String email) {
        final Optional<User> optionalAccount = userRepository.findByEmail(email);
        if (optionalAccount.isPresent()) {
            throw new RuntimeException("Already exist email : " + email);
        }
    }

    public User getAccount(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist account id :" + id));
    }

    public User modifyAccount(final Long id, final User newUser) {
        final User existUser = getAccount(id);
        existUser.updateAccount(newUser);
        return userRepository.save(existUser);
    }

    public void deleteAccount(final Long id) {
        userRepository.deleteById(id);
    }

}
