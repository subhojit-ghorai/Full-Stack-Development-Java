package tech.codingclub;

import java.util.Date;
import java.util.Random;

public class Test6 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test6 running at :"+ new Date().toString());

        Random random = new Random();

        int rand = random.nextInt(100);
        System.out.println("Random between 0 to 99 : "+rand);
        rand = 50 + random.nextInt(50);
        System.out.println("Random between 50 to 99 : "+rand);


        String str = "HelloWorld";
        System.out.println("String : "+str);
        str = str + '!';
        System.out.println("Modified String : "+str);
        System.out.println("String length : "+str.length());
        System.out.println("String substring : "+str.substring(2));
        System.out.println("String substring 5,7 : "+str.substring(5,7));

        System.out.println("String UC : "+str.toUpperCase());
        System.out.println("String LC : "+str.toLowerCase());

        int a = str.indexOf('W');
        System.out.println("Index of W : "+a);

        char b = str.charAt(a);
        System.out.println("Character at "+a+" : "+b);

        String s1 = "abc";
        String s2 = "def";

        System.out.println(s1.compareTo(s2));

        Date prevd = new Date();
        long c = prevd.getTime();

        for(int i=0; i<10000000;i++)
        {

        }
        Date nextd = new Date();
        long d = nextd.getTime();

        long diff = d-c;

        System.out.println("time taken for 10^7 in milliseconds on my machine : "+diff);


    }
}
