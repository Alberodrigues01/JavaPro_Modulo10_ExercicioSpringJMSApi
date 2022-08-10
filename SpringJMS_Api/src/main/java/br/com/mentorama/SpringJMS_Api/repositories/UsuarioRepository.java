package br.com.mentorama.SpringJMS_Api.repositories;

import br.com.mentorama.SpringJMS_Api.entities.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, String> {

}
