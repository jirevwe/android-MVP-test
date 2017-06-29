package com.rtukpe.notetaker.viewnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.rtukpe.notetaker.R;
import com.rtukpe.notetaker.model.RemoteNoteDataSource;
import com.rtukpe.notetaker.noteslist.NotesListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewNoteActivity extends AppCompatActivity implements ViewNoteContract.View {

    ViewNoteContract.Presenter presenter;
    RemoteNoteDataSource remoteNoteDataSource;

    @BindView(R.id.titleTextView)
    TextView titleTextView;

    @BindView(R.id.textTextView)
    TextView textTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        remoteNoteDataSource = RemoteNoteDataSource.getInstance();
        presenter = new ViewNotePresenter(remoteNoteDataSource, this);

        int noteid = getIntent().getIntExtra(NotesListActivity.NOTE_ID, 0);
        presenter.loadNote(noteid - 1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setPresenter(ViewNoteContract.Presenter mPresenter) {
        presenter = mPresenter;
    }

    @Override
    public void setTitle(String noteTitle) {
        titleTextView.setText(noteTitle);
    }

    @Override
    public void setText(String noteText) {
        textTextView.setText(noteText);
    }

    @Override
    public void showToast(final String message) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(ViewNoteActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
