package com.rtukpe.notetaker.model;

/**
 * Created by rtukpe on 25/06/2017.
 */

public class Note {

    private int id;
    private String title;
    private String text;

    public Note(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
