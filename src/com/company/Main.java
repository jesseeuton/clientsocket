package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EchoClient client = new EchoClient("localhost", 8965);
        client.sendMessage();
    }
    }
