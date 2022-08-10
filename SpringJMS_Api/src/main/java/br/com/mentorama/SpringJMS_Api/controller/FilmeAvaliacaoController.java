package br.com.mentorama.SpringJMS_Api.controller;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;
import br.com.mentorama.SpringJMS_Api.services.FilmeAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@RestController
@RequestMapping("/filme")
public class FilmeAvaliacaoController {

    @Autowired
    private FilmeAvaliacaoService filmesAvaliacaoService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public Mono<ResponseEntity<Void>> create (@RequestBody FilmeAvaliacao filmeAvaliacao) {
        jmsTemplate.convertAndSend("FilmeAvaliacao", filmeAvaliacao);
        System.out.println("Avaliação de filme enviada para a fila");
        return filmesAvaliacaoService.create(filmeAvaliacao).map(
                filme -> new ResponseEntity<Void>(HttpStatus.CREATED));
   }

    @GetMapping
    public Flux<ResponseEntity<FilmeAvaliacao>> findAll(){
        return filmesAvaliacaoService.findAll()
                .map(filme -> new ResponseEntity<FilmeAvaliacao>(
                filme, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity <FilmeAvaliacao>> findById(@PathVariable String id){
        return filmesAvaliacaoService.findById(id)
                .map(filme-> new ResponseEntity<>(filme, HttpStatus.OK));
    }
}
