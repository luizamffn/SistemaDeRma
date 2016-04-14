package modelo;

/**
 * Created by Luiza on 13/04/2016.
 */
public class Equipamento {
    private int numSerial;
    private String cpfComprador;
    private Marca marca;
    private Data dataEmissaoNF;
    private String descricao;
    private String modelo;
    private int notaFiscal;

    public Equipamento(int numSerial, String cpfComprador, Marca marca, Data dataEmissaoNF, String descricao, String modelo, int notaFiscal) {
        this.numSerial = numSerial;
        this.cpfComprador = cpfComprador;
        this.marca = marca;
        this.dataEmissaoNF = dataEmissaoNF;
        this.descricao = descricao;
        this.modelo = modelo;
        this.notaFiscal = notaFiscal;
    }



    public int getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(int numSerial) {
        this.numSerial = numSerial;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Data getDataEmissaoNF() {
        return dataEmissaoNF;
    }

    public void setDataEmissaoNF(Data dataEmissaoNF) {
        this.dataEmissaoNF = dataEmissaoNF;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
