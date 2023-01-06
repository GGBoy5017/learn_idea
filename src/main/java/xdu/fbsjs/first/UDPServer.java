package xdu.fbsjs.first;

/**
 * 名称UDPServer
 * 描述UDP 服务端
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2023-01-06 21:55
 */
import java.net.*;
import java.io.*;

public class UDPServer{
    public static void main(String args[]){
        DatagramSocket aSocket = null;
        int serverPort = 6789;
        try{
            aSocket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[1000];
            while(true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                DatagramPacket reply = new DatagramPacket(request.getData(),
                        request.getLength(), request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) aSocket.close();
        }
    }
}
