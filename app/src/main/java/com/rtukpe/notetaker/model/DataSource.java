package com.rtukpe.notetaker.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by rtukpe on 26/06/2017.
 */

public interface DataSource {

    interface LoadNotesCallback {

        boolean onNotesLoaded(ArrayList<Note> tasks);

        void onDataNotAvailable();
    }

    interface GetNoteCallback {

        void onNoteLoaded(Note task);

        void onDataNotAvailable();
    }

    void getNotes(@NonNull LoadNotesCallback callback);

    void getNote(int noteId, @NonNull GetNoteCallback callback);

    void saveNote(@NonNull Note note);

    void deleteAllNotes();

    void deleteNote(@NonNull String noteId);

}
