package ru.rzn.myasoedov.ga.recview;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rzn.myasoedov.ga.recview.db.MessageContract;

/**
 * Created by User on 25.08.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
    Cursor cursor;

    public RVAdapter() {
    }

    public RVAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int i) {
        if (cursor != null) {
            cursor.moveToPosition(i);
        }
        String id = (cursor != null) ? String.valueOf(cursor
                .getLong(cursor.getColumnIndex(MessageContract._ID))) : "";
        String text = (cursor != null) ? cursor.getString(cursor
                .getColumnIndex(MessageContract.TEXT)) : "";

        holder.personName.setText(id);
        holder.personAge.setText(cursor.getString(cursor.getColumnIndex(MessageContract.TEXT)));
        holder.personPhoto.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }



    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.person_name) TextView personName;
        @BindView(R.id.person_age) TextView personAge;
        @BindView(R.id.person_photo) ImageView personPhoto;
        PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
