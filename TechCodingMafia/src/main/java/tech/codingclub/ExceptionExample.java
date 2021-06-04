package tech.codingclub;

import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        int x = 100;
        Scanner scan = new Scanner(System.in);

        try{
            int y = scan.nextInt();
            int ans = x/y;
            System.out.println("The ans : "+ ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }
}
