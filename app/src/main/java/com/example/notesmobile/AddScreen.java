package com.example.notesmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddScreen extends Activity {

    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        db = new DB(this);
    }

    public void save(View v)
    {
        EditText title = findViewById(R.id.title);
        EditText description = findViewById(R.id.description);
        try{
            Notes note = new Notes(0,0, title.getText().toString(), description.getText().toString());
            db.createNewTask(note);
            Toast.makeText(getApplicationContext(), "Note created", Toast.LENGTH_LONG).show();
            back(v);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void back(View v)
    {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }

}