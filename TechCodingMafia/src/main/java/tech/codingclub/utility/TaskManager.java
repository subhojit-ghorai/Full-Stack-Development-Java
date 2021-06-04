package tech.codingclub.utility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskManager {
    private int threadcount;
    private ExecutorService executorS;

    public TaskManager(int threadcount)
    {
        this.threadcount = threadcount;
        this.executorS = Executors.newFixedThreadPool(threadcount);
    }

    public void addTask(Runnable rn)
    {
        this.executorS.submit(rn);
    }

    public int getQueueSize()
    {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) executorS;
        return exec.getQueue().size();
    }

    public void waitTillqueueIsFreethenadd(Runnable rn)
    {
        if(getQueueSize()>threadcount)
        {
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorS.submit(rn);
    }

}
