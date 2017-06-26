package com.rtukpe.notetaker.noteslist;

import android.content.Intent;
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
import com.rtukpe.notetaker.viewnotes.ViewNoteActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesListActivity extends AppCompatActivity implements NotesListContract.View {

    public static String NOTE_ID = "com.rtukpe.notetaker.noteslist.NotesListActivity.NOTE_ID";

    NotesListContract.Presenter presenter;

    @BindView(R.id.notesListView)
    RecyclerView notesRecyclerView;

    RemoteNoteDataSource remoteNoteDataSource;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    private NotesListAdapter notesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ButterKnife.bind(this);

        remoteNoteDataSource = new RemoteNoteDataSource();

        presenter = new NotesListPresenter(remoteNoteDataSource, this);

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
    public void setPresenter(NotesListContract.Presenter mPresenter) {
        presenter = mPresenter;
    }

    @Override
    public void setNotes(ArrayList<Note> notes) {
        notesListAdapter = new NotesListAdapter(notes, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        notesRecyclerView.setAdapter(notesListAdapter);
        notesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void onItemClick(int position){
        Intent intent = new Intent(this, ViewNoteActivity.class);
        intent.putExtra(NOTE_ID, notesListAdapter.getItemAtPosition(position).getId());
        startActivity(intent);
    }
}
