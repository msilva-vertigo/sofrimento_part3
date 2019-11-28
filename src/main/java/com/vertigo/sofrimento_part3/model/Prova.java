package com.vertigo.sofrimento_part3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prova")
public class Prova {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idProva;
	
	@Column(name="descProva")
	private String descProva;

	public Prova() {}
	
	public Prova(Integer idProva, String descProva) {
		this.idProva = idProva;
		this.descProva = descProva;
	}
	
	
}
