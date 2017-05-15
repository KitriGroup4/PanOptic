package com.kitri.admin.server;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.admin.database.dao.ComPrepaidInfoDao;
import com.kitri.admin.database.dao.PointInfoDao;
import com.kitri.admin.database.dao.UserInfoDao;
import com.kitri.admin.database.dto.ComPrepaidInfoDto;
import com.kitri.admin.database.dto.PointInfoDto;
import com.kitri.admin.database.dto.UserInfoDto;

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
	clientHandlerThread.sendPacket(PacketInformation.Operation.COUNT, PacketInformation.PacketType.COM_PREPAID_INFO,
		size);
	for (int i = 0; i < size; i++) {
	    buffer.append(getPacketFormat(PacketInformation.Operation.RESPONSE,
		    PacketInformation.PacketType.COM_PREPAID_INFO, dtos.get(i).toString()));
	}

	clientHandlerThread.sendPacket(buffer.toString());

    }

    public void getPointInfo() {
	System.out.println("getPointInfo()");
	PointInfoDao dao = new PointInfoDao();
	ArrayList<PointInfoDto> dtos = dao.selectAll();

	StringBuilder buffer = new StringBuilder("");
	int size = dtos.size();
	clientHandlerThread.sendPacket(PacketInformation.Operation.COUNT, PacketInformation.PacketType.POINT_INFO,
		size);
	for (int i = 0; i < size; i++) {
	    buffer.append(getPacketFormat(PacketInformation.Operation.RESPONSE, PacketInformation.PacketType.POINT_INFO,
		    dtos.get(i).toString()));
	}

	clientHandlerThread.sendPacket(buffer.toString());
    }

    public void loginUser(String data) {
	String[] datas = data.split(",");

    }

    public void joinUser(String data) {
	UserInfoDto dto = new UserInfoDto();
	dto.setField(data);
	UserInfoDao dao = new UserInfoDao();
	
	dao.insert(dto.getUserName(), dto.getUserId(), dto.getUserPw(), dto.getUserHp(), dto.getUserEmail());
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

	buff.append(clientHandlerThread.clientProgramValue);
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

	buff.append(clientHandlerThread.clientProgramValue);
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
