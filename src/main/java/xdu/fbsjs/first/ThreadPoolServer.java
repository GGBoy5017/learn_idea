package xdu.fbsjs.first;

/**
 * 名称ThreadPoolServer
 * 描述线程池服务器
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 20:07
 */
// 服务端程序
// 客户端程序与多线程版客户端程序一样
import java.io.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 通过实现Runnable接口来创建多线程
class MyThread_ implements Runnable{
    private Socket clientSocket;

    MyThread_(Socket client) {
        clientSocket = client;
    }

    public void run()  {
        try {
            InputStream inStream = clientSocket.getInputStream();
            OutputStream outStream = clientSocket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
            PrintWriter out = new PrintWriter(outStream);

            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println("Message from this client:" + line);
                out.println(line);
                out.flush();
            }
        }catch (Exception e) {
            System.out.println("Exception");
            return;
        }
        finally {
            try {
                clientSocket.close();
            }
            catch (Exception e){
                e.printStackTrace();
                return;
            }
        }
    }
}

public class ThreadPoolServer {
    public static void main(String[] args) throws Exception  {
        Socket clientSocket = null;
        ServerSocket listenSocket = new ServerSocket(8189);
        /*
            创建ThreadPoolExecutor
            参数意义：
                corePoolSize：线程池初始线程数目 6
                maximumPoolSize：线程池最大允许线程数目 12
                keepAliveTime：线程持续时间 100ms
                capacity：等待队列长度 10
                只有在线程数超过初始线程数目并且等待队列满的情况下才会继续创建新线程

         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,12,100, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
        System.out.println("Server listening at 8189");
        int count=0;
        while(true) {
            clientSocket = listenSocket.accept();
            count++;
            System.out.println("Accepted connection from client, count="+count);
            System.out.println("The total active number of clients is " + executor.getActiveCount()+1 + ".");
            MyThread_ t = new MyThread_(clientSocket);
            // 执行线程函数
            executor.execute(t);
        }
    }
}



