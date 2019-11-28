package com.vertigo.sofrimento_part3.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vertigo.sofrimento_part3.model.Aluno;
import com.vertigo.sofrimento_part3.model.Curso;
import com.vertigo.sofrimento_part3.model.Employee;
import com.vertigo.sofrimento_part3.model.Turma;
import com.vertigo.sofrimento_part3.repository.AlunoRepository;
import com.vertigo.sofrimento_part3.repository.CursoRepository;
import com.vertigo.sofrimento_part3.repository.TurmaRepository;
import com.vertigo.sofrimento_part3.utils.Utils;

@RestController
@Validated
public class MockyController {
	@Autowired
	private CursoRepository cursoRepo;
	
	@Autowired
	private TurmaRepository turmaRepo;
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	@RequestMapping(value="/listar")
	public ResponseEntity<String> listaTodosEmployees(@RequestHeader("mocky") String mockyUrl) {	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = restTemplate.getForEntity(mockyUrl, List.class);
		return ResponseEntity.ok(Utils.toJSON(response.getBody()));
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST, 
			produces = { "application/json"}, 
			consumes = { "application/json"} )
	public ResponseEntity<String> insereEmployee(@RequestBody Employee employee, @RequestHeader("mocky") String mockyUrl) {	
		return ResponseEntity.status(HttpStatus.CREATED).body(Utils.toJSON(employee));
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.PUT, 
			produces = { "application/json"}, 
			consumes = { "application/json"} )
	public ResponseEntity<String> atualizaEmployee(@RequestBody Employee employee, @RequestHeader("mocky") String mockyUrl) {	
		return ResponseEntity.status(HttpStatus.OK).body(Utils.toJSON(employee));
	}
	
	@RequestMapping(value="/buscar/{id}", method = RequestMethod.GET,
			produces = { "application/json"})
	public ResponseEntity<String> buscaPorID(@PathVariable("id") int id, @RequestHeader("mocky") String mockyUrl) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = restTemplate.getForEntity(mockyUrl, List.class);
		Employee employeeRetorno = Utils.buscaEmployeesFromResponse(response, "id", ""+id).get(0);
		
		if(employeeRetorno != null) {
			return ResponseEntity.ok(Utils.toJSON(employeeRetorno)); 
		}else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET, 
			produces = { "application/json"})
	public ResponseEntity<String> buscaEmployee(@RequestHeader("mocky") String mockyUrl, @Valid @NotEmpty @RequestParam(value="tipo", required=false) String tipoDaBusca, @Valid @NotEmpty @RequestParam(value="valor", required=false) String palavraChave) {	
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List> response = restTemplate.getForEntity(mockyUrl, List.class);
		List<Employee> employees = Utils.buscaEmployeesFromResponse(response, tipoDaBusca, palavraChave);
		
		if(employees.isEmpty()) {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);			
		}else {
			return ResponseEntity.ok(Utils.toJSON(employees));
		}
	}
	
	@RequestMapping(value = "/remover", method = RequestMethod.DELETE,
			produces = { "application/json"})
	public ResponseEntity<String> removePorID(@RequestHeader("mocky") String mockyUrl, @RequestParam(value="id") int id) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = restTemplate.getForEntity(mockyUrl, List.class);
		Employee employeeRetorno = Utils.buscaEmployeesFromResponse(response, "id", ""+id).get(0);
		
		if(employeeRetorno != null) {
			return ResponseEntity.ok(Utils.toJSON(employeeRetorno)); 
		}else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET,
			produces = { "application/json"})
	public ResponseEntity<String> testaBancoNovo(){
		/*
		 * Curso curso = new Curso(); curso.setNome("Senai"); cursoRepo.save(curso);
		 */
		
		Curso curso = new Curso();
		curso.setId(9);
		curso.setNome("testeCurspkoihjophjoo");
	//	cursoRepo.save(curso);
		
		Turma turma = new Turma();
		turma.setDescricao("turma de verao");
		turma.setCurso(curso);
	//	turmaRepo.save(turma);
		
		Aluno aluno = new Aluno();
		aluno.setNome("dumbledore");
		alunoRepo.save(aluno);
		List<Aluno>alunoList = alunoRepo.findAll();
		
		return ResponseEntity.ok(Utils.toJSON(alunoList));
		
		/*
		 * Professor professor = new Professor(); professor.setDataDeNascimento(new
		 * Date()); professor.setNome("Tia cocota"); professor.setSexo(Sexo.F); return
		 * ResponseEntity.ok(Utils.toJSON(professor));
		 */
	}
	
}
