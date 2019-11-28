package com.vertigo.sofrimento_part3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vertigo.sofrimento_part3.model.Turma;

public interface CursoRepository extends JpaRepository<Turma, Integer> {

	Turma findById(int id);

}