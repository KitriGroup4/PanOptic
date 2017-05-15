package com.kitri.pay.network;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kitri.pay.dto.ComPrepaidInfoDto;
import com.kitri.pay.dto.PointInfoDto;
import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation.ComPrepaidInfo;

public class Services {
    private Network network;

    public Services(Network network) {
	this.network = network;
	// getComPrepaidInfo();
	// getPointInfo();

    }

    public void getComPrepaidInfo() {
	network.sendPacket(PacketInformation.Operation.GET, PacketInformation.PacketType.COM_PREPAID_INFO,
		PacketInformation.IDLE);
    }

    public void getPointInfo() {
	network.sendPacket(PacketInformation.Operation.GET, PacketInformation.PacketType.POINT_INFO,
		PacketInformation.IDLE);
    }


    // public void setComPrepaidInfo(String data) {
    // System.out.println("setComPrepaidInfo()");
    // ArrayList<String> datas = divisionData(data);
    // ComPrepaidInfoDto dto;
    // dto = new ComPrepaidInfoDto();
    // dto.setField(data);
    // network.view.comPrepaidInfos.add(dto);
    // String[] time = Float.toString(dto.getPrepaidTime()).split(".");
    //
    // if (time.length > 1) {
    // network.view.timeStr[i] = time[0] + "시간 " + time[1] + "분" +
    // dto.getPrepaidPrice() + "원";
    // } else {
    // network.view.timeStr[i] = time[0] + "시간 " + dto.getPrepaidPrice() + "원";
    // }
    //
    //
    //
    // }
    //
    // public void setPointInfo(String data) {
    // System.out.println("setPointInfo()");
    // ArrayList<String> datas = divisionData(data);
    // PointInfoDto dto;
    //
    // int size = datas.size();
    // for (int i = 0; i < size; i++) {
    // dto = new PointInfoDto();
    // dto.setField(datas.get(i));
    // network.view.pointInfos.add(dto);
    //
    // network.view.timeStr[i] = dto.getValue() + "P " + dto.getPrice() + "원";
    // }
    //
    // network.view.createView();
    // }

    public ArrayList<String> divisionData(String data) {
	System.out.println("divisionData()");
	ArrayList<String> datas = new ArrayList<>();

	StringTokenizer dataToken = new StringTokenizer(data, "|");

	while (dataToken.hasMoreTokens()) {
	    datas.add(dataToken.nextToken());
	}

	return datas;
    }
}
