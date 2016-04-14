package modelo;

/**
 * Created by Luiza on 13/04/2016.
 */
public class Detalhe {
    private int id;
    private String descricaoItem;
    private Pedido pedido;

    public Detalhe(String descricaoItem, Pedido pedido) {
        this.descricaoItem = descricaoItem;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
