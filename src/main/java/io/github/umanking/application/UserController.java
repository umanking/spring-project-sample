package io.github.umanking.application;

import io.github.umanking.domain.user.User;
import io.github.umanking.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String showRegisterForm(final Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping(value = "/register")
    public String createAccount(@Valid final User user, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // todo: specific exception handling
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }

        userService.createAccount(user);
        return "redirect:/";
    }

}
