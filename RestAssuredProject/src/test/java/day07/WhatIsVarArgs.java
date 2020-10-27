package day07;

import org.junit.jupiter.api.Test;

public class WhatIsVarArgs {

    //variable number of argument
    //Creat a method that accept N numbers add all of them
    //and print the result
    public static void addAllNumbers(int[] nums) {

        int sum = 0;
        for (int eachnum : nums) {
            sum += eachnum;
        }
        System.out.println("sum = " + sum);

    }

    @Test
    public void testAdd() {

        addAllNumbers(new int[]{1, 2, 3, 4, 5, 6});

        addAllNumbersVarArgs(1,2,3,4,5);
        addAllNumbersVarArgs(1, 2, 3, 4, 5, 6,-10,22,34,23,46,68);
        addAllNumbersVarArgs(1,2);

    }

    // this method parameter int... nums means
    // when you call the method , it can accept any number of arguments
    // THIS IS THE ONLY PLACE YOU CAN USE ...
    // ANYWHERE ELSE OTHER THAN METHOD PARAM IT WILL NOT WORK !!!!
    public static void addAllNumbersVarArgs(int... nums) {

        int sum = 0;
        for (int eachnum : nums) {
            sum += eachnum;
        }
        System.out.println("sum = " + sum);

    }


}
