package com.rtukpe.notetaker.viewnotes;

import com.rtukpe.notetaker.BasePresenter;
import com.rtukpe.notetaker.BaseView;

/**
 * Created by rtukpe on 26/06/2017.
 */

public interface ViewNoteContract {

    interface View extends BaseView<Presenter> {
        void setTitle(String noteTitle);
        void setText(String noteText);
        void showToast(String message);
    }

    interface Presenter extends BasePresenter {
        void loadNote(int noteID);
    }
}
