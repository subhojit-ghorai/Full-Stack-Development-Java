package tech.codingclub;

public class LearnClass {
    public static void main(String[] args) {
        Car audi = new Car("Audi 007");
        audi.currspeed = 10;

        Car bmw = new Car("BMW 707",100);
        bmw.acclerate();

        System.out.println("The current speed of audi : "+audi.getCurrspeed());
        System.out.println(audi.wheel);
        System.out.println("The current speed of bmw : "+bmw.getCurrspeed());
        System.out.println(bmw.wheel);

        System.out.println(Car.wheel);

        bmw.incSpeed(200);
        System.out.println("The current speed of bmw : "+bmw.getCurrspeed());
        audi.printabwheel();
        System.out.println(bmw.numplate);
    }
}
