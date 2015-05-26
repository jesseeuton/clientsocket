package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jessee on 5/21/2015.
 */
public class EchoClient {
    private final int _port;
    private final String _hostName;

    public EchoClient(String hostName, int port) {
        _port = port;
        _hostName = hostName;
    }

    public void sendMessage() {
        try {
            Socket client = new Socket(_hostName, _port);

            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = stdReader.readLine()) != null) {
                writer.println(userInput);
                System.out.println("echo: " + reader.readLine());
            }
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + _hostName);
        }

    }
}
