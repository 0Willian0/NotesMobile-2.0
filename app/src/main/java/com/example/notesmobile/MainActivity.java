package com.example.notesmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{

    RecyclerView recycler;
    DB db;

    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DB(this);
        setContentView(R.layout.activity_main);
        id = getIntent().getIntExtra("Id",0);
        recycler = findViewById(R.id.noteList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        if(id == 0) {
            recycler.setAdapter(new NoteAdapter(getApplicationContext(), db.listNotes(0)));
        }
        else {
            recycler.setAdapter(new NoteAdapter(getApplicationContext(), db.listNotes(id)));
        }
    }

    public void addScreen(View v) {
        Intent add = new Intent(this, AddScreen.class);
        startActivity(add);
    }
}