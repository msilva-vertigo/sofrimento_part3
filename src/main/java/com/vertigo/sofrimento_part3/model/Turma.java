package com.vertigo.sofrimento_part3.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vertigo.sofrimento_part3.model.Enums.Periodo;

@Entity
@Table(name="turma")
public class Turma {
	
	@OneToMany(targetEntity = AlunoTurma.class)
	@JoinColumn(name = "aluno_turma_id")
	private Set<AlunoTurma> alunoTurma;
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "alunoTurma", joinColumns = @JoinColumn(name = "idTurma"),
	 * inverseJoinColumns = @JoinColumn(name = "idAluno")) private List<Aluno>
	 * aluno;
	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTurma;
	
	@Column(name="datainicial")
	private Date dataInicial;
	
	@Column(name="dataFinal")
	private Date dataFinal;
	
	@Column(name="numProva")
	private Integer numProva;
	
	@Column(name="ano")
	private Integer ano;
	
	@Column(name="periodo", length = 50)
	private Periodo periodo;
	
	@Column(name="descricao", length = 100)
	private String descricao;
	

	
	@ManyToOne
	private Curso curso;
	



	public Turma() {}
	
	public Turma(Integer idTurma, Date dataInicial, Date dataFinal, Integer numProva, Integer ano, Periodo periodo,
			String descricao, Curso curso) {
		this.idTurma = idTurma;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.numProva = numProva;
		this.ano = ano;
		this.periodo = periodo;
		this.descricao = descricao;
		this.curso = curso;
	}
	


	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getNumProva() {
		return numProva;
	}

	public void setNumProva(Integer numProva) {
		this.numProva = numProva;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<AlunoTurma> getAlunoTurma() {
		return alunoTurma;
	}

	public void setAlunoTurma(Set<AlunoTurma> alunoTurma) {
		this.alunoTurma = alunoTurma;
	}

	
}
