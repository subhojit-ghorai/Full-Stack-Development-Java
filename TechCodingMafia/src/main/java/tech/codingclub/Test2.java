package tech.codingclub;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai \n");

        //Add two number
        int a = 400;
        int b = 8;

        int c = a + b;

        System.out.println("Sum of "+a+" + "+b+" = "+c);

        //widening variable
        double wdv = a;
        System.out.println("Widened variable : "+wdv);
        wdv += 0.1;
        System.out.println("Modified Widened variable : "+wdv);

        //Narrowing Variable
        int nrv = (int) wdv;
        System.out.println("narrowed variable : "+nrv);

        //Overflowing a variable
        int x = Integer.MAX_VALUE;
        System.out.println("The max value of Int : "+x);
        x += 4;
        System.out.println("Modified max value of Integer : "+x);
    }
}
