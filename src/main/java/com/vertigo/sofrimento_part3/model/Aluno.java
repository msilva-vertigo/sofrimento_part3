package com.vertigo.sofrimento_part3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vertigo.sofrimento_part3.model.Enums.EstadoCivil;
import com.vertigo.sofrimento_part3.model.Enums.Sexo;

@Entity
@Table(name="aluno")
public class Aluno {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer idAluno;
		
		@Column(name="sexo", length = 1)
		private Sexo sexo;
		
		@Column(name="nome", length = 100)
		private String nome;
		
		@Column(name="dataNascimento")
		private Date dataDeNascimento;
		
		@Column(name="nomeDoPai", length = 100)
		private String nomeDoPai;
		
		@Column(name="nomeDaMae", length = 100)
		private String nomeDaMae;
		
		@Column(name="estadoCivil", length = 50)
		private EstadoCivil estadoCivil;

		public Aluno(){}

		public Aluno(Integer idAluno, Sexo sexo, String nome, Date dataDeNascimento, String nomeDoPai, String nomeDaMae,
				EstadoCivil estadoCivil) {
			this.idAluno = idAluno;
			this.sexo = sexo;
			this.nome = nome;
			this.dataDeNascimento = dataDeNascimento;
			this.nomeDoPai = nomeDoPai;
			this.nomeDaMae = nomeDaMae;
			this.estadoCivil = estadoCivil;
		}

		public Integer getIdAluno() {
			return idAluno;
		}

		public void setIdAluno(Integer idAluno) {
			this.idAluno = idAluno;
		}

		public Sexo getSexo() {
			return sexo;
		}

		public void setSexo(Sexo sexo) {
			this.sexo = sexo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Date getDataDeNascimento() {
			return dataDeNascimento;
		}

		public void setDataDeNascimento(Date dataDeNascimento) {
			this.dataDeNascimento = dataDeNascimento;
		}

		public String getNomeDoPai() {
			return nomeDoPai;
		}

		public void setNomeDoPai(String nomeDoPai) {
			this.nomeDoPai = nomeDoPai;
		}

		public String getNomeDaMae() {
			return nomeDaMae;
		}

		public void setNomeDaMae(String nomeDaMae) {
			this.nomeDaMae = nomeDaMae;
		}

		public EstadoCivil getEstadoCivil() {
			return estadoCivil;
		}

		public void setEstadoCivil(EstadoCivil estadoCivil) {
			this.estadoCivil = estadoCivil;
		}
		
		
}
