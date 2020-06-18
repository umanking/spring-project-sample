package io.github.umanking.controller;

import io.github.umanking.domain.Account;
import io.github.umanking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String showAccountForm() {
        return "account";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createAccount(@RequestBody @Valid final Account account,
                                           final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // todo: specific exception handling
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResponseEntity.ok(accountService.createAccount(account));
    }
}
