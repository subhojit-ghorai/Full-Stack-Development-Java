package tech.codingclub;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Test8 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test8 running at :"+ new Date().toString());

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("This");
        ll.add("is");
        ll.add("how");
        ll.add("you");
        ll.add("code");
        ll.add("LinkedList");

        String first = ll.getFirst();
        String sec = ll.getLast();

        System.out.println("First element : \""+first +"\" last element : \""+sec+"\"");

        Iterator<String> itr = ll.iterator();

        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
    }
}
