package com.vertigo.sofrimento_part3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.vertigo.sofrimento_part3.model.Employee;
import com.vertigo.sofrimento_part3.repository.EmployeeRepository;
import com.vertigo.sofrimento_part3.service.EmployeeService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class SofrimentoPart3ApplicationTests {
	
	@LocalServerPort
    private int port;
	
	@Mock
    private EmployeeRepository employeeRepository;
	
	@InjectMocks 
    private EmployeeService employeeService;
	
	@Autowired(required = true)
    private TestRestTemplate restTemplate;
	
	
	@Test
	public void testaListar() throws RestClientException, MalformedURLException {
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:"+port+"/employee/listartodos").toString(),
				String.class);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testaBuscaNome() throws RestClientException, MalformedURLException {
		Map<String, String> variaveis = new HashMap<String, String>();
		variaveis.put("tipo", "nome");
		variaveis.put("valor", "levi");
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:"+port+"/employee/busca").toString(), String.class, variaveis);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testaBuscaDepartamento() throws RestClientException, MalformedURLException {
		Map<String, String> variaveis = new HashMap<String, String>();
		variaveis.put("tipo", "department");
		variaveis.put("valor", "ti");
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:"+port+"/employee/busca").toString(), String.class, variaveis);
		
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testaBuscaFuncao() throws RestClientException, MalformedURLException {
		Map<String, String> variaveis = new HashMap<String, String>();
		variaveis.put("tipo", "funcao");
		variaveis.put("valor", "estagiario");
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:"+port+"/employee/busca").toString(), String.class, variaveis);
		
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testaInserir() throws RestClientException, MalformedURLException {
		Employee employee = new Employee(1, "jorgin", "da 12", "dp do barulho", "guarda da 12", "patrao", null, "jorgin12@click21.com.br");

		ResponseEntity<String> response = restTemplate.postForEntity(new URL("http://localhost:"+port+"/employee/inserir").toString(), employee, String.class);
		
		assertEquals(201, response.getStatusCodeValue());
	}
}
