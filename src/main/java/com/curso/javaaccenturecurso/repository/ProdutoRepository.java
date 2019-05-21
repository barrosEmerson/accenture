package com.curso.javaaccenturecurso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.javaaccenturecurso.entidade.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByIdProduto(long id);
	Produto deleteByIdProduto(long id);
}
