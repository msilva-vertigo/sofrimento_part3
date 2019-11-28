package com.vertigo.sofrimento_part3.exception;

public class ParametroInvalidoException extends RuntimeException{
	
	public ParametroInvalidoException(String message) {
        super("Parametro invalido : " + message);
    }
	
}
