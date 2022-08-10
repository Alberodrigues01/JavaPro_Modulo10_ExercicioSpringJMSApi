package br.com.mentorama.SpringJMS_Api.services;

import br.com.mentorama.SpringJMS_Api.entities.Usuario;
import br.com.mentorama.SpringJMS_Api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

        @Autowired
        UsuarioRepository usuarioRepository;

        public Mono<Usuario> create (Usuario usuario){
            return usuarioRepository.save(usuario);
        }

        public Mono<Usuario> findById (String id) {
             return usuarioRepository.findById(id);
        }

        public Flux<Usuario> findAll(){
            return usuarioRepository.findAll();
        }
    }


