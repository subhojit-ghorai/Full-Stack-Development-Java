package tech.codingclub;

import java.util.*;

public class Test12 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test12 running at :" + new Date().toString());

        ArrayList<String> s1 = new ArrayList<>();
        s1.add("Welcome");
        s1.add("to");
        s1.add("Java");
        s1.add("class");

        for(String x : s1)
        {
            System.out.print(x +" ");
        }
        System.out.println("\n###########");
        Collections.sort(s1);
        for(String x : s1)
        {
            System.out.print(x+" ");
        }

        int arr[] = {18,19,1,3,8,4};
        System.out.println("\n###########");
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
        Arrays.sort(arr);
        System.out.println("\n###########");
        for(int x : arr)
        {
            System.out.print(x+" ");
        }
    }
}
