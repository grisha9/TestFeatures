package ru.rzn.myasoedov.ga.recview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rzn.myasoedov.ga.recview.db.MessageContract;
import ru.rzn.myasoedov.ga.recview.dto.Message;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.send)
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getSupportLoaderManager().initLoader(0, null, this);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(textView.getText())) {
                    Message message = new Message(textView.getText().toString(), new Date(), true);
                    textView.setText("");
                    getContentResolver().insert(MessageContract.CONTENT_URI,
                            message.toContentValues());
                }
            }
        });
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, MessageContract.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        rv.setAdapter(new RVAdapter(data));
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        rv.setAdapter(new RVAdapter());
    }
}
