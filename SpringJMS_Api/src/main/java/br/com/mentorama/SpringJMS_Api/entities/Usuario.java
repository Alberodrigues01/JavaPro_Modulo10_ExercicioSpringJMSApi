package br.com.mentorama.SpringJMS_Api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Usuario {

    @Id
    private String id;

    private String nome;

    public Usuario(){}

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
