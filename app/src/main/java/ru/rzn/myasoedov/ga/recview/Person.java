package ru.rzn.myasoedov.ga.recview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25.08.2016.
 */
public class Person {
    String name;
    String age;
    int photoId;
    Person(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public static List<Person> initializeData(){
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.mipmap.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.mipmap.ic_launcher));
        return persons;
    }
}
