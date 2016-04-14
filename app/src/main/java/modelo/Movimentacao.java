package modelo;

/**
 * Created by Luiza on 13/04/2016.
 */
public class Movimentacao {
    private int id;
    private Data data;
    private String tipo;

    public Movimentacao(Data data, String tipo) {
        this.data = data;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
