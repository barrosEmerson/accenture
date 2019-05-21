package com.curso.javaaccenturecurso.converter;

import org.springframework.stereotype.Component;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.model.ProdutoModel;

@Component
public class ProdutoConverter {
	
	public Produto converter(ProdutoModel model) {
		Produto prod = new Produto();
		prod.setIdProduto(model.getId());
		prod.setDescricao(model.getDescricao());
		prod.setValor(model.getValor());
		return prod;
	}

}
