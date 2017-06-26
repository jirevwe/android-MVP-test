package com.rtukpe.notetaker.noteslist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rtukpe.notetaker.R;
import com.rtukpe.notetaker.model.Note;
import com.rtukpe.notetaker.model.RemoteNoteDataSource;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesListActivity extends AppCompatActivity implements NoteContract.View {

    NoteContract.Presenter presenter;

    @BindView(R.id.notesListView)
    RecyclerView notesRecyclerView;

    RemoteNoteDataSource remoteNoteDataSource;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ButterKnife.bind(this);

        remoteNoteDataSource = new RemoteNoteDataSource();

        presenter = new NotePresenter(remoteNoteDataSource, this);

        presenter.populateNote();

        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(NoteContract.Presenter mPresenter) {
        presenter = mPresenter;
    }

    @Override
    public void setNotes(ArrayList<Note> notes) {
        NotesAdapter notesAdapter = new NotesAdapter(notes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        notesRecyclerView.setAdapter(notesAdapter);
        notesRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
