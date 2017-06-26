package com.rtukpe.notetaker.noteslist;

import com.rtukpe.notetaker.model.Note;
import com.rtukpe.notetaker.model.RemoteNoteDataSource;

import java.util.ArrayList;

/**
 * Created by rtukpe on 25/06/2017.
 */

public class NotesListPresenter implements NotesListContract.Presenter, RemoteNoteDataSource.LoadNotesCallback {

    private RemoteNoteDataSource remoteNoteDataSource;
    private NotesListContract.View view;

    public NotesListPresenter(RemoteNoteDataSource mRemoteNoteDataSource, NotesListContract.View mNoteView) {
        remoteNoteDataSource = mRemoteNoteDataSource;
        view = mNoteView;

        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onNotesLoaded(ArrayList<Note> notes) {
        view.setNotes(notes);
    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void populateNote() {
        remoteNoteDataSource.getNotes(this);
    }
}
