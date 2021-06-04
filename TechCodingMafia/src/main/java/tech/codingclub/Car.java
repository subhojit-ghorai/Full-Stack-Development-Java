package tech.codingclub;

public class Car {
    public static int wheel = 4;
    public static final int maxspeed = 300;
    int currspeed = 0;
    String numplate;

    public Car(String numplate)
    {
        this.numplate = numplate;
    }

    public Car(String numplate,int currspeed)
    {
        this.numplate = numplate;
        this.currspeed = currspeed;
    }

    void acclerate()
    {
        System.out.println("Speed Up : "+numplate);
        currspeed += 10;
    }

    void printabwheel()
    {
        System.out.println("The number of wheel : " + wheel);
    }

    public int getCurrspeed() {
        return currspeed;
    }

    public void incSpeed(int i) {
        currspeed +=i;
        if(currspeed>maxspeed)
        {
            currspeed = maxspeed;
        }
    }
}
