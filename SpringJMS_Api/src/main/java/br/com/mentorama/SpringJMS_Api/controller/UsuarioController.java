package br.com.mentorama.SpringJMS_Api.controller;

import br.com.mentorama.SpringJMS_Api.entities.Usuario;
import br.com.mentorama.SpringJMS_Api.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {


    private UsuarioService usuarioService;

    private JmsTemplate jmsTemplate;

    public UsuarioController(UsuarioService usuarioService, JmsTemplate jmsTemplate) {
        this.usuarioService = usuarioService;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody Usuario usuario) {
        jmsTemplate.convertAndSend("Usuario", usuario);
        System.out.println("Usuario cadastrado");
        return usuarioService.create(usuario).map(user -> new ResponseEntity<Void>(HttpStatus.CREATED));
    }

    @GetMapping
    public Flux<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Usuario>> findById(@PathVariable("id") String id) {
        return usuarioService.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
