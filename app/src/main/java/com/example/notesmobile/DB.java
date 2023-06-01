package com.example.notesmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

public class DB extends SQLiteOpenHelper {
    private SQLiteDatabase dataBase = null;
    public static final String BankName =  "BankNotes";
    public static final int Version =  1;

    private static DB instance;

    public DB(Context context) {
        super(context,BankName,null,Version);
        dataBase = getWritableDatabase();
    }

    public static DB getInstance(Context context) {
        if(instance == null)
            instance = new DB(context);

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Notes.createTable);
        dataBase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Notes.DropTable);
        onCreate( sqLiteDatabase);

    }

    public void createNewTask(Notes notes) {
        ContentValues values = this.contentValuesTask(notes);
        notes.id = (int) getWritableDatabase().insert(Notes.tableName, null, values);


    }

    private ContentValues contentValuesTask(Notes notes) {
        ContentValues values = new ContentValues();
        values.put(notes.titleColumn, notes.getTitle());
        values.put(notes.descriptionColumn, notes.getDescription());
        return values;
    }

    public long editNotes(int id, String title, String description)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Notes.titleColumn, title);
        contentValues.put(Notes.descriptionColumn, description);
        return getWritableDatabase().update(Notes.tableName, contentValues,"idNote="+id,null);
    }

    public long deleteNotes(int id)
    {
        return getWritableDatabase().delete(Notes.tableName, "idNote="+id, null);
    }

    public ArrayList<Notes> listNotes()
    {
        ArrayList<Notes> noteList = new ArrayList<>();

        Cursor cursor = dataBase.query(Notes.tableName, new String[]{
                        Notes.idColumn,
                        Notes.titleColumn,Notes.descriptionColumn

                },
                null, null,null,null,null);

        while (cursor.moveToNext()){

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                Notes notes = null;

                notes = new Notes(
                        cursor.getInt(cursor.getColumnIndexOrThrow(Notes.idColumn)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Notes.titleColumn)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Notes.descriptionColumn))
                );

                noteList.add(notes);

            } else {

                Notes notes = new Notes(
                        cursor.getInt(cursor.getColumnIndexOrThrow(Notes.idColumn)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Notes.titleColumn)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Notes.descriptionColumn))
                );

                noteList.add(notes);

            }


        }
        return noteList;
    }
}
