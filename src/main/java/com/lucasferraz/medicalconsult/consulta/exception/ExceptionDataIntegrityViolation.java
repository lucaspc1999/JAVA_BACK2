package com.lucasferraz.medicalconsult.consulta.exception;

public class ExceptionDataIntegrityViolation extends  RuntimeException{
    public ExceptionDataIntegrityViolation(String message){
        super(message);
    }
}
