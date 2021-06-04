package tech.codingclub.utility;

import tech.codingclub.RunnableExample;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    public static void main(String[] args) {
        System.out.println("This is Subhojit Ghorai");
        System.out.println("ThreadManager running at :"+ new Date().toString());

        TaskManager tsk = new TaskManager(100);

        for(int i=0;i<100000;i++)
        {
            RunnableExample rn = new RunnableExample("Thread-"+i,100,500+i);
            tsk.waitTillqueueIsFreethenadd(rn);
        }

        System.out.println("################################");
    }
}
