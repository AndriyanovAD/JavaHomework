package Lesson3;

import java.util.Random;

public class HW3 {
    public static Random randomValue = new Random();
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[100];
        int[] array3 = new int[12];
        int[][] array4 = new int[10][10];
        int[] array6 = new int[3];

        System.out.println("Задание №1");
        arrayInput(array1);
        printArray("Before:\t ", array1);
        reverseDataArray(array1);
        printArray("After:\t ", array1);
        System.out.println("");

        System.out.println("Задание №2");
        task2method(array2);
        printArray("Content array2:\t ", array2);
        System.out.println("");

        System.out.println("Задание №3");
        for (int i = 0; i < array3.length; i++) {
                array3[i] = randomValue.nextInt(12);
            }
        printArray("Before:\t ", array3);
        task3method(array3);
        printArray("After:\t ", array3);
        System.out.println("");

        System.out.println("Задание №4");
        task4method(array4);
        printArray2("Crossing array:\t ", array4);
        System.out.println("");

        System.out.println("Задание №5");
        arrayCreator(5, 100);
        System.out.println("");

        System.out.println("Задание №6");
        arrayInput2(array6);
        printArray("Content array6:\t ", array6);
        findingMinMaxValue(array6);
        System.out.println("");

        System.out.println("Задание №7");
        arrayInput(array1);
        printArray("Content array1:\t ", array1);
        System.out.println(checkBalance(array1));
        System.out.println("");
        }


    public static void arrayInput(int [] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = randomValue.nextInt(2);
        }
    }
    public static void printArray(String text, int[] input) {
        System.out.print(text + " ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    public static void arrayInput2(int [] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = randomValue.nextInt(25);
        }
    }
    public static void printArray2(String text, int[][] method4) {
        for (int i = 0; i < method4.length; i++) {
            for (int j = 0; j < method4.length; j++) {
                System.out.print(method4[i][j] + "\t");
            }
            System.out.println("");
        }
    }
//№1
    public static void reverseDataArray(int [] reverse) {
        for (int i = 0; i < reverse.length; i++) {
            switch (reverse[i]) {
                case 1: reverse[i] = 0 ;
                break;
                default: reverse[i] = 1;
            }
        }
    }
//№2
    public static void task2method(int [] method2) {
        for (int i = 0; i < method2.length; i++) {
         method2[i] = i + 1;
        }
    }
//№3
    public static void task3method(int [] method3){
        for (int i = 0; i < method3.length; i++) {
            if (method3[i] < 6) {
                method3[i] *= 2;
            }
        }
    }
//№4
    public static void task4method(int [] [] method4){
        for (int i = 0; i < method4.length; i++){
            method4[i][i] = 1;
            method4[i][method4.length - 1 -i] = 1;
        }
    }

//№5
    public static void arrayCreator(int a, int b) {
        int[] newArray= new int[a];
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = b;
        }
        printArray("Content array5:", newArray);
    }
//№6
    public static void findingMinMaxValue(int [] method6){
        int min = method6[0];
        for (int i = 0; i < method6.length; i++){
            if (method6[i] < min) {
                min = method6[i];
            }

        }
        int max = method6[0];
        for (int i = 0; i < method6.length; i++){
            if (method6[i] > max) {
                max = method6[i];

            }

        }
        System.out.println("Minimum= " + min);
        System.out.println("Maximum= " + max);
    }

//№7
    public static boolean checkBalance(int[] method7){
        int right = 0, left = 0;
        for (int i = 0; i < method7.length - 1; i++) {
            left += method7[i];
            for (int j = i + 1; j < method7.length; j++)
                right += method7[j];
                if (left == right) return true;
                right = 0;

        }
        return false;
    }
}


