package com.vertigo.sofrimento_part3.model;

public class Enums {
	public enum Sexo {
	   	M("Masculino"), F("Feminino");
	 
	    public String valor;
	    Sexo(String valor) {
	    	this.valor = valor;
	    }
	    public String getValor() {
	    	return valor;
	    }
	}
	
	public enum EstadoCivil {
	   	SOLTEIRO, CASADO, DIVORCIADO, VIUVO;
	}
	
	public enum Periodo {
	   	MATUTINO, VESPERTINO, DIURNO, NOTURNO;
	}
	
}
