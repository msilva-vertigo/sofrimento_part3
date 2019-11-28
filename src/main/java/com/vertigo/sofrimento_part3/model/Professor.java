package com.vertigo.sofrimento_part3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vertigo.sofrimento_part3.model.Enums.Sexo;

@Entity
@Table(name="professor")
public class Professor {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer idProfessor;
		
		@Column(name="sexo", length = 1)
		private Sexo sexo;
		
		@Column(name="nome", length = 100)
		private String nome;
		
		@Column(name="dataNascimento")
		private Date dataDeNascimento;

		public Professor() {}
		
		public Professor(Integer idProfessor, Sexo sexo, String nome, Date dataDeNascimento) {
			this.idProfessor = idProfessor;
			this.sexo = sexo;
			this.nome = nome;
			this.dataDeNascimento = dataDeNascimento;
		}

		public Integer getIdProfessor() {
			return idProfessor;
		}

		public void setIdProfessor(Integer idProfessor) {
			this.idProfessor = idProfessor;
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

			
		
}
