package tech.codingclub;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test10 running at :" + new Date().toString());

        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(2);
        s1.push(5);
        s1.push(10);
        s1.push(101);

        s1.pop();

        System.out.println("the element at top is : "+ s1.peek());

        int index = s1.search(5);
        int index_200 = s1.search(200);

        System.out.println("the index of element 5 : " + index);
        System.out.println("the index of element 200 : " + index_200);

        Iterator<Integer> itr = s1.iterator();

        while(itr.hasNext())
        {
            System.out.println("element : " + itr.next());
        }

        while(!s1.empty())
        {
            int a = s1.pop();
            System.out.println("The element popped is : "+ a);
        }

    }
}
