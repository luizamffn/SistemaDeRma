package sistemaderma.ifpi.edu.br.sistemaderma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

public class TelaLogin extends AppCompatActivity {
    UsuarioDAO usuarioDAO = new UsuarioDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void cadastro(View v){
        Intent irParaCadatro = new Intent(this, TelaCadastro.class);
        startActivity(irParaCadatro);
    }

    public void entrar(View v){
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText senha = (EditText) findViewById(R.id.senha);

        List<String> nomesUsuarios = usuarioDAO.listaNomesUsuarios();

        if(""+usuario.getText() != "" & ""+senha.getText() !=""){
            if(nomesUsuarios.contains(""+usuario.getText())) {
                Usuario u = usuarioDAO.retornarUsuario("" + usuario.getText());

                if(u.getSenha().equals(""+senha.getText())){
                    Intent irParaBemVindo = new Intent(this, TelaInicial.class);
                    irParaBemVindo.putExtra("MENSAGEM",""+u.getNome());
                    irParaBemVindo.putExtra("idUsuario",""+u.getId());
                    startActivity(irParaBemVindo);
                }else{
                    Toast.makeText(TelaLogin.this, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(TelaLogin.this, "Usuario Não cadastrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(TelaLogin.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }


    }

}
