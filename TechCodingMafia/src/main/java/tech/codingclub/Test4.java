package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test3 running at :"+ new Date().toString());

        int arr [] = {10,20,30,40};

        System.out.println("Last element : "+ arr[arr.length-1]);

        int brr [][] = {{1,2,3,4},{5,6,7,8}};

        System.out.println("The last element of the 2d array : "+brr[1][3]);

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter vale of a:");
        int a = scan.nextInt();
        System.out.println("Enter vale of b:");
        int b = scan.nextInt();

        System.out.println("The sum of two scanned variable : "+(a+b));
    }
}
