package com.rtukpe.notetaker.viewnotes;

import com.rtukpe.notetaker.model.DataSource;
import com.rtukpe.notetaker.model.Note;
import com.rtukpe.notetaker.model.RemoteNoteDataSource;

/**
 * Created by rtukpe on 26/06/2017.
 */

public class ViewNotePresenter implements ViewNoteContract.Presenter, DataSource.GetNoteCallback {

    private RemoteNoteDataSource remoteNoteDataSource;
    private ViewNoteContract.View view;

    public ViewNotePresenter(RemoteNoteDataSource mRemoteNoteDataSource, ViewNoteContract.View mView){
        remoteNoteDataSource = mRemoteNoteDataSource;
        view = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadNote(int noteID) {
        remoteNoteDataSource.getNote(noteID, this);
    }

    @Override
    public void onNoteLoaded(Note note) {
        view.setText(note.getText());
        view.setTitle(note.getTitle());
        view.showToast("Note opened");
    }

    @Override
    public void onDataNotAvailable() {
        view.showToast("Data not available");
    }
}
