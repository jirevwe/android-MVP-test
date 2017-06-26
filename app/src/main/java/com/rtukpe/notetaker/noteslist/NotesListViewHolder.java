package com.rtukpe.notetaker.noteslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rtukpe.notetaker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rtukpe on 26/06/2017.
 */
class NotesListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context context;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.text)
    TextView text;

    NotesListViewHolder(View itemView, Context context) {
        super(itemView);

        ButterKnife.bind(itemView);
        this.context = context;
        title = (TextView) itemView.findViewById(R.id.title);
        text = (TextView) itemView.findViewById(R.id.text);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition(); // gets item position
        if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
            ((NotesListActivity)context).onItemClick(position);
        }
    }
}
