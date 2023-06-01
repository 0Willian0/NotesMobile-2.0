package com.example.notesmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{

    RecyclerView recycler;
    NoteAdapter adapter;

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DB(this);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.noteList);
       // adapter = new NoteAdapter(this, db.listNotes());
        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);*/
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new NoteAdapter(getApplicationContext(),db.listNotes()));

    }

    public void addScreen(View v) {
        Intent add = new Intent(this, AddScreen.class);
        startActivity(add);
    }

}