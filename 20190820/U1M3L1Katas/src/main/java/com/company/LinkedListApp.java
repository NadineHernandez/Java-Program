package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    public static int total(LinkedList<Integer> numbers) {

        int sum = 0;

        List<Integer> myNumbers = new LinkedList<>();
        myNumbers = numbers;

        Iterator<Integer> iter = myNumbers.iterator();

        while (iter.hasNext()) {
            sum += iter.next();
        }

        return sum;
    }

    public static int totalEven(LinkedList<Integer> numbers) {

        int sum = 0;

        List<Integer> myNumbers = new LinkedList<>();
        myNumbers = numbers;
        Iterator<Integer> iter = myNumbers.iterator();

        for (int i = 0; i < myNumbers.size(); i += 2) {
            sum += myNumbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(LinkedList<String> strings) {

        List<String> myStrings = new LinkedList<>();
        myStrings = strings;
        String temp = myStrings.get(0);
        myStrings.set(0, myStrings.get(myStrings.size() - 1));
        myStrings.set(myStrings.size() - 1, temp);

        return myStrings;
    }

    public static List<Integer> reverse(LinkedList<Integer> numbers) {

        List<Integer> myNumbers = new LinkedList<>();
        myNumbers = numbers;

        List<Integer> reversed = new LinkedList<>();

        for(int i = 0; i < myNumbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            int currentNum = myNumbers.get( myNumbers.size() - (i + 1) );
            reversed.add(currentNum);
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(LinkedList<Integer> numbers) {

        List<Integer> myNumbers = new LinkedList<>();
        myNumbers = numbers;

        List<Integer> lessThan =  new LinkedList<>();

        for(int num : myNumbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }
        if (lessThan.size() == 0) {
            return null;
        } else {
            return lessThan;
        }
    }
}
