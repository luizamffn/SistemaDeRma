package modelo;

import enums.Status;
import enums.Tipo;

/**
 * Created by Luiza on 13/04/2016.
 */
public class Pedido {
    private int id;
    private Equipamento equipamento;
    private Tipo tipo;
    private double orcamento;
    private int prazo;
    private Status status;
    private String descricaoGeral;
    private String RMA;

    public Pedido(Equipamento equipamento, Tipo tipo, double orcamento, int prazo, Status status, String descricaoGeral, String RMA) {
        this.equipamento = equipamento;
        this.tipo = tipo;
        this.orcamento = orcamento;
        this.prazo = prazo;
        this.status = status;
        this.descricaoGeral = descricaoGeral;
        this.RMA = RMA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricaoGeral() {
        return descricaoGeral;
    }

    public void setDescricaoGeral(String descricaoGeral) {
        this.descricaoGeral = descricaoGeral;
    }

    public String getRMA() {
        return RMA;
    }

    public void setRMA(String RMA) {
        this.RMA = RMA;
    }
}
