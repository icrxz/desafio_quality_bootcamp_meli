package com.meli.testing.desafioquality.exception.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.meli.testing.desafioquality.dto.ExceptionDTO;
import com.meli.testing.desafioquality.exception.DistrictNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiControllerExceptionAdvice {
    private final MessageSource messageSource;

    @Autowired
    public ApiControllerExceptionAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDTO> processedErrors = processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(processedErrors);
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(DistrictNotFoundException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO(null, e.getMessage()));
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(JsonParseException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO(null, "Verifique a formatação do JSON"));
    }

    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> dtoList = new ArrayList<>();

        for (FieldError fieldError: fieldErrors) {
            String errorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            dtoList.add(new ExceptionDTO(fieldError.getField(), errorMessage));
        }

        return dtoList;
    }

}
