package modelo;

/**
 * Created by Luiza on 13/04/2016.
 */
public class Marca {
    private int id;
    private String nome;

    public Marca(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
