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

    private String id;
    private String password;
    private String passwordCheck;
    private String phoneNumber;
    public int myCount;

    public CurrentInformation currentInformation; // fstatic
    public Succeed succeed;

    public int index;
    public String key = "9999";
    public boolean isAuto = false;
    public boolean isAutoOut = false;
    public int LEARSACount = 0;
    public boolean isLogined;

    public StringBuilder tempRecv;

    public boolean isResetLEA;

    public class CurrentInformation {
	public String userId;
	public int userNumber;
	public String deviceId;
	public String menuNumber;
	public String userPassword;
	public int situation;
	public String dateTime;
	public String logData;
	public boolean isManager;
	public int locationType;
    }

    public static class Succeed {
	public static boolean certification;
	public static boolean login;
	public static boolean join;
    }

    public enum Packet {
	SITUATION(0), DATA_TYPE(1), DATA(2);

	Packet(int num) {
	    dataNum = num;
	}

	int dataNum;

	public int getDataNum() {
	    return dataNum;
	}
    }

    public ClientHandlerThread(Abortable abortable, SocketChannel client, Selector selector, ServerThread serverThread,
	    int handlerCount) {
	this.abortable = abortable;
	this.client = client;
	currentInformation = new CurrentInformation();
	succeed = new Succeed();
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
	    sendTestData("Client :: started!!!");
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

	StringTokenizer lineToken = new StringTokenizer(message, "\n");
	StringBuilder tempPacket = new StringBuilder("");
	String part;
	String[] packet = null;
	int packetSize = 0;
	int partLen = 0;
	String PATTERN = "!";

	while (lineToken.hasMoreTokens()) {
	    part = lineToken.nextToken();
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
		for (int i = 0; i < temp.length; i++) {
		    dataPacket[i] = temp[i];
		}

		System.out.println("conbinePacket() : " + dataPacket[0] + "` " + dataPacket[1] + "` " + dataPacket[2]);
		analysisPacket();

	    }
	}
	// }
	// }

    }

    void divisionPacket(String message) {

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

    public void sendTestData(String str) {
	try {
	    System.out.println("sendTestData");
	    client.write(ByteBuffer.wrap(str.getBytes()));
	    System.out.println("sendTestData");

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void sendData(int situation, int dataType, String data) {

	String temp = "";// = Integer.toString(PacketInformation.Cipher.PLAIN) +
			 // "/" + situation + "/" + dataType + "/" + data;

	try {
	    System.out.println("sendData() : " + temp);
	    temp += "!";
	    client.write(ByteBuffer.wrap(temp.getBytes()));
	} catch (IOException e) {
	    Server.addLog("sendData() error : " + e.toString());
	}

    }

    public void sendDataEnd() {
	try {
	    String temp = "-1!";
	    client.write(ByteBuffer.wrap(temp.getBytes()));
	} catch (IOException e) {
	    Server.addLog("sendDataEnd() error : " + e.toString());
	}
    }

    public void sendDataRSA(int situation, int dataType, String data) {
	String temp = situation + "/" + dataType + "/" + data + "/";

	try {
	    // rsa.RsaEncryption(temp);

	    System.out.println("sendData() : " + temp);
	    // temp = Integer.toString(PacketInformation.Cipher.RSA) + "/" +
	    // rsa.sendTempRsa() + "!";
	    client.write(ByteBuffer.wrap(temp.getBytes()));
	} catch (IOException e) {
	    Server.addLog("sendData() error : " + e.toString());
	}
    }

    public void sendDataRSA(int situation, int dataType, byte[] data) {
	String temp = "";// = Integer.toString(PacketInformation.Cipher.RSA) +
			 // "/" + situation + "/" + dataType + "/" + data + "!";
	try {
	    // Server.addLog("sendDataRSA() : " + temp );
	    System.out.println("sendDataRSA() : " + temp);
	    client.write(ByteBuffer.wrap(temp.getBytes()));
	} catch (IOException e) {
	    Server.addLog("sendData() error : " + e.toString());
	}
    }

    public void sendDataLEARSA(int situation, int dataType, String data) {
	StringBuffer temp = new StringBuffer("");
	temp.append(situation + "/");
	temp.append(dataType + "/");
	temp.append(data + "/");
	// System.out.println("sendDataLEARSA : " + temp.toString());
	// String temp = situation + "/" + dataType + "/" + data + "/";

	// ServerThread.lea.encryption(temp);
	// temp = Integer.toString(PacketInformation.Cipher.LEA_RSA) + "/" +
	// temp;

	try {
	    //// ServerThread.lea.encryption(temp);
	    //
	    // // String temp2 =
	    //// Integer.toString(PacketInformation.Cipher.LEA_RSA)
	    // // + "/" + ServerThread.lea.sendCt1() + "!";
	    // StringBuilder temp2 = new
	    //// StringBuilder(PacketInformation.Cipher.LEA_RSA + "/" +
	    //// ServerThread.lea.sendCt1());
	    // System.out.println("sendDataLEARSA() : " + temp2);
	    // temp2.append("!");
	    //
	    // client.write(ByteBuffer.wrap(temp2.toString().getBytes()));
	    //
	    // // temp2 = Integer.toString(PacketInformation.Cipher.LEA_RSA) +
	    //// "/"
	    // // + ServerThread.lea.sendCt2() + "!";
	    // temp2 = new StringBuilder(PacketInformation.Cipher.LEA_RSA + "/"
	    //// + ServerThread.lea.sendCt2());
	    // System.out.println("sendDataLEARSA() : " + temp2);
	    // temp2.append("!");
	    // client.write(ByteBuffer.wrap(temp2.toString().getBytes()));
	    //
	    // // Server.addLog("sendDataLEARSA() : " + temp2 );
	    //
	    // // client.write(ByteBuffer.wrap(temp.getBytes()));
	} catch (Exception e) {
	    Server.addLog("sendData() error : " + e.toString());
	}
    }

    public void deleteThreadSocket() {
	serverThread.socketList.remove(myCount);
	// serverThread.clientList.remove(index);
    }

    // void isCipher(String message)
    // {
    // String[] each = message.split("!");
    //
    // for(int k = 0; k < each.length; k++)
    // {
    // String[] temp = each[k].split("/");
    //
    // String[] newData = new String[4];
    // dataPacket = new String[PacketInformation.packetSize];
    //
    // for(int i = 0; i < temp.length; i++)
    // {
    // newData[i % (PacketInformation.packetSize + 1)] = temp[i];
    //
    // if(i != 0 && (i % (PacketInformation.packetSize + 1) == 0 || i ==
    // (temp.length - 1)))
    // {
    // System.out.println("isCipher " + newData[0] + ", " + newData[1] + ", " +
    // newData[2] + ", " + newData[3]);
    //
    // switch(Integer.parseInt(newData[0]))
    // {
    // case PacketInformation.Cipher.LEA_RSA:
    //
    // if((LEARSACount % 2) == 0)
    // {
    // ServerThread.lea.setCt1(newData[1]);
    // }
    // else
    // {
    // ServerThread.lea.setCt2(newData[1]);
    // setPacket();
    // }
    //
    // LEARSACount++;
    // break;
    // case PacketInformation.Cipher.RSA:
    //
    // break;
    // case PacketInformation.Cipher.PLAIN:
    // dataPacket[0] = newData[1];
    // dataPacket[1] = newData[2];
    // dataPacket[2] = newData[3];
    // System.out.println("divisionData " + dataPacket[0] + ", " + dataPacket[1]
    // + ", " + dataPacket[2]);
    //
    // analysisData();
    // break;
    // }
    // }
    // }
    // }
    //
    //
    //
    // }

}