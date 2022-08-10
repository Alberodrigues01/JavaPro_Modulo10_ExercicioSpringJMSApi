package br.com.mentorama.SpringJMS_Api.config;

import br.com.mentorama.SpringJMS_Api.entities.FilmeAvaliacao;
import br.com.mentorama.SpringJMS_Api.entities.Usuario;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver{

    @JmsListener(destination = "FilmeAvaliacao", containerFactory = "myFactory")
    public void receiveAvaliacao(FilmeAvaliacao filmeAvaliacao){
        if(filmeAvaliacao.getUsuarioId()==null){
            throw new RuntimeException("Avaliação de Filme Inexistente");
        }
        System.out.println("Avaliação de Filme recebido da fila <" + filmeAvaliacao +">");
    }

    @JmsListener(destination = "Usuario", containerFactory = "myFactory")
    public void receiveUsuario(Usuario usuario){
        if(usuario.getNome()==null){
            throw new RuntimeException("Usuário Inexistente");
        }
        System.out.println("Cadastramento de Usuário recebido da fila <" + usuario +">");
    }

}
