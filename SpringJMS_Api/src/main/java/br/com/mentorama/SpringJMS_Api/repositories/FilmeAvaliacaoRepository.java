package br.com.mentorama.SpringJMS_Api.repositories;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface FilmeAvaliacaoRepository extends ReactiveCrudRepository<FilmeAvaliacao, String> {

}
