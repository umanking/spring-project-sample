package io.github.umanking.controller;

import io.github.umanking.domain.account.Account;
import io.github.umanking.service.AccountService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/account")
    public String showAccountForm(final Model model) {
        model.addAttribute("account", new Account());
        return "account_register";
    }

    @PostMapping(value = "/account")
    public String createAccount(@Valid final Account account, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // todo: specific exception handling
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }

        accountService.createAccount(account);
        return "redirect:/";
    }

}
