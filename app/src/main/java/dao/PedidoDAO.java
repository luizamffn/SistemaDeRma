package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;

/**
 * Created by Luiza on 13/04/2016.
 */
public class PedidoDAO extends SQLiteOpenHelper{
    public PedidoDAO(Context context) {
        super(context, "Pedido.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Pedido" +
                "(id integer PRIMARY KEY, " +
                "id_equipamento integer," +
                "tipo varchar(30), " +
                "orcamento double, " +
                "prazo integer, " +
                "status varchar(50)," +
                "descricaoGeral varchar(300)," +
                "rma varchar(50) );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Pedido";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirPedido(Pedido pedido){
        ContentValues cv = new ContentValues();
        cv.put("id_equipamento", pedido.getEquipamento().getNumSerial());
        cv.put("tipo", ""+pedido.getTipo());
        cv.put("orcamento", pedido.getOrcamento());
        cv.put("prazo", pedido.getPrazo());
        cv.put("descricaoGeral", pedido.getDescricaoGeral());
        cv.put("rma", pedido.getRMA());

        getWritableDatabase().insert("Pedido", null, cv);
    }

    public List<Integer> listIdPedido(){
        List<Integer> idListe = new ArrayList<>();
        String sql = "select * from Pedido";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));

            idListe.add(id);
        }

        return idListe;
    }


}
