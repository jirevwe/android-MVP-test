package com.rtukpe.notetaker.noteslist;

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

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> mNotes){
     notes = mNotes;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item_layout, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.text.setText(notes.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
