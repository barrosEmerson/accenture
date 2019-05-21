package com.curso.javaaccenturecurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.javaaccenturecurso.entidade.Cliente;
import com.curso.javaaccenturecurso.model.ClienteModel;
import com.curso.javaaccenturecurso.service.ServiceCurso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Api REST")
@CrossOrigin("*")
@RequestMapping("/api")
public class Controller {

	@Autowired
	private ServiceCurso service;

	@GetMapping("/cliente")
	@ApiOperation("Este Metodo Lista todos Clientes")
	public Iterable<Cliente> findAll() {
		Iterable<Cliente> response = service.buscarTodosCliente();
		return response;
	}

	@GetMapping(path = { "/cliente/{id}" })
	@ApiOperation("Este Metodo busca um cliente por unico")
	public Cliente findById(@PathVariable long id) {
		Cliente response = service.buscarClientePeloDocumento(id);
		return response;
	}

	@PostMapping("/cliente")
	@ApiOperation("Este Metodo salva um cliente na base de dados")
	public Cliente create(@RequestBody ClienteModel cliente, BindingResult bindingResult) {
		Cliente response = service.cadastrarCliente(cliente);
		return response;
	}

	@DeleteMapping(path = { "/cliente/{id}" })
	@ApiOperation("Este Metodo apaga um cliente da base de dados")
	public Cliente delete(@PathVariable String id) {
		Cliente response = service.deletarCliente(id);
		return response;
	}

	@PutMapping(value = "/cliente/{id}")
	@ApiOperation("Este Metodo atualiza dados de um cliente salvo na base de dados")
	public Cliente update(@PathVariable("id") String id, @RequestBody ClienteModel cliente) {
		Cliente response = service.editarCliente(id, cliente);
		return response;
	}
}
