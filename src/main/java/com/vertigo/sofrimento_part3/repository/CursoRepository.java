package com.vertigo.sofrimento_part3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vertigo.sofrimento_part3.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	//Turma findById(int id);

}