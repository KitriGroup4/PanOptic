package com.kitri.admin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.security.Key;
import java.sql.SQLException;
import java.util.*;

public class ClientHandlerThread extends Thread {

    private Abortable abortable;
    private SocketChannel client;
    private Selector selector;
    private CharBuffer recvData;
    public String[] dataPacket;
    private ServerThread serverThread;
    public Services services;

    public int myCount;

    public int index;
    public String key = "9999";
    public boolean isAuto = false;
    public boolean isAutoOut = false;
    public int LEARSACount = 0;
    public boolean isLogined;

    public StringBuilder tempRecv;

    public int programValue;

    public ClientHandlerThread(Abortable abortable, SocketChannel client, Selector selector, ServerThread serverThread,
	    int handlerCount) {
	this.abortable = abortable;
	this.client = client;
	services = new Services(this);
	this.serverThread = serverThread;
	// this.selector = selector;
	myCount = handlerCount;
	isLogined = false;
	tempRecv = new StringBuilder("");
    }

    @Override
    public void run() {
	super.run();

	Selector selector = null;
	Charset cs = Charset.forName("EUC-KR");
	int socketOptions = SelectionKey.OP_WRITE | SelectionKey.OP_READ | SelectionKey.OP_CONNECT;

	boolean done = false;

	try {

	    System.out.println("Client :: started");
	    // Server.addLog("Client :: started");

	    client.configureBlocking(false);
	    selector = Selector.open();

	    client.register(selector, socketOptions);

	    // send welcome message
	    // client.write(ByteBuffer.wrap(new String("Welcome").getBytes()));

	    ByteBuffer buffer = ByteBuffer.allocate(4096);

	    while (!Thread.interrupted() && !abortable.isDone() && !done) {
		selector.select(3000);

		Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

		while (!abortable.isDone() && iter.hasNext() && !done) {
		    SelectionKey selected = (SelectionKey) iter.next();

		    if (selected.isConnectable()) {

			if (client.isConnectionPending()) {

			    client.finishConnect();
			}
		    } else if (selected.isReadable()) {
			// buffer = null;

			int len = client.read(buffer);

			if (len < 0) {
			    done = true;
			    break;
			}

			if (buffer.position() != 0) {
			    buffer.flip();
			    recvData = cs.decode(buffer);
			    System.out.print(recvData.toString());
			    conbinePacket(recvData.toString());
			}

			if (selected.isWritable()) {
			    buffer.clear();
			}
		    }
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    }

	} catch (Exception e) {
	    // deleteThreadSocket();
	    System.out.println("client error : " + e.toString());
	    e.printStackTrace();
	} finally {

	    if (client != null) {
		try {
		    // client.finishConnect();
		    System.out.println("Client :: Close Socket");
		    client.socket().close();
		    client.close();
		} catch (IOException e) {
		    System.out.println("client finally error : " + e.toString());
		    e.printStackTrace();
		}
	    }

	    deleteThreadSocket();
	    System.out.println("Client :: bye");
	    Server.addLog("client :: bye");
	}
    }

    void conbinePacket(String message) {
	System.out.print(message);
	StringTokenizer lineToken = new StringTokenizer(message, "\n");
	StringBuilder tempPacket = new StringBuilder("");
	String part;
	String[] packet = null;
	int packetSize = 0;
	int partLen = 0;
	String PATTERN = "!";

	while (lineToken.hasMoreTokens()) {
	    part = lineToken.nextToken().trim();
	    
	    System.out.print(part);
	    partLen = part.length() - 1;
	    if (part.indexOf(PATTERN) == -1) {
		tempPacket.append(part);
		continue;
	    } else {
		packet = part.split(PATTERN);
		packetSize = packet.length;
		if (tempPacket.length() != 0) {
		    packet[0] = tempPacket.toString() + packet[0];
		    tempPacket = new StringBuilder("");
		}
		if (part.indexOf(PATTERN) != partLen) {
		    tempPacket.append(packet[packetSize - 1]);
		    packetSize--;
		}
	    }

	    for (int k = 0; k < packetSize; k++) {
		String[] temp = packet[k].split("/");

		String[] newData = new String[PacketInformation.PACKET_SIZE];
		dataPacket = new String[PacketInformation.PACKET_SIZE];
		for (int i = 0; i < PacketInformation.PACKET_SIZE; i++) {
		    dataPacket[i] = temp[i];
		}

		System.out.println("conbinePacket() : " + dataPacket[0] + "` " + dataPacket[1] + "` " + dataPacket[2]
			+ "` " + dataPacket[3]);
		dicisionProgram();

	    }
	}

    }

    void divisionPacket(String message) {

    }

    private void dicisionProgram() {
	System.out.println("dicisionProgram()");
	int programValue;
	int operator;

	programValue = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PROGRAM_VALUE]);
	operator = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.OPERATOR]);
	
	switch (programValue) {
	case PacketInformation.ProgramValue.USER:
	    programValue = PacketInformation.ProgramValue.USER;
	    break;
	case PacketInformation.ProgramValue.PAYMENT:
	    programValue = PacketInformation.ProgramValue.PAYMENT;
	    break;
	case PacketInformation.ProgramValue.ADMIN:
	    programValue = PacketInformation.ProgramValue.ADMIN;
	    break;
	default:
	    return;
	}
	
	dicisionOperator(operator);

    }

    private void dicisionOperator(int operator) {
	System.out.println("dicisionOperator()");
	int packetType = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PACKET_TYPE]);

	switch (operator) {
	case PacketInformation.Operation.GET:
	    getRequest(packetType);
	    break;
	default:
	}
    }

    private void getRequest(int packetType) {
	System.out.println("getRequest()");
	String data = dataPacket[PacketInformation.PacketStructrue.DATA];
	System.out.println(packetType);
	switch (packetType) {
	case PacketInformation.PacketType.COM_PREPAID_INFO:
	    services.getComPrepaidInfo();
	    break;
	case PacketInformation.PacketType.POINT_INFO:

	    break;
	default:
	}
    }

    private void paymentComPrepaidInfo(String data) {

    }

    void analysisPacket() {
	// divisionData(message);
	// int situation =
	// compareSituation(dataPacket[Packet.SITUATION.getDataNum()]);
	int programValue;
	int packetType;

	try {
	    programValue = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PROGRAM_VALUE]);
	    packetType = Integer.parseInt(dataPacket[PacketInformation.PacketStructrue.PACKET_TYPE]);

	} catch (Exception e) {
	    System.out.println("ananlysis error : " + e.toString());
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

	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
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
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
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
	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
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

	try {
	    client.write(ByteBuffer.wrap(buff.toString().getBytes()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPacket(String packet) {
	try {
	    System.out.println(packet);
	    packet += "\n";
	    client.write(ByteBuffer.wrap(packet.getBytes()));
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

   

    public void deleteThreadSocket() {
	serverThread.socketList.remove(myCount);
	// serverThread.clientList.remove(index);
    }

}