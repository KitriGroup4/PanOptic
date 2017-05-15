package com.kitri.pay.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.kitri.pay.main.MainView;

public class Network implements Runnable {
    private final int SOCKET_TIMEOUT = 3000;
    private final String IP = "localhost";
    private final int PORT = 9831;

    private Socket socket;
    private BufferedReader buffReader;
    private BufferedInputStream reader;
    private PrintWriter writer;
    private boolean isRunnable;

    private String[] dataPacket;

    public Services services;
    public MainView view;

    public Network() {
	view = new MainView();

	Thread thread = new Thread(this);
	thread.start();
    }

    @Override
    public void run() {
	byte[] byteBuffer = new byte[500];
	isRunnable = true;
	int len = 0;
	String packets;

	try {
	    socket = new Socket();
	    socket.connect(new InetSocketAddress(IP, PORT), SOCKET_TIMEOUT);
	    buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "EUC-KR"));
	    writer = new PrintWriter(socket.getOutputStream(), true);

	    services = new Services(this);
	    while (isRunnable) {
		// len = reader.read(byteBuffer);

		packets = buffReader.readLine();

		divisionPacket(packets);

		packets = null;
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
		e2.printStackTrace();
	    }

	}

    }

    private void divisionPacket(String packets) {
	String PATTERN = "!";
	String UNIT = "/";

	StringTokenizer patternToken = new StringTokenizer(packets.trim(), PATTERN);
	StringTokenizer unitToken;
	String part;
	int i = 0;

	while (patternToken.hasMoreTokens()) {
	    unitToken = new StringTokenizer(patternToken.nextToken(), UNIT);
	    dataPacket = new String[PacketInformation.PACKET_SIZE];
	    i = 0;
	    while (unitToken.hasMoreTokens()) {
		dataPacket[i++] = unitToken.nextToken();
	    }
	    System.out.println(Arrays.toString(dataPacket));
	    dicisionProgram();
	}
    }

    private void dicisionProgram() {
	if (PacketInformation.ProgramValue.PAYMENT == Integer
		.parseInt(dataPacket[PacketInformation.PacketStructrue.PROGRAM_VALUE])) {
	    dicisionOperator(Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.OPERATOR]));
	}
    }

    private void dicisionOperator(int operator) {
	int packetType = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PACKET_TYPE]);

	switch (operator) {
	case PacketInformation.Operation.RESPONSE:
	    responsePacket(packetType);
	    break;
	case PacketInformation.Operation.GET:

	    break;
	case PacketInformation.Operation.COUNT:
	    countPacket(packetType);
	    break;
	case PacketInformation.Operation.JOIN:

	    break;
	default:

	}
    }

    private void joinResaponse(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	
	switch(packetType){
	case PacketInformation.PacketType.CHECK_USER_ID:
	    
	    break;
	    default:
	}
    }

    private void countPacket(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	int intData = Integer.parseInt(data);

	switch (packetType) {
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    break;
	case PacketInformation.PacketType.POINT_INFO:
	    break;

	}
    }

    private void responsePacket(int packetType) {
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];

	switch (packetType) {
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    break;
	case PacketInformation.PacketType.POINT_INFO:
	    break;
	}
    }

    public void sendPacket(int programValue, int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	writer.println(buff.toString());
    }

    public void sendPacket(int programValue, int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	writer.println(buff.toString());
    }

    public void sendPacket(int operator, int packetType, byte data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(PacketInformation.ProgramValue.PAYMENT);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	System.out.println(buff.toString());
	writer.println(buff.toString());
    }

    public void sendPacket(int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(PacketInformation.ProgramValue.PAYMENT);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	writer.println(buff.toString());
    }

    public void sendPacket(String str) {
	if (writer != null) {
	    writer.println(str);
	} else {
	    System.out.println("null");
	}
    }

    public static void main(String[] args) {
	Network net = new Network();
	Thread netThread = new Thread(net);
	netThread.start();

    }

}
