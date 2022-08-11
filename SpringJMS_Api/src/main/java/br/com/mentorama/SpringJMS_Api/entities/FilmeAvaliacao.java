package br.com.mentorama.SpringJMS_Api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FilmeAvaliacao {

    @Id
    private String avaliacaoId;

    private String usuarioId;

    private String filmeNome;

    private Nota nota;

    private String comentario;

    public FilmeAvaliacao(){}

    public FilmeAvaliacao(String avaliacaoId, String usuarioId, String filmeNome, Nota nota, String comentario) {
        this.avaliacaoId = avaliacaoId;
        this.usuarioId = usuarioId;
        this.filmeNome = filmeNome;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(String avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFilmeNome() {
        return filmeNome;
    }

    public void setFilmeNome(String filmeNome) {
        this.filmeNome = filmeNome;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
