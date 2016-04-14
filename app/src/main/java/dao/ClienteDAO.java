package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

/**
 * Created by Luiza on 13/04/2016.
 */
public class ClienteDAO extends SQLiteOpenHelper {
    public ClienteDAO(Context context) {
        super(context, "Cliente.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Cliente" +
                "(cpf varchar(30) PRIMARY KEY, " +
                "nome varchar(50), " +
                "id_contato integer);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Cliente";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirCliente(Cliente cliente){
        ContentValues cv = new ContentValues();
        cv.put("nome", cliente.getNome());
        cv.put("cpf", cliente.getCpf());

        getWritableDatabase().insert("cliente", null, cv);
    }

    public List<Cliente> listaDeCliente(){
        List<Cliente> listaDeCliente = new ArrayList<>();
        String sql = "select * from Cliente";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            String cpf = c.getString(c.getColumnIndex("cpf"));
            String nome = c.getString(c.getColumnIndex("nome"));

            Cliente cliente = new Cliente(nome,cpf);

            listaDeCliente.add(cliente);
        }

        return listaDeCliente;
    }

}
