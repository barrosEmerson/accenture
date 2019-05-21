package com.curso.javaaccenturecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.javaaccenturecurso.converter.ProdutoConverter;
import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;
import com.curso.javaaccenturecurso.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ProdutoConverter produtoConverter;
	
	public Iterable<Produto>findAll(){
		Iterable<Produto>produtos = repository.findAll();
		return produtos;
	}
	
	public Produto findById(Long id) {
		Produto prod = repository.findByIdProduto(id);
		return prod;
	}
	
	public Produto create(ProdutoModel model) {
		Produto prod = produtoConverter.converter(model);
		Produto produto  = repository.save(prod);
		return produto;
	}
	
	public Produto update(long id , ProdutoModel model) {
		Produto produtoId = repository.findByIdProduto(id);
		Produto produto = new Produto();
		if(produtoId!=null) {
			model.setId(id);
			Produto convProd = produtoConverter.converter(model);
			produto = repository.save(convProd);
			
		}
		return produto;
	}
	
	public Produto delete(long id) {
		Produto produto = repository.findByIdProduto(id);
		repository.delete(id);
		return produto;
	}
	
}
