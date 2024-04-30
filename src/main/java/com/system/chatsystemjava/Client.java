package com.system.chatsystemjava;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Client implements Runnable{

    private DatagramSocket clientSocket;
    private InetAddress IPAddress;

    private BufferedReader inFromUser;

    private byte[] sendData;

    private String msg;

    private DatagramPacket sendPacket;

    @Override
    public void run() {
        try {
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName("localhost");
            inFromUser = new BufferedReader(new InputStreamReader(System.in));

            sendData = new byte[1024];
            while (true) {
                System.out.println("Input: ");
                msg = inFromUser.readLine();
                sendData = msg.getBytes();

                sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5252);
                clientSocket.send(sendPacket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }
}
