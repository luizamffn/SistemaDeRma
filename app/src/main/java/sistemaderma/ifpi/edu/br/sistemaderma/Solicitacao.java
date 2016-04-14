package sistemaderma.ifpi.edu.br.sistemaderma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import dao.ClienteDAO;
import dao.ContatoDAO;
import modelo.Cliente;
import modelo.Contato;

public class Solicitacao extends AppCompatActivity {
    ClienteDAO clienteDAO = new ClienteDAO(this);
    ContatoDAO contatoDAO = new ContatoDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

    }

    public void proximo(View view){
        EditText nome = (EditText) findViewById(R.id.nomeSolicitante);
        EditText cpf = (EditText) findViewById(R.id.cpfSolicitante);
        EditText email = (EditText) findViewById(R.id.email);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText endereco = (EditText) findViewById(R.id.endereco);
        RadioGroup radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        Button radioButton;

        if(""+nome.getText() == "" || ""+cpf.getText() == "" || ""+ telefone.getText() == "" || ""+ endereco.getText() == "" ){
            Toast.makeText(Solicitacao.this, "Por favor preencha todos os campos obrigatórios", Toast.LENGTH_SHORT).show();
        }else{
            Cliente c = new Cliente(""+nome.getText(), ""+cpf.getText());
            clienteDAO.inserirCliente(c);

            Contato contato = null;
            if(""+email.getText() != ""){
                contato = new Contato(c, "+email.getText()", Integer.valueOf(""+telefone.getText()),""+endereco.getText());
            }else{
                contato = new Contato(c, "", Integer.valueOf(""+telefone.getText()),""+endereco.getText());
            }

            contatoDAO.inserirContato(contato);

//            List<Cliente> clienteList = clienteDAO.listaDeCliente();
//            for (Cliente cc : clienteList){
//                System.out.println("Nome: " +cc.getNome());
//                System.out.println("cpf: " + cc.getCpf());
//            }

            int selectedId=radioGroup.getCheckedRadioButtonId();
            radioButton=(RadioButton)findViewById(selectedId);
//           Toast.makeText(this, "TextoBotao: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            Intent irParaInformacoesDoEquipamento = new Intent(this,InformacoesDoEquipamento.class);
            irParaInformacoesDoEquipamento.putExtra("tipo", ""+radioButton.getText());
            irParaInformacoesDoEquipamento.putExtra("cpfComprador", ""+c.getCpf());
            startActivity(irParaInformacoesDoEquipamento);
        }

    }
}
