package sistemaderma.ifpi.edu.br.sistemaderma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void novaSolicitacao(View v){
        Intent irParaSolicitacao = new Intent(this, Solicitacao.class);
        startActivity(irParaSolicitacao);
    }

    public void verSolicitacoes(View v){

    }
}
