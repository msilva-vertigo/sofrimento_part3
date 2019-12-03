package com.vertigo.sofrimento_part3.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AlunoTurma {

	@ManyToOne(targetEntity = Turma.class)
	@JoinColumn(name = "idTurma", referencedColumnName = "id_turma")
	private Turma turma;
	
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "idAluno", referencedColumnName = "id_aluno")
	private Aluno aluno;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	public AlunoTurma() {}
	


	public AlunoTurma(Turma turma, Aluno aluno, Integer id) {
		super();
		this.turma = turma;
		this.aluno = aluno;
		this.id = id;
	}



	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
