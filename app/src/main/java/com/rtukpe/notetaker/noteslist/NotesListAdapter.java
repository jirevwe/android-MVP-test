package com.rtukpe.notetaker.noteslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtukpe.notetaker.R;
import com.rtukpe.notetaker.model.Note;

import java.util.ArrayList;

/**
 * Created by rtukpe on 26/06/2017.
 */

public class NotesListAdapter extends RecyclerView.Adapter<NotesListViewHolder> {
    private ArrayList<Note> notes;
    private Context context;

    public NotesListAdapter(ArrayList<Note> mNotes, Context context){
        this.context = context;
        notes = mNotes;
    }

    @Override
    public NotesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item_layout, parent, false);
        return new NotesListViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(NotesListViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.text.setText(notes.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public Note getItemAtPosition(int position){
        return notes.get(position);
    }

    public Note getFirstItem(){
        return notes.get(0);
    }

    public Note getLastItem(){
        return notes.get(notes.size()-1);
    }
}
