package com.kitri.pay.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Network implements Runnable {
    private final int SOCKET_TIMEOUT = 3000;
    private final String IP = "localhost";
    private final int PORT = 9831;

    private Socket socket;
    private BufferedReader buffReader;
    private BufferedInputStream reader;
    private PrintWriter writer;
    private boolean isRunnable;

    @Override
    public void run() {
	byte[] byteBuffer = new byte[500];
	isRunnable = true;
	int len = 0;
	String packet;

	try {
	    socket = new Socket();
	    socket.connect(new InetSocketAddress(IP, PORT), SOCKET_TIMEOUT);
	    buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "EUC-KR"));
	    // reader = new BufferedInputStream(socket.getInputStream());
//	    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
	    writer = new PrintWriter(socket.getOutputStream(), true);
	    
	    System.out.println("user start");
	    while (isRunnable) {
		// len = reader.read(byteBuffer);

		sendPacket("kitri kitri kitri");
		System.out.println("????");
		packet = buffReader.readLine();
		System.out.println("!!!!");
		System.out.println(packet);
		
//		sendPacket();
		// byte[] buffer = new byte[len];
		// for(int i = 0; i < len; i++){
		// buffer[i] = byteBuffer[i];
		// }

		packet = null;
	    }
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (buffReader != null) {
		    buffReader.close();
		}
		if (writer != null) {
		    writer.close();
		}
		if (socket != null) {
		    socket.close();
		}
	    } catch (Exception e2) {
		// TODO: handle exception
	    }

	}

    }

    public void sendPacket(String str) {
	if (writer != null) {
	    writer.println(str);
	}
	else{
	    System.out.println("null");
	}
    }

    public static void main(String[] args) {
	Network net = new Network();
	Thread netThread = new Thread(net);
	netThread.start();

    }

}

