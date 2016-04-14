package sistemaderma.ifpi.edu.br.sistemaderma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dao.EquipamentoDAO;
import dao.PedidoDAO;
import enums.Status;
import enums.Tipo;
import modelo.Equipamento;

public class Pedido extends AppCompatActivity {
    EquipamentoDAO equipamentoDAO = new EquipamentoDAO(this);
    PedidoDAO pedidoDAO = new PedidoDAO(this);
    String tipoSolicitacao,id_equipamento;

    TextView rma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        EditText orcamento = (EditText)findViewById(R.id.orcamentoPedido);
        EditText prazo = (EditText)findViewById(R.id.prazoPedido);

        tipoSolicitacao = getIntent().getStringExtra("tipoSolicitacao");
        id_equipamento = getIntent().getStringExtra("id_equipamento");

        TextView tipoSol = (TextView) findViewById(R.id.tipoSol);
        rma = (TextView) findViewById(R.id.rmaPedido);
        rma.setText(gerarRMA());
        tipoSol.setText(""+tipoSolicitacao);

        if(!tipoSolicitacao.equals("Garantia")){
            orcamento.setVisibility(View.VISIBLE);
            prazo.setVisibility(View.VISIBLE);}
    }

    public void finalizar(View view){
        EditText descricaoGeral = (EditText)findViewById(R.id.descricaoGeral);

        if(tipoSolicitacao.equals("Garantia")){
            System.out.print("akiiii2");
            if(descricaoGeral.getText().toString().equals("") || rma.getText().toString().equals("")){
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }else {
                Equipamento e = equipamentoDAO.returnEquipamento(Integer.valueOf(id_equipamento));
                modelo.Pedido p = new modelo.Pedido(e, Tipo.Gatantia, 0.00, 0, Status.AUTORIZADO, "" + descricaoGeral.getText(), "" + rma.getText());

                pedidoDAO.inserirPedido(p);

                List<Integer> ids = pedidoDAO.listIdPedido();
                for (int i : ids) {
                    System.out.print("id Pedido " + i);
                }
            }
        }else{
                System.out.print("akiiii");

            }
        }


    public String gerarRMA(){
        String codigo = "M";
        int num = (int)(Math.random() * 10000);
        codigo += num;

        return codigo;
    }

}
