package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class RunnableExample implements Runnable{
    public int cnt;
    private String t_name;
    private int slpt;

    public RunnableExample(String t_name,int cnt,int slpt)
    {
        this.t_name = t_name;
        this.cnt = cnt;
        this.slpt = slpt;
    }

    @Override
    public void run() {
        while(cnt<10000)
        {
            System.out.println(t_name + " " + cnt);
            cnt++;
            try{
                Thread.sleep(slpt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("RunnableExample running at :"+ new Date().toString());

        RunnableExample r1 = new RunnableExample("ThreadA",10,500);
        RunnableExample r2 = new RunnableExample("threadB",500,1000);
        RunnableExample r3 = new RunnableExample("threadC",300,0);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Reached out");


        System.out.println(r1.cnt);
        System.out.println(r2.cnt);
        System.out.println(r3.cnt);
    }
}
