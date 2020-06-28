package io.github.umanking.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Geonguk Han
 * @since 2020-06-28
 */
@Component
@ControllerAdvice
@Slf4j
public class GlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public String handleBadRequest(final Throwable e) {
        log.error(e.getMessage());
        return "/error/error";
    }
}
