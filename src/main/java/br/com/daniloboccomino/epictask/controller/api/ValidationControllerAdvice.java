package br.com.daniloboccomino.epictask.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ValidationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ValidationFieldError> handle(MethodArgumentNotValidException e) {
        log.error("Ocorreu um erro");
        return e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidationFieldError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}