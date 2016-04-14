package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipamento;

/**
 * Created by Luiza on 13/04/2016.
 */
public class EquipamentoDAO extends SQLiteOpenHelper {
    public EquipamentoDAO(Context context) {
        super(context, "Equipamento", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Equipamento" +
                "(numSerial INTEGER PRIMARY KEY, " +
                "cpf_cliente varchar(30), " +
                "id_marca integer, " +
                "id_dataEmimssaoNF integer, " +
                "descricao varchar(100)," +
                "modelo varchar(30), " +
                "notaFiscal integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Equipamento";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirEquipamento(Equipamento equipamento){
        ContentValues cv = new ContentValues();
        cv.put("numSerial", equipamento.getNumSerial());
        cv.put("cpf_cliente", equipamento.getCpfComprador());
        cv.put("id_marca", equipamento.getMarca().getId());
        cv.put("id_dataEmimssaoNF", equipamento.getDataEmissaoNF().getId());
        cv.put("descricao", equipamento.getDescricao());
        cv.put("modelo", equipamento.getModelo());
        cv.put("notaFiscal", equipamento.getNotaFiscal());

        getWritableDatabase().insert("Equipamento", null, cv);
    }

    public List<Integer> listaNumserial(){
        List<Integer> listaDenum = new ArrayList<>();
        String sql = "select * from Equipamento";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            int num = c.getInt(c.getColumnIndex("numSerial"));


            listaDenum.add(num);
        }

        return listaDenum;
    }

    public Equipamento returnEquipamento(int id){
        Equipamento e= null;
        String sql = "select *from Equipamento where numSerial = " + id;
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            int numSerial = c.getInt(c.getColumnIndex("numSerial"));
            String cpf = c.getString(c.getColumnIndex("cpf_cliente"));

            e = new Equipamento(numSerial,cpf);
        }

        return e;
    }


}
