package com.rtukpe.notetaker.noteslist;


import com.rtukpe.notetaker.BasePresenter;
import com.rtukpe.notetaker.BaseView;
import com.rtukpe.notetaker.model.Note;

import java.util.ArrayList;

/**
 * Created by rtukpe on 25/06/2017.
 */

public interface NoteContract {

    interface View extends BaseView<Presenter> {

        void setNotes(ArrayList<Note> notes);
    }

    interface Presenter extends BasePresenter {

        void populateNote();
    }
}
