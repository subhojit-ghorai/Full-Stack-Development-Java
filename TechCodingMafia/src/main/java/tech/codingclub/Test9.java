package tech.codingclub;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test9 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test9 running at :"+ new Date().toString());

        Map<String,String> m1 = new HashMap<String,String>();

        m1.put("India","Delhi");
        m1.put("China","Beijing");
        m1.put("Canada","Ottawa");

        if(m1.containsKey("India"))
        {
            System.out.println("The capital of India : "+ m1.get("India"));
        }
        if(m1.containsKey("Russia"))
        {
            System.out.println("The capital of Russia : "+ m1.get("Russia"));
        }
        else
        {
            System.out.println("Not present in system now");
        }

        for(String key : m1.keySet())
        {
            System.out.print(key + " ");
        }
        System.out.println("");

        for(String val : m1.values())
        {
            System.out.println(val +" ");
        }
        m1.remove("China");
        for(String key : m1.keySet())
        {
            System.out.println(key + " : "+m1.get(key));
        }
    }
}
