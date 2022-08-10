package br.com.mentorama.SpringJMS_Api.controller;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;
import br.com.mentorama.SpringJMS_Api.entities.Usuario;
import br.com.mentorama.SpringJMS_Api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping
    public Mono<ResponseEntity<Void>> create (@RequestBody Usuario usuario){
        jmsTemplate.convertAndSend("Usuario", usuario);
        System.out.println("Usuario cadastrado");
        return usuarioService.create(usuario).map(user-> new ResponseEntity<Void>(HttpStatus.CREATED));

    }

    @GetMapping
    public Flux<ResponseEntity<Usuario>>findAll(){
          return usuarioService.findAll()
                  .map(user -> new ResponseEntity<Usuario>(user, HttpStatus.OK));

    }

    @GetMapping("/{id}")
    public Mono <ResponseEntity <Usuario>> findById(@PathVariable String id){
        return (usuarioService.findById(id)
                .map(user-> new ResponseEntity<Usuario>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}
