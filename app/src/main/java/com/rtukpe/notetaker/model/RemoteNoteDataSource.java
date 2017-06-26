package com.rtukpe.notetaker.model;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rtukpe on 26/06/2017.
 */

public class RemoteNoteDataSource implements DataSource {

    private static RemoteNoteDataSource INSTANCE;

    public static RemoteNoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteNoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getNotes(@NonNull final LoadNotesCallback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/notes")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()){
                    callback.onDataNotAvailable();
                }

                String data = response.body().string();

                Gson gson = new Gson();
                Type collectionType = new TypeToken<ArrayList<Note>>(){}.getType();

                ArrayList<Note> notes = gson.fromJson(data, collectionType);
                callback.onNotesLoaded(notes);
            }
        });
    }

    @Override
    public void getNote(int noteId, @NonNull final GetNoteCallback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3000/notes/" + noteId)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()){
                    callback.onDataNotAvailable();
                }
                String data = response.body().string();

                Gson gson = new Gson();
                Note note = gson.fromJson(data, Note.class);
                callback.onNoteLoaded(note);
            }
        });
    }

    @Override
    public void saveNote(@NonNull Note note) {

    }

    @Override
    public void deleteAllNotes() {

    }

    @Override
    public void deleteNote(@NonNull String noteId) {

    }
}
