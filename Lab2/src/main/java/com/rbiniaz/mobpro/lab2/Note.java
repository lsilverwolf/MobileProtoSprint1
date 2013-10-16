package com.rbiniaz.mobpro.lab2;

/**
 * Created by rachel on 9/18/13.
 */
public class Note {
    private long id;
    private String listitem;

    public Note(long id, String listitem) {
        this.id = id;
        this.listitem = listitem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return listitem;
    }

    public void setName(String listitem) {
        this.listitem = listitem;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + listitem + '\'' +
                '}';
    }
}
