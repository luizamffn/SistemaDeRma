package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import modelo.Data;

/**
 * Created by Luiza on 13/04/2016.
 */
public class DataDAO extends SQLiteOpenHelper {
    public DataDAO(Context context) {
        super(context, "Data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Data" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "dia integer, " +
                "mes integer, " +
                "ano integer);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Data";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirData(Data data){
        ContentValues cv = new ContentValues();
        cv.put("dia", data.getDia());
        cv.put("mes", data.getMes());
        cv.put("ano", data.getAno());

        getWritableDatabase().insert("Data", null, cv);
    }

    public int retornarIdUltimaData(){
        int id = -1;
        String sql = "select id from Data order by id desc limit 1";
        Cursor c = getReadableDatabase().rawQuery(sql, null);

        while (c.moveToNext()){
            id = c.getInt(c.getColumnIndex("id"));
        }
        return id;
    }
}
