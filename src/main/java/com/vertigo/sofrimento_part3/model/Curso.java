package com.vertigo.sofrimento_part3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	

	@Column(name="nome")
	private String nome;

	public Curso() {}
	
	public Curso(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
