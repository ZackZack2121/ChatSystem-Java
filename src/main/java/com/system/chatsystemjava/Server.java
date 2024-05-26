package com.system.chatsystemjava;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server implements Runnable{
    private DatagramSocket serverSocket;
    private byte[] receiveData;

    private DatagramPacket receivePacket;
    private String msg;

    //listens for data
    @Override
    public void run() {
        try {
            serverSocket = new DatagramSocket(5252);
            receiveData = new byte[1024];

            while (true) {
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                msg = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println(msg);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String args[]) {
        Thread serverThread = new Thread(new Server());

        serverThread.start();
    }
}
