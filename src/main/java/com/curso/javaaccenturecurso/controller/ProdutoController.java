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

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import com.curso.javaaccenturecurso.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("Api REST")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	@GetMapping("/produtos")
	@ApiOperation("Este método lista todos produtos")
	public Iterable<Produto>findAll(){
		Iterable<Produto>produtos = service.findAll();
		return produtos;
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation("Este método busca por produto especifico")
	public Produto findById(@PathVariable Long id) {
		Produto prod = service.findById(id);
		return prod;
	}
	
	@PostMapping("/produtos")
	@ApiOperation("Este método salva produtos na base de dados")
	public Produto create(@RequestBody ProdutoModel produto,BindingResult result) {
		 Produto prod = service.create(produto);
		 return prod;
	}
	
	@PutMapping("/produtos/{id}")
	@ApiOperation("Este método atualiza dados salvo na base de dados")
	public Produto update(@PathVariable long id, @RequestBody ProdutoModel model) {
		Produto produto = service.update(id, model);
		return produto;
	}
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation("Este método apaga produtos da base de dados")
	public Produto delete(@PathVariable long id) {
		Produto produto = service.delete(id);
		return produto;
	}
}
