package tech.codingclub;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test11 running at :" + new Date().toString());

        Set<String> s1 = new HashSet<>();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("to");
        arr.add("to");
        arr.add("Java");
        arr.add("class");

        s1.add("Welcome");
        s1.addAll(arr);

        Iterator<String> itr = s1.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        int m = s1.size();

        System.out.println("The size of set : "+m);

        s1.remove("Java");

        itr = s1.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
