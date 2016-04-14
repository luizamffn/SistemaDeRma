package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import modelo.Marca;

/**
 * Created by Luiza on 13/04/2016.
 */
public class MarcaDAO extends SQLiteOpenHelper {
    public MarcaDAO(Context context) {
        super(context, "Marca", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Marca" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome varchar(50));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Marca";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirMarca(Marca marca){
        ContentValues cv = new ContentValues();
        cv.put("nome", marca.getNome());

        getWritableDatabase().insert("Marca", null, cv);
    }

    public int retornarIdUltimaMarca(){
        int id = -1;
        String sql = "select id from Marca order by id desc limit 1";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            id = c.getInt(c.getColumnIndex("id"));
        }
        return id;
    }
}
