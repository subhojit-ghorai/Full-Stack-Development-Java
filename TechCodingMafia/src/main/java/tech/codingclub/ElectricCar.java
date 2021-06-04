package tech.codingclub;

public class ElectricCar extends Car {

    int batteryLeft = 100;

    public ElectricCar(String numplate)
    {
        super(numplate);
    }
    public ElectricCar(String numplate,int curspeed)
    {
        super(numplate,curspeed);
    }

    public int batteryPercentleft()
    {
        return batteryLeft;
    }

    void acclerate()
    {
        super.acclerate();
        batteryLeft -= 5;
    }

    public static void main(String[] args) {

        ElectricCar tesla = new ElectricCar("Tesla 101",500);
        tesla.acclerate();
        tesla.printabwheel();

        System.out.println("The current speed of tesla : "+ tesla.getCurrspeed());
        System.out.println("The battery level of tesla : "+ tesla.batteryPercentleft());
    }
}
