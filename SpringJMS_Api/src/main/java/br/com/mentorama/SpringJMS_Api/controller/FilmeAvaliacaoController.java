package br.com.mentorama.SpringJMS_Api.controller;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;
import br.com.mentorama.SpringJMS_Api.services.FilmeAvaliacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/filme")
public class FilmeAvaliacaoController {


    private FilmeAvaliacaoService filmesAvaliacaoService;
    private JmsTemplate jmsTemplate;

    public FilmeAvaliacaoController(FilmeAvaliacaoService filmesAvaliacaoService,
                                    JmsTemplate jmsTemplate){
        this.filmesAvaliacaoService = filmesAvaliacaoService;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> create (@RequestBody FilmeAvaliacao filmeAvaliacao) {
        jmsTemplate.convertAndSend("FilmeAvaliacao", filmeAvaliacao);
        System.out.println("Avaliação de filme enviada para a fila");
        return filmesAvaliacaoService.create(filmeAvaliacao).map(
                filme -> new ResponseEntity<Void>(HttpStatus.CREATED));
   }

    @GetMapping
    public Flux<FilmeAvaliacao> findAll(){
        return filmesAvaliacaoService.findAll();

    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity <FilmeAvaliacao>> findById(@PathVariable("id") String id){
        return filmesAvaliacaoService.findById(id)
                .map(filme-> new ResponseEntity<>(filme, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
