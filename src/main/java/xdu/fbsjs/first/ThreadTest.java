package xdu.fbsjs.first;

/**
 * 名称ThreadTest
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 14:46
 */
class MyThread extends Thread{
    private int ticket;

    MyThread(int t) {
        ticket = t;
    }

    //线程的主函数
    public void run(){
        for(int i=0;i<ticket;i++){
            if(ticket>0){
                System.out.println(this.getName()+" sold ticket"+ ticket--);
            }
        }
    }
};

public class ThreadTest {
    public static void main(String[] args) {
        //三个售票员并行售票，不同售票员开始拿到的票数不一样
        MyThread t1=new MyThread(10);
        MyThread t2=new MyThread(15);
        MyThread t3=new MyThread(30);
        t1.start();
        t2.start();
        t3.start();
    }
}