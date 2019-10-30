package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static int total (ArrayList<Integer> numbers) {

        int sum = 0;

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers = numbers;

        Iterator<Integer> iter = myNumbers.iterator();

        while(iter.hasNext()){
            sum += iter.next();
        }

        return sum;
    }

    public static int totalEven (ArrayList<Integer> numbers) {

        int sum = 0;

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers = numbers;
        Iterator<Integer> iter = myNumbers.iterator();

        for (int i = 0; i < myNumbers.size(); i+=2) {
            sum += myNumbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(ArrayList<String> strings) {

        List<String> myStrings = new ArrayList<>();
        myStrings = strings;
        String temp = myStrings.get(0);
        myStrings.set(0, myStrings.get(myStrings.size() - 1));
        myStrings.set( myStrings.size() - 1, temp );

        return myStrings;
    }

    public static List<Integer> reverse(ArrayList<Integer> numbers) {

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers = numbers;

        List<Integer> reversed = new ArrayList<>();

        for(int i = 0; i < myNumbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            int currentNum = myNumbers.get( myNumbers.size() - (i + 1) );
            reversed.add(currentNum);
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(ArrayList<Integer> numbers) {

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers = numbers;

        List<Integer> lessThan =  new ArrayList<>();

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

    //challenge
    public static int[][] splitAtFive(int[] numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(String[] strings) {

        //leveraging integer division
        String[] odds = new String[ strings.length/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.length % 2 == 0) {
            evens = new String[ strings.length/2];
        } else {
            evens = new String[ strings.length/2 + 1];
        }

        for(int i = 0; i < strings.length; i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings[i];
            } else {
                odds[currIndex] = strings[i];
            }
        }

        return new String[][] { evens, odds };
    }
}
