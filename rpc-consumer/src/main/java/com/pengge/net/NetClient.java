package com.pengge.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetClient {
    public static Object callRemoteService(String host, int port, Object reqObject){
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Object resObject = null;
        try {
            Socket socket = new Socket(host,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(reqObject);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            resObject = objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                objectInputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resObject;
    }
}
