package br.com.mentorama.SpringJMS_Api.services;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;
import br.com.mentorama.SpringJMS_Api.repositories.FilmeAvaliacaoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FilmeAvaliacaoService {

     private FilmeAvaliacaoRepository filmeAvaliacaoRepository;

     public FilmeAvaliacaoService(FilmeAvaliacaoRepository filmeAvaliacaoRepository){
         this.filmeAvaliacaoRepository = filmeAvaliacaoRepository;
     }

    public Mono<FilmeAvaliacao> create (FilmeAvaliacao filmeAvaliacao){
         return filmeAvaliacaoRepository.save(filmeAvaliacao);
    }

    public Mono<FilmeAvaliacao> findById(String id){
        return filmeAvaliacaoRepository.findById(id);
    }

    public Flux<FilmeAvaliacao> findAll(){
        return  filmeAvaliacaoRepository.findAll();

    }
}
