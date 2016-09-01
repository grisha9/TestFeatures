package ru.rzn.myasoedov.ga.recview.dto;

import android.content.ContentValues;

import java.util.Date;

import ru.rzn.myasoedov.ga.recview.db.MessageContract;

/**
 * Created by User on 01.09.2016.
 */
public class Message {
    public long id;
    public String text;
    public Date date;
    public boolean isMy;

    public Message() {
    }

    public Message(String text, Date date, boolean isMy) {
        this.text = text;
        this.date = date;
        this.isMy = isMy;
    }


    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MessageContract.TEXT, text);
        values.put(MessageContract.DATE, date.getTime());
        values.put(MessageContract.IS_MY, isMy);
        return values;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", isMy=" + isMy +
                '}';
    }
}
