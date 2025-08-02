package com.example.aiga_hackathon.client;

import java.net.Socket;
import java.util.HashMap;

public class SocketClient {
    private static Socket socket = null;

    public static Socket getSocket(String token) {
        if (socket == null) {
            try {
                IO.Options options = new IO.Options();
                options.auth = new HashMap<>();
                options.auth.put("token", token);
                socket = IO.socket("https://your-backend.railway.app"); // Замени на URL
                socket.connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return socket;
    }
}
