package dspersist.model;

public class Cidade {
    private Integer id;
    private String uf;
    private String nome;

    public Cidade(){}

    public Cidade(Integer id, String uf, String nome) {
        this.id = id;
        this.uf = uf;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", uf='" + uf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
