package ru.rzn.myasoedov.ga.recview.db;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by User on 01.09.2016.
 */
public class MessageContract implements ProviGenBaseContract {
    @ContentUri
    public static Uri CONTENT_URI = Uri.parse("content://ru.rzn.myasoedov.ga.recview/messages");

    @Column(Column.Type.TEXT)
    public static final String TEXT = "text";
    @Column(Column.Type.INTEGER)
    public static final String DATE = "date";
    @Column(Column.Type.INTEGER)
    public static final  String IS_MY = "is_my";

}