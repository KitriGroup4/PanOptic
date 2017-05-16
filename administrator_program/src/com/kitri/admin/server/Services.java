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

    public void checkId(String id) {
	System.out.println("checkId()");
	UserInfoDao dao = new UserInfoDao();
	if (dao.checkId(id).isEmpty()) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID,
		    1);
	} else {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID,
		    0);
	}
    }

    public void loginUser(String data) {
	String[] datas = data.split(",");
	String id = datas[0];
	String pw = datas[1];
	String pwCheck;
	UserInfoDao dao = new UserInfoDao();

	if ((pwCheck = dao.checkId(id)).isEmpty()) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_FAIL,
		    PacketInformation.IDLE);
	} else {
	    if (pwCheck.equals(pw)) {
		clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_OK,
			PacketInformation.IDLE);
	    } else {
		clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_FAIL,
			PacketInformation.IDLE);
	    }
	}

    }

    public void joinUser(String data) {
	System.out.println("joinUser()");
	UserInfoDto dto = new UserInfoDto();
	dto.setFieldToInsert(data);
	UserInfoDao dao = new UserInfoDao();

	if (dao.insert(dto)) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.IS_OK,
		    PacketInformation.IDLE);
	} else {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.IS_FAIL,
		    PacketInformation.IDLE);
	}
    }

    public void buyPoint(String data) {
	System.out.println("buyPoint()");
	
	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK, PacketInformation.IDLE);
	
    }
    
    public void buyTime(String data) {
	System.out.println("buyTime()");
	

	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK, PacketInformation.IDLE);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
