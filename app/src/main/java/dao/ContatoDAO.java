package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import modelo.Contato;

/**
 * Created by Luiza on 13/04/2016.
 */
public class ContatoDAO extends SQLiteOpenHelper {
    public ContatoDAO(Context context) {
        super(context, "Contato", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Contato" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cpf_cliente varchar(30), " +
                "email varchar(50), " +
                "telefone int, " +
                "endereco varchar(150));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Contato";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirContato(Contato contato){
        ContentValues cv = new ContentValues();
        cv.put("cpf_cliente", contato.getCliente().getCpf());
        cv.put("email", contato.getEmail());
        cv.put("telefone", contato.getTelefone());
        cv.put("endereco", contato.getEndereco());

        getWritableDatabase().insert("Contato", null, cv);
    }
}
