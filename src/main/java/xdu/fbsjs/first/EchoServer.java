package xdu.fbsjs.first;

/**
 * 名称EchoServer
 * 描述
 *上课的例子
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 14:01
 */
import java.io.*;
import java.net.*;

//服务器端
public class EchoServer {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = null;
        ServerSocket listenSocket = new ServerSocket(8189);

        System.out.println("Server listening at 8189");
        clientSocket = listenSocket.accept();
        System.out.println("Accepted connection from client");

        InputStream inStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        PrintWriter out = new PrintWriter(outStream);

        String line = null;
        while((line=in.readLine())!=null) {
            System.out.println("Message from client:" + line);
            out.println(line);
            out.flush();
        }
        clientSocket.close();
        listenSocket.close();
    }
}