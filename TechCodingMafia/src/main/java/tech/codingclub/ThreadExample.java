package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class ThreadExample extends Thread{
    private String t_name;
    public int cnt;

    public ThreadExample(String t_name,int cnt)
    {
        this.t_name = t_name;
        this.cnt = cnt;
    }

    public void run()
    {
        while(cnt<10000)
        {
            //System.out.println(t_name + " " + cnt);
            cnt++;
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("ThreadExample running at :"+ new Date().toString());

        ThreadExample t1 = new ThreadExample("ThreadA",10);
        ThreadExample t2 = new ThreadExample("threadB",500);
        ThreadExample t3 = new ThreadExample("threadC",300);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Reached out");

        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        System.out.println(y);

        System.out.println(t1.cnt);
        System.out.println(t2.cnt);
        System.out.println(t3.cnt);
    }
}
