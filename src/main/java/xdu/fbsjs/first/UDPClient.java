package xdu.fbsjs.first;

/**
 * 名称UDPClient
 * 描述UPD客户端
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 21:54
 */
import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String args[]){
// args give message contents and server hostname
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte[] m = args[0].getBytes();
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        } finally {
            if(aSocket != null) aSocket.close();
        }
    }
}
