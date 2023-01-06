package xdu.fbsjs.first;

import java.io.*;
import java.net.*;

/**
 * 名称EchoClient
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 13:41
 */

//客户端
public class EchoClient {

    public static void main(String[] args) throws Exception {

        String userInput = null;
        String echoMessage = null;

        //BR是读取一行，ISR封装为字符单位，System.in是IS是以字节为单位
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        //这里是客户端，要连接的是服务器端的ip：127.0.0.1,端口是8189.本地端ip为本机ip，端口随机分配，
        Socket socket = new Socket("127.0.0.1", 8189);
        System.out.println("Connected to Server");

        InputStream inStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        PrintWriter out = new PrintWriter(outStream);


        while((userInput=stdIn.readLine())!=null)
        {
            out.println("userInput="+userInput);
            out.flush();
            echoMessage = in.readLine();
            System.out.println("Echo from server: " + echoMessage);
        }

        socket.close();

    }
}
