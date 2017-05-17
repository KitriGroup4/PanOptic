package com.kitri.admin.server;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.admin.database.dao.ComPrepaidInfoDao;
import com.kitri.admin.database.dao.PointInfoDao;
import com.kitri.admin.database.dao.UserInfoDao;
import com.kitri.admin.database.dao.UserPointInfoDao;
import com.kitri.admin.database.dto.ComPrepaidInfoDto;
import com.kitri.admin.database.dto.PointInfoDto;
import com.kitri.admin.database.dto.UserInfoDto;
import com.kitri.admin.database.dto.UserPointInfoDto;

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
	String temp = dao.checkId(id);
	String[] temps;

	if (temp.isEmpty()) {
	    clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_FAIL,
		    PacketInformation.IDLE);
	    return;
	} else {
	    temps = temp.split(",");
	    String num = temps[0];
	    pwCheck = temps[1];
	    if (pwCheck.equals(pw)) {
		clientHandlerThread.sendPacket(PacketInformation.Operation.LOGIN, PacketInformation.PacketType.IS_OK,
			num);
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
	String[] datas = data.split(","); // index,userNum
	int userNum = Integer.parseInt(datas[1]);
	PointInfoDao dao = new PointInfoDao();
	PointInfoDto dto = dao.select(Integer.parseInt(datas[0]));

	UserPointInfoDao uDao = new UserPointInfoDao();
	UserPointInfoDto uDto = uDao.select(userNum);

	if (uDto == null) {
	    uDto = new UserPointInfoDto();
	    uDto.setPoint(dto.getValue());
	    uDto.setUserNum(userNum);
	    uDao.insert(uDto);
	} else {
	    uDto.setPoint(uDto.getPoint() + dto.getValue());
	    uDao.update(uDto);
	}

	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK,
		PacketInformation.IDLE);

    }

    public void buyTime(String data) {
	System.out.println("buyTime()");

	clientHandlerThread.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.IS_OK,
		PacketInformation.IDLE);
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
