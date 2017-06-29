package com.rtukpe;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rtukpe.notetaker.model.DataSource;
import com.rtukpe.notetaker.model.Note;
import com.rtukpe.notetaker.model.RemoteNoteDataSource;

import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rtukpe on 28/06/2017.
 */

public class RemoteDataSourceTest {

    @Mock
    DataSource.LoadNotesCallback loadNotesCallback;

    String data = "[\n" +
            "    {\n" +
            "        id: 1,\n" +
            "        title: \"Home\",\n" +
            "        text: \"Home is where your feet are standing\"\n" +
            "    },\n" +
            "    {\n" +
            "        id: 2,\n" +
            "        title: \"School\",\n" +
            "        text: \"School is where you learn new stuff\"\n" +
            "    },\n" +
            "    {\n" +
            "        id: 3,\n" +
            "        title: \"Work\",\n" +
            "        text: \"Work is where you get better at stuff\"\n" +
            "    },\n" +
            "    {\n" +
            "        id: 4,\n" +
            "        title: \"Grave\",\n" +
            "        text: \"Grave is where you die and stuff\"\n" +
            "    },\n" +
            "]";

    @Test
    public void testLoadNotes() {
        RemoteNoteDataSource remoteNoteDataSource = RemoteNoteDataSource.getInstance();
        remoteNoteDataSource.getNotes(loadNotesCallback);



        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Note>>(){}.getType();
        ArrayList<Note> notes = gson.fromJson(data, collectionType);

    }
}
