package com.company;

import java.util.Scanner;

public class App {

    public static int total(int[] input) {
        int sum = 0;

        for (int element: input) {
            sum += element;
        }
        return sum;
    }

    public static int totalOdd(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (i%2 != 0) {
                sum += input[i];
            }
        }
        return sum;
    }

    public static int totalEven(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (i%2 == 0) {
                sum += input[i];
            }
        }
        return sum;
    }

    public static int secondLargestNumber(int[] input) {
        int largest ;
        int secondLargest;

        if (input[0] > input[1]) {
            largest = input[0];
            secondLargest = input[1];
        } else {
            largest = input[1];
            secondLargest = input[0];
        }

                for(int i = 0; i < input.length; i++) {
                    if (input[i] >= secondLargest) {
                        if (input[i] < largest) {
                            secondLargest = input[i];
                        } else if (input[i] != largest){
                            secondLargest =largest;
                            largest = input[i];
                        }
                    }
        }

                return secondLargest;
    }

    public static String[] swapFirstAndLast(String[] input) {
        String[] newArr = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                newArr[i] = input[input.length -1];
            } else if (i == (input.length - 1)) {
                newArr[i] = input[0];
            } else {
                newArr[i] = input[i];
            }
        }
        return newArr;
    }

    public static int[] reverse(int[] input) {
        int[] newArr = new int[input.length];
        int counter = 0;
        for(int i = input.length; i > 0; i--) {

            newArr[counter] = input[i - 1];
            counter += 1;
        }

        return newArr;
    }

    public static String concatenateString(String[] input) {
        String concatenation = input[0];

        for(int i = 1; i < input.length; i++) {
            concatenation += input[i];
        }
        return concatenation;
    }

    public static int[] everyThird(int[] input) {
        int myLength = input.length;
        int newLength = (myLength- (myLength%3)) / 3;
        int[] newArr = new int[newLength];
        int counter = 0;

        for (int i = 1; i < myLength; i++) {
            if (((i+1)%3) == 0) {
                newArr[counter] = input[i];
                counter += 1;
            }
        }
        if (myLength < 3) {
            return null;
        } else {
            return newArr;
        }
    }

    public static int[] lessThanFive(int[] input) {
        int counter = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < 5) {
                counter += 1;
            }
        }

        int[] newArr = new int[counter];

        int counter2 = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < 5) {
                newArr[counter2] = input[i];
                counter2 += 1;
            }
        }

        System.out.println(newArr);

        if (counter < 1) {
            return null;
        } else {
            return newArr;
        }
    }

    public static int[][] splitAtFive(int[] userInput) {
        int counterLess = 0;
        int counterMore = 0;

        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i] < 5) {
                counterLess += 1;
            } else {
                counterMore += 1;
            }
        }

        int[] lessArr = new int[counterLess];
        int[] moreArr = new int[counterMore];

        int counterLess2 = 0;
        int counterMore2 = 0;

        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i] < 5) {
                lessArr[counterLess2] = userInput[i];
                counterLess2 += 1;
            } else {
                moreArr[counterMore2] = userInput[i];
                counterMore2 += 1;
            }
        }

        int[][] bothArr = {lessArr, moreArr};
        return bothArr;
    }

    public static String[][] evensAndOdds(String[] userInput) {
        int counterEven = 0;
        int counterOdd = 0;

        for (int i = 0; i < userInput.length; i++) {
            if (i%2 == 0) {
                counterEven += 1;
            } else {
                counterOdd += 1;
            }
        }

        String[] evenArr = new String[counterEven];
        String[] oddArr = new String[counterOdd];

        int counterEven2 = 0;
        int counterOdd2 = 0;

        for (int i = 0; i < userInput.length; i++) {
            if (i%2 == 0) {
                evenArr[counterEven2] = userInput[i];
                counterEven2 += 1;
            } else {
                oddArr[counterOdd2] = userInput[i];
                counterOdd2 += 1;
            }
        }

        String[][] bothArr = {evenArr, oddArr};
        return bothArr;
    }


    public static void main(String[] args) {

        int[] exampleArr = {2, 4, 3, 1, 3};
        System.out.println(everyThird(exampleArr));
        System.out.println(lessThanFive(exampleArr));
    }
}