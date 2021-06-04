package tech.codingclub;

import java.util.Date;

public class Test5 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("Test5 running at :"+ new Date().toString());

        int a = 10;
        int b = 20;

        System.out.println("Addition : "+(a+b));
        System.out.println("Subtraction : "+(a-b));
        System.out.println("multiplication : "+(a*b));
        System.out.println("Division : "+(a/b));
        System.out.println("Modulo : "+(a%b));

        double c = -20.21;
        double d = Math.abs(c);
        System.out.println("Math.abs : "+Math.abs(c));
        System.out.println("Math.ceil : "+Math.ceil(d));
        System.out.println("Math.floor : "+Math.floor(d));
        System.out.println("Math.min : "+Math.min(2,3));
        System.out.println("Math.max : "+Math.max(2,3));
        System.out.println("Math.random between 0 and 1 : "+Math.random());

        int random = 10 + (int)(Math.random()*90);

        System.out.println("Math.random between 10 and 100 : "+random);

        int e = 100;

        System.out.println("Post increment : "+ (e++));
        System.out.println("Pre increment : "+ (++e));

        int i=1;
        int fact = 1;

        do{
            fact = fact*i;
            i++;
        }while(i<=5);

        System.out.println("value of 5! is : "+ fact);

    }
}
