package com.example.skolenutestesanassaraksts;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context context) {
        super(context, "student.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE studentCOV19 (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS studentCOV19");
        onCreate(db);
    }

    public boolean insertData(String name, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("DATE", date);

        long result = db.insert("studentCOV19", null, contentValues);

        if (result == -1) return false;
        else
            return true;
    }


    public void addNewStudent(String studentName) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", studentName);
        db.insert("studentCOV19", null, values);
        db.close();
    }

    public ArrayList<StudentModal> readStudents() {
        // on below line we are creating a
        // database for reading our database.
        ArrayList<StudentModal> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursor = db.rawQuery("SELECT * FROM studentCOV19", null);

        // on below line we are creating a new array list.


        // moving our cursor to first position.

        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String Date = cursor.getString(2);
            StudentModal studentModal = new StudentModal(id,name,Date);

            arrayList.add(studentModal);
        }


        return arrayList;

    }




}


