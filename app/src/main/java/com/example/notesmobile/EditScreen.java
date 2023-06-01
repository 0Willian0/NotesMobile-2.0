package com.example.notesmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditScreen extends Activity {

    DB db;
    EditText title, description;
    int idIntent;
    String titleIntent, descriptionIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        idIntent = getIntent().getIntExtra("Id", 0);
        titleIntent = getIntent().getStringExtra("Title");
        descriptionIntent = getIntent().getStringExtra("Description");
        title.setText(titleIntent);
        description.setText(descriptionIntent);
        db = new DB(this);
    }

    public void save(View v)
    {
        try{
            long edit = db.editNotes(idIntent, title.getText().toString(), description.getText().toString());
            if (edit != -1) {
                Toast.makeText(getApplicationContext(), "Note Updated", Toast.LENGTH_LONG).show();
                back(v);
            }
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
