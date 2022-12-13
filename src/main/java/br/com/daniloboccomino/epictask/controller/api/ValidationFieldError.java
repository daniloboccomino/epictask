package br.com.daniloboccomino.epictask.controller.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationFieldError {

    private String field;
    private String error;

}