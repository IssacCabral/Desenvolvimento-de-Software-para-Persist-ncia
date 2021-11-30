package model;

import java.io.Serializable;

public class Livro implements java.io.Serializable {
    private String titulo;
    private String isbn;
    private String editora;
    private String anoPublicacao;

    public Livro(String titulo, String isbn, String editora, String anoPublicacao) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", editora='" + editora + '\'' +
                ", anoPublicacao='" + anoPublicacao + '\'' +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
