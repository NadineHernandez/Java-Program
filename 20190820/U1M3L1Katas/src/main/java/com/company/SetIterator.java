package com.company;

import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {
    public void printSet(int a, int b, int c, int d, int e){
    HashSet<Integer> numbers = new HashSet<>();
    numbers.add(a);
    numbers.add(b);
    numbers.add(c);
    numbers.add(d);
    numbers.add(e);

        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
