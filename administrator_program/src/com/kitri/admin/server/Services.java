package com.kitri.admin.server;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.admin.database.dao.ComPrepaidInfoDao;
import com.kitri.admin.database.dto.ComPrepaidInfoDto;

public class Services {
    ClientHandlerThread clientHandlerThread;

    public Services(ClientHandlerThread clientHandlerThread) {
	this.clientHandlerThread = clientHandlerThread;
    }

    public void getComPrepaidInfo() {
	System.out.println("getComPrepaidInfo()");
	ComPrepaidInfoDao dao = new ComPrepaidInfoDao();
	ArrayList<ComPrepaidInfoDto> dtos = dao.selectAll();

	StringBuilder buffer = new StringBuilder("");
	int size = dtos.size();
	for (int i = 0; i < size; i++) {
	    buffer.append(getPacketFormat(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.COM_PREPAID_INFO, dtos.get(i).toString()));
	}
	
	clientHandlerThread.sendPacket(buffer.toString());

    }

    public void getPointInfo() {

    }

    public String getPacketFormat(int programValue, int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

    public String getPacketFormat(int programValue, int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }
    
    public String getPacketFormat(int operator, int packetType, int data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientHandlerThread.programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }
    
    public String getPacketFormat(int operator, int packetType, String data) {
	StringBuilder buff = new StringBuilder("");

	buff.append(clientHandlerThread.programValue);
	buff.append("/");
	buff.append(operator);
	buff.append("/");
	buff.append(packetType);
	buff.append("/");
	buff.append(data);
	buff.append("!");

	return buff.toString();
    }

}
