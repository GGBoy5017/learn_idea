package xdu.fbsjs.first;

/**
 * 名称ThreadPoolTest
 * 描述
 *线程池
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 17:26
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //线程池的构造函数，线程池的线程数量，多余的放到workQueue中去。队列最大线程数量。队列线程存活时间。单位毫秒。队列类型。
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            //创建的任务
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("The number of threads in the ThreadPool:"+executor.getPoolSize());
            System.out.println("The number of tasks in the Queue:" + executor.getQueue().size());
            System.out.println("The number of tasks completed:"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        int sum = 0;

        System.out.println("Task"+taskNum+" is running!");

        try {
            for(int i=0; i<15; i++) {
                sum += i;
            }
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task "+taskNum+" has been done!");
    }
}
