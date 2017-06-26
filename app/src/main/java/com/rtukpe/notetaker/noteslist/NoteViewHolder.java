package com.rtukpe.notetaker.noteslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rtukpe.notetaker.R;

/**
 * Created by rtukpe on 26/06/2017.
 */
class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView title, text;

    public NoteViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        text = (TextView) itemView.findViewById(R.id.text);
    }
}
