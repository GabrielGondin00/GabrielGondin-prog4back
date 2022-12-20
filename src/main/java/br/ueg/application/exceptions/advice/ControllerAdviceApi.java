package br.ueg.application.exceptions.advice;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.ueg.application.exceptions.service.ServiceException;
import br.ueg.application.exceptions.service.SeviceErro;

@ControllerAdvice
public class ControllerAdviceApi {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<SeviceErro> resourceNotFound(ServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        SeviceErro err = new SeviceErro(String.valueOf(status), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<SeviceErro> resourceNotFound(ConstraintViolationException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        SeviceErro err = new SeviceErro(String.valueOf(status), "Campos Obrigatórios em branco");
        return ResponseEntity.status(status).body(err);
    }
}
