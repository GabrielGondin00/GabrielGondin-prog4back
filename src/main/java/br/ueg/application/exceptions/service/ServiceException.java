package br.ueg.application.exceptions.service;

public class ServiceException extends RuntimeException{

    public ServiceException (String message) {
        super(message);
    }
}