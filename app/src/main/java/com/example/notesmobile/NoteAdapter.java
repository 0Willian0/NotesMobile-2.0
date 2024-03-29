package com.example.notesmobile;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewAnimator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder>{

    protected Context context;
    protected ArrayList<Notes> itens;
    NoteViewHolder holder;
    Notes notes;

    public NoteAdapter(Context context, ArrayList<Notes> itens)
    {
        this.context = context;
        this.itens = itens;

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int typeView)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        NoteViewHolder viewHolder = new NoteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int position)
    {
        noteViewHolder.title.setText(itens.get(position).getTitle());
        noteViewHolder.description.setText(itens.get(position).getDescription());

        noteViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            DB db = new DB(context);
            @Override
            public void onClick(View v) {
                System.out.println(itens.get(noteViewHolder.getAdapterPosition()).getId());
                int deleteId = itens.get(noteViewHolder.getAdapterPosition()).getId();
               long delete = db.deleteNotes(deleteId);
                if(delete != -1)
                {
                    Toast.makeText(context, "Deleted Note", Toast.LENGTH_LONG).show();
                    itens.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
        noteViewHolder.edit.setOnClickListener(new View.OnClickListener() {
            DB db = new DB(context);
            @Override
            public void onClick(View v) {
                int editId = itens.get(noteViewHolder.getAdapterPosition()).getId();
                int father = itens.get(noteViewHolder.getAdapterPosition()).getFather();
                String title = itens.get(noteViewHolder.getAdapterPosition()).getTitle();
                String description = itens.get(noteViewHolder.getAdapterPosition()).getDescription();
                Intent i = new Intent(context, EditScreen.class);
                i.putExtra("Id",editId);
                i.putExtra("Father", father);
                i.putExtra("Title", title);
                i.putExtra("Description", description);
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        noteViewHolder.subAdd.setOnClickListener(new View.OnClickListener(){
            DB db = new DB(context);
            @Override
            public void onClick(View v)
            {
                int addId = itens.get(noteViewHolder.getAdapterPosition()).getId();
                Intent i = new Intent(context, SubAddScreen.class);
                i.putExtra("Id", addId);
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        noteViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                int id = itens.get(noteViewHolder.getAdapterPosition()).getId();
                i.putExtra("Id", id);
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    public int getItemCount()
    {
        return itens.size();
    }

}
