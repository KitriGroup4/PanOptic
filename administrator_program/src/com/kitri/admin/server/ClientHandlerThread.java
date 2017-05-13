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
			    isCipher(recvData.toString());
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

    void isCipher(String message) {
	System.out.println(message);
	sendTestData(message);
	// System.out.println("------=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=------");
	// String[] tempTemp = message.split("\n");
	// for (int h = 0; h < tempTemp.length; h++) {
	// message = tempTemp[h];
	//
	// int messageLength = message.length() - 1;
	//
	// String[] each;
	// int eachSize;
	// // each = message.split("!");
	// // eachSize = each.length;
	//
	// if (message.indexOf("!") == -1) {
	// System.out.println("message.indexOf(!) == -1");
	// tempRecv.append(message);
	// continue;
	// } else {
	// each = message.split("!");
	// eachSize = each.length;
	//
	// if (tempRecv.length() != 0) {
	// System.out.println("tempRecv != 0 ~~~~~~");
	// each[0] = tempRecv.toString() + each[0];
	//
	// tempRecv = new StringBuilder("");
	//
	// }
	// if (message.indexOf("!") != messageLength) {
	// System.out.println("message.indexOf(!) != messageLength");
	// tempRecv.append(each[eachSize - 1]);
	//
	// eachSize--;
	//
	// }
	// }
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

		String[] newData = new String[4];
		dataPacket = new String[PacketInformation.packetSize];
		for (int i = 0; i < temp.length; i++) {
		    newData[i] = temp[i];
		}

		System.out.println(
			"isCipher : " + newData[0] + "` " + newData[1] + "` " + newData[2] + "` " + newData[3]);

		try {
		    // int cipher = Integer.parseInt(newData[0]);
		    // System.out.println("cipher : " + cipher);
		    // switch (cipher) {
		    // case PacketInformation.Cipher.LEA_RSA:
		    //
		    // if ((LEARSACount % 2) == 0) {
		    // isResetLEA = false;
		    // ServerThread.lea.setCt1(newData[1]);
		    // } else {
		    // isResetLEA = true;
		    // ServerThread.lea.setCt2(newData[1]);
		    // setLEARSAPacket();
		    // }
		    //
		    // LEARSACount++;
		    // break;
		    // case PacketInformation.Cipher.RSA:
		    // ServerThread.serverRSA.setTempRsa(newData[1]);
		    // setRSAPacket();
		    // break;
		    // case PacketInformation.Cipher.PLAIN:
		    // dataPacket[0] = newData[1];
		    // dataPacket[1] = newData[2];
		    // dataPacket[2] = newData[3];
		    // System.out
		    // .println("divisionData " + dataPacket[0] + ", " +
		    // dataPacket[1] + ", " + dataPacket[2]);
		    //
		    // analysisData();
		    // break;
		    // }
		} catch (Exception e) {
		    System.out.println("isCipher error : " + e.getMessage());
		    System.out.println("isCipher error : " + e.toString());
		    // tempRecv = new StringBuilder("");
		    // each = null;
		    // temp = null;
		    // break;
		}

	    }
	}
	// }
	// }

    }

    void divisionData(String message) {
	// dataPacket = message.split("/");
	// System.out.println("divisionData() : " +
	// dataPacket[Packet.SITUATION.getDataNum()] + ", " +
	// dataPacket[Packet.DATA_TYPE.getDataNum()] + ", " +
	// dataPacket[Packet.DATA.getDataNum()]);
	// Server.addLog("divisionData() : " +
	// dataPacket[Packet.SITUATION.getDataNum()] + ", " +
	// dataPacket[Packet.DATA_TYPE.getDataNum()] + ", " +
	// dataPacket[Packet.DATA.getDataNum()]);
	// message = message.replace(System.getProperty("line.separator"), "");
	String[] temp = message.split("/");
	System.out.println("temp : " + message + "len : " + temp.length);
	//
	// if(temp.length > 6)
	// {
	// System.out.print(temp[3].replace(System.getProperty("line.separator"),
	// ""));
	// System.out.print(temp[6]);
	// }
	//
	dataPacket = new String[PacketInformation.packetSize];

	for (int i = 0; i < temp.length; i++) {
	    dataPacket[i % PacketInformation.packetSize] = temp[i];// .replace(System.getProperty("line.separator"),
								   // "");
	    // System.out.println("dataPacket : " + dataPacket[i %
	    // PacketInformation.packetSize]);
	    if (i != 0 && ((i + 1) % PacketInformation.packetSize == 0 || i == (temp.length - 1))) {
		System.out.println("divisionData() : " + dataPacket[PacketInformation.PacketStructure.SITUATION] + ", "
			+ dataPacket[PacketInformation.PacketStructure.DATA_TYPE] + ", "
			+ dataPacket[PacketInformation.PacketStructure.DATA]);
		Server.addLog("divisionData() : " + dataPacket[PacketInformation.PacketStructure.SITUATION] + ", "
			+ dataPacket[PacketInformation.PacketStructure.DATA_TYPE] + ", "
			+ dataPacket[PacketInformation.PacketStructure.DATA]);

		// analysisData();
	    }
	}
	// dataPacket = message.split("/");

    }

    // void analysisData() {
    // // divisionData(message);
    // // int situation =
    // // compareSituation(dataPacket[Packet.SITUATION.getDataNum()]);
    // int situation;
    // int dataType;
    // try {
    // situation = Integer.parseInt(dataPacket[Packet.SITUATION.getDataNum()]);
    // dataType = Integer.parseInt(dataPacket[Packet.DATA_TYPE.getDataNum()]);
    //
    // switch (situation) {
    // case PacketInformation.Situation.LOGIN:
    // loginData(dataType);
    // break;
    // case PacketInformation.Situation.JOIN:
    // joinData(dataType);
    // break;
    // case PacketInformation.Situation.CERTIFICATION:
    // certificationData(dataType);
    // break;
    // case PacketInformation.Situation.LISTDEVICE:
    // listDeviceData(dataType);
    // break;
    // case PacketInformation.Situation.DEVICEMENU:
    // deviceMenuData(dataType);
    // break;
    // case PacketInformation.Situation.SECOND:
    // secondData(dataType);
    // break;
    // case PacketInformation.Situation.IDLE:
    // idleData(dataType);
    // break;
    // case PacketInformation.Situation.STATISTICS:
    // services.listDeviceMessageData(dataPacket[PacketInformation.PacketStructure.DATA]);
    // break;
    // case PacketInformation.Share.AUTO:
    // isAuto = true;
    // services.deviceValueAnalysis(dataPacket[PacketInformation.PacketStructure.DATA]);
    //
    // break;
    // case PacketInformation.Share.AUTO_OUT:
    // isAutoOut = true;
    // services.deviceValueAnalysis(dataPacket[PacketInformation.PacketStructure.DATA]);
    // case PacketInformation.Situation.RSA:
    // RSAData(dataType);
    //
    // break;
    // case PacketInformation.Situation.HOME:
    // homeData(dataType);
    // break;
    // case PacketInformation.Situation.MANAGER:
    // managerData(dataType);
    // break;
    // case PacketInformation.Situation.SETTING:
    // settingData(dataType);
    // break;
    // case PacketInformation.Situation.CONTROL_PLAIN:
    // controlPlainData(dataType);
    // break;
    // }
    // } catch (Exception e) {
    // System.out.println("ananlysis error : " + e.toString());
    // }
    //
    // }
    
    public void sendTestData(String str){
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