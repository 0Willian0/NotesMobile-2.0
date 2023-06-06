package com.example.notesmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteViewHolder extends RecyclerView.ViewHolder{

    TextView title, description;
    ImageButton edit, delete, subAdd;

    LinearLayout linearLayout;

    public NoteViewHolder(@NonNull View v)
    {
        super(v);
        title = v.findViewById(R.id.title);
        delete = v.findViewById(R.id.deleteNoteButton);
        description = v.findViewById(R.id.description);
        edit = v.findViewById(R.id.editNoteButton);
        subAdd = v.findViewById(R.id.subAddButton);
        linearLayout = v.findViewById(R.id.linear);
    }

}
