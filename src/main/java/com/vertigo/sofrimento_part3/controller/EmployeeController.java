package com.vertigo.sofrimento_part3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vertigo.sofrimento_part3.model.Employee;
import com.vertigo.sofrimento_part3.service.EmployeeService;
import com.vertigo.sofrimento_part3.utils.Utils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/employee")
@Validated
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation("Retorna todos os Employees do banco de dados")
	@RequestMapping(value = "/listartodos", method = RequestMethod.GET, produces = { "application/json"})
	public ResponseEntity<String> listaTodosEmployees() {		
		return ResponseEntity.ok(Utils.toJSON(employeeService.buscaEmployees()));
	}
	

	
	@ApiOperation("Retorna o Employee com o id informado")
	@RequestMapping(value="", method = RequestMethod.GET, produces = { "application/json"})
	public ResponseEntity<String> buscaPorID(@RequestParam("id") int id) {
		 return	ResponseEntity.ok(Utils.toJSON(employeeService.buscaPorID(id))); 
	}
	 
	
	
	@ApiOperation("Insere no banco o Employee com as informações passadas no body")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST, 
			produces = { "application/json"}, 
			consumes = { "application/json"} )
	public ResponseEntity<String> inserirEmployee(@RequestBody Employee employee) {	
		if(employeeService.insereEmployee(employee)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(Utils.toJSON(employee));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Utils.toJSON(employee));
		}
	}
	
	
	@ApiOperation("Retorna os Employees que possuam o valor informado. Tipos de busca: id, department, nome e funcao")
	@RequestMapping(value = "/buscar", method = RequestMethod.GET, 
			produces = { "application/json"})
	public ResponseEntity<String> buscaEmployee(@Valid @NotEmpty @RequestParam(value="tipo", required=false) String tipoDaBusca, @Valid @NotEmpty @RequestParam(value="valor", required=false) String palavraChave) {	
		
		List<Employee> listaDeRetorno = new ArrayList<Employee>();
		
		switch (tipoDaBusca){
			case "department":
				listaDeRetorno = employeeService.buscaPorDepartamento(palavraChave);
				break;
			case "nome":
				listaDeRetorno = employeeService.buscaPorNome(palavraChave);
				break;
			case "funcao":
				listaDeRetorno = employeeService.buscaPorFuncao(palavraChave);
				break;
			case "id":
				listaDeRetorno.add(employeeService.buscaPorID(Integer.parseInt(palavraChave)));
				break;
		}
		
		return ResponseEntity.ok(Utils.toJSON(listaDeRetorno));
	}
	
	
	//NÃO FUNCIONA
	@ApiOperation("Remove o Employee com o id informado")
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE, produces = { "application/json"})
	public String removePorID(@PathVariable int id) {
		
		String retorno = "O employee foi removido com sucesso.";
		
		if(employeeService.removeEmployee(id)) {
			retorno.replace("foi", "nao foi");
		}
		
		return retorno;
	}
	
}
