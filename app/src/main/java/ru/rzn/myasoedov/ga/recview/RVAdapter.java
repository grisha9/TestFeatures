package ru.rzn.myasoedov.ga.recview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 25.08.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
    List<Person> persons;
    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int i) {
        holder.personName.setText(persons.get(i).name);
        holder.personAge.setText(persons.get(i).age);
        holder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
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
