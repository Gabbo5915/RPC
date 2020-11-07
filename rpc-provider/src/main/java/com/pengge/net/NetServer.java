package com.pengge.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetServer {

    static final ExecutorService threadPool = Executors.newFixedThreadPool(100);

    public static void startUp(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            Socket socket = serverSocket.accept();
            threadPool.submit(new RPCProcessor(socket));
        }
        //Multi thread

    }
    public static void main(String[] args) throws IOException {
        startUp(9999);
    }
}
