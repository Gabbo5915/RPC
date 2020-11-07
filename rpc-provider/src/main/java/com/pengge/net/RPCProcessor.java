package com.pengge.net;

import com.pengge.dispather.ServiceDispatcher;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPCProcessor implements Runnable{

    private Socket socket;

    public RPCProcessor(Socket socket){
        this.socket = socket;
    }

    @SneakyThrows
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object inputObject = objectInputStream.readObject();
            Object resObject = ServiceDispatcher.dispatch(inputObject);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(resObject);
            objectOutputStream.flush();
        }finally{
            objectInputStream.close();
            objectOutputStream.close();
        }

    }
}
