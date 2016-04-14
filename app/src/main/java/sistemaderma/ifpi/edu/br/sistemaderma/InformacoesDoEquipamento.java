package sistemaderma.ifpi.edu.br.sistemaderma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dao.DataDAO;
import dao.EquipamentoDAO;
import dao.MarcaDAO;
import modelo.Data;
import modelo.Equipamento;
import modelo.Marca;

public class InformacoesDoEquipamento extends AppCompatActivity {
    DataDAO dataDAO = new DataDAO(this);
    MarcaDAO marcaDAO = new MarcaDAO(this);
    EquipamentoDAO equipamentoDAO = new EquipamentoDAO(this);

    Equipamento equipamento;

    String tipoSolicitacao;
    TextView dateDisplay;
    String cpfComprador;
    int dia,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_do_equipamento);

        tipoSolicitacao = getIntent().getStringExtra("tipo");
        cpfComprador = getIntent().getStringExtra("cpfComprador");

//        Button bSolicitar = (Button) findViewById(R.id.solicitar);
//        Button bProximo = (Button) findViewById(R.id.proximo);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                dateDisplay.setText("" + i2 + " / " + i1 + " / " + i);
                dia = i2; mes = i1; ano = i;
//                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });

//        if(tipoSolicitacao.equals("Garantia")){
//            bSolicitar.setVisibility(View.VISIBLE);
//        }else{
//            bProximo.setVisibility(View.VISIBLE);
//        }
    }

    public void proximo(View view){
        EditText descricaoEquipamento = (EditText) findViewById(R.id.descricaoEquipamento);
        EditText marca = (EditText) findViewById(R.id.marcaEquipamento);
        EditText modeloEquipamento = (EditText) findViewById(R.id.modeloEquipamento);
        EditText numSerial = (EditText) findViewById(R.id.numSerialEquipamento);
        EditText numNF = (EditText) findViewById(R.id.nfEquipamento);
        EditText dataEmissaoNF= (EditText) findViewById(R.id.descricaoEquipamento);

        if(""+descricaoEquipamento.getText() == "" || ""+marca.getText() == "" || ""+modeloEquipamento.getText() =="" ||
                ""+numSerial.getText() == "" || ""+numNF.getText() == "" || ""+dataEmissaoNF.getText() == "" ){
            Toast.makeText(InformacoesDoEquipamento.this, "Por favor preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{
            Data d = new Data(dia,mes,ano);
            dataDAO.inserirData(d);
            int idUltimaData = dataDAO.retornarIdUltimaData();
            d.setId(idUltimaData);

            Marca m = new Marca(""+marca.getText());
            marcaDAO.inserirMarca(m);
            int idUltimaMarca = marcaDAO.retornarIdUltimaMarca();
            m.setId(idUltimaMarca);

            equipamento = new Equipamento(Integer.valueOf(""+numSerial.getText()),cpfComprador,m,d,
                    ""+descricaoEquipamento.getText(), ""+modeloEquipamento.getText(), Integer.valueOf(""+numNF.getText()));

            equipamentoDAO.inserirEquipamento(equipamento);

            List<Integer> nums = equipamentoDAO.listaNumserial();
            for(Integer n : nums){
                System.out.println("NumSerial: " +n);
            }

            Intent irParaPedido = new Intent(this, Pedido.class);
            irParaPedido.putExtra("tipoSolicitacao", tipoSolicitacao);
            irParaPedido.putExtra("id_equipamento", ""+equipamento.getNumSerial());
            startActivity(irParaPedido);
        }


    }


}
