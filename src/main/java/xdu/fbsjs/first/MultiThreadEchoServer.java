package xdu.fbsjs.first;

/**
 * 名称MultiThreadEchoServer
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 15:00
 */
import java.io.*;
import java.net.*;
import xdu.fbsjs.first.ServerThread;

public class MultiThreadEchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket listenSocket=new ServerSocket(8189);
        Socket socket=null;

        int count=0;
        System.out.println("Server listening at 8189");

        while(true){
            socket=listenSocket.accept();
            count++;
            System.out.println("The total number of clients is " + count + ".");
            ServerThread serverThread=new ServerThread(socket);
            serverThread.start();
        }
    }
}
