package br.com.mentorama.SpringJMS_Api.entities;

public enum Nota {

    ZERO(0), UM(1), DOIS(2), TRÊS(3), QUATRO(4), CINCO(5);

    public int Nota;

    Nota(int valor) {
        this.Nota = valor;
    }
}