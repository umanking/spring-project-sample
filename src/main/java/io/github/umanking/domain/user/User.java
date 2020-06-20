package io.github.umanking.domain.user;

import io.github.umanking.domain.BaseEntity;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Entity
@Data
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    private String email;

    @NotNull(message = "must not be null")
    private String password;

    @NotNull(message = "must not be null")
    private String confirmPassword;

    @NotNull(message = "must not be null")
    private String name;

    // todo: @Pattern
    @NotNull(message = "must not be null")
    private String phoneNumber;

    public User() {
    }

    public User(final String email,
                final String password,
                final String confirmPassword,
                final String name,
                final String phoneNumber) {

        // todo: validation phone_number
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void updateAccount(final User newUser) {
        if (newUser.getEmail() != null) {
            this.email = newUser.getEmail();
        }

        if (newUser.getName() != null) {
            this.name = newUser.getName();
        }

        if (newUser.getPhoneNumber() != null) {
            this.phoneNumber = newUser.getPhoneNumber();
        }
    }

    public void checkConfirmPassword() {
        if (!StringUtils.isEmpty(this.password) && !StringUtils.isEmpty(this.confirmPassword)) {
            if (!this.password.equals(this.confirmPassword)) {
                throw new RuntimeException("check your password");
            }
        }
    }
}
