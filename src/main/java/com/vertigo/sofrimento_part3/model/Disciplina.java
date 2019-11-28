package com.vertigo.sofrimento_part3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="disciplina")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idDisciplina;
	
	@Column(name="nomeDisciplina")
	private String nomeDisciplina;
}
