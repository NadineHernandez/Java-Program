package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class ClassmatesList {
    private ArrayList<Classmate> classmates = new ArrayList<>();

    public void add(Classmate classmate){
        classmates.add(classmate);
    }

    public Classmate get(int classNum){
        return classmates.get(classNum);
    }

    public ArrayList<Classmate> getAll(){
        Iterator<Classmate> iter = classmates.iterator();

        ArrayList<Classmate> allClassmates = new ArrayList<>();
        //while there is a next element to read print element
        while(iter.hasNext()){
            allClassmates.add(iter.next());
        }
        return allClassmates;
    }
}
