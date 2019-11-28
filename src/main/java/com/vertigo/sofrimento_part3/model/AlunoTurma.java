package com.vertigo.sofrimento_part3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="alunoTurma")
public class AlunoTurma {

	
	@OneToMany
	private Aluno aluno;
	
	@Column(name = "dataMatricula")
	private Date dataMatricula;
	
	@Column(name = "dataCancelamento")
	private Date dataCancelamento;
	
	public AlunoTurma() {}
	
	public AlunoTurma(Date dataMatricula, Date dataCancelamento) {
		super();
		this.dataMatricula = dataMatricula;
		this.dataCancelamento = dataCancelamento;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	
	
	
}
