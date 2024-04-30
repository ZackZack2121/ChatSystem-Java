package com.system.chatsystemjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        Thread serverThread = new Thread(new Server());
        Thread clientThread = new Thread(new Client());

        serverThread.start();
        clientThread.start();
    }
}