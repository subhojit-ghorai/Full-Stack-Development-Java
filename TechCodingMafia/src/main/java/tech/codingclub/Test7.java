package tech.codingclub;

import java.util.ArrayList;
import java.util.Date;

public class Test7 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test7 running at :"+ new Date().toString());

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Welcome");
        arr.add("to");
        arr.add("the");
        arr.add("java");
        arr.add("code.");

        String first = arr.get(0);
        System.out.println(first);

        arr.set(2,"THE");

        int len = arr.size();
        System.out.println("The size of arraylist : "+ len);

        arr.remove(arr.size()-1);

        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ");
        }

        arr.clear();
    }
}
