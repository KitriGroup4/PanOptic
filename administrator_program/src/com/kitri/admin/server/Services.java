package com.kitri.admin.server;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.SQLException;

public class Services {
    ClientHandlerThread clientHandlerThread;

    public Services(ClientHandlerThread clientHandlerThread) {
	this.clientHandlerThread = clientHandlerThread;
	// database = new Database();
    }
//
//    public void joinUser() {
//	Server.addLog("Join User");
//	String query = "insert into user_info(user_id, user_name, user_password) values('"
//		+ clientHandlerThread.currentInformation.userId + "','"
//		+ clientHandlerThread.currentInformation.userName + "', old_password('"
//		+ clientHandlerThread.currentInformation.userPassword + "'));";
//	ServerThread.database.setQuery(query);
//	ServerThread.database.updateData();
//	clientHandlerThread.sendData(PacketInformation.Situation.JOIN, PacketInformation.Share.IS_SUCCESS,
//		Integer.toString(PacketInformation.Share.IS_SUCCESS));
//	Server.addLog("Join User");
//    }
//
//    public void loginUser() {
//	System.out.println("loginUser()");
//	String query = null;
//	String password = null;
//	String userNumber = null;
//	try {
//	    query = "select user_number from user_info where user_id = '"
//		    + clientHandlerThread.currentInformation.userId + "' and user_password = old_password('"
//		    + clientHandlerThread.currentInformation.userPassword + "');";
//	    // ServerThread.database.setQuery("select user_password, user_number
//	    // from user_info where user_id = '" +
//	    // clientHandlerThread.currentInformation.userId + "';");
//	    ServerThread.database.setQuery(query);
//	    // System.out.println(query);
//	    ServerThread.database.getData();
//
//	    if (!ServerThread.database.getResultSet().next()) {
//		clientHandlerThread.sendData(PacketInformation.Situation.LOGIN, PacketInformation.Share.IS_SUCCESS,
//			"0");
//	    } else {
//		// password = ServerThread.database.getResultSet().getString(1);
//		userNumber = ServerThread.database.getResultSet().getString(1);
//		// if(password.equals(clientHandlerThread.currentInformation.userPassword))
//		// {
//		clientHandlerThread.sendData(PacketInformation.Situation.LOGIN, PacketInformation.Share.USER_NUMBER,
//			userNumber);
//		clientHandlerThread.sendData(PacketInformation.Situation.LOGIN, PacketInformation.Share.IS_SUCCESS,
//			"1");
//		// }
//		// else
//		// {
//		// clientHandlerThread.sendData(PacketInformation.Situation.LOGIN,
//		// PacketInformation.Share.IS_SUCCESS, "0");
//		// }
//		clientHandlerThread.currentInformation.userNumber = Integer.parseInt(userNumber);
//		System.out.println("login userNumber : " + clientHandlerThread.currentInformation.userNumber);
//
//	    }
//
//	} catch (Exception e) {
//
//	}
//    }
//
//    public void sendNoteData(String userNumber) {
//	System.out.println("sendNoteData() : " + clientHandlerThread.currentInformation.userNumber + ", " + userNumber);
//	Robot robot;
//	String query = "select * from note_info where user_number = " + Integer.parseInt(userNumber) + ";";
//	try {
//	    ServerThread.database.setQuery(query);
//	    ServerThread.database.getData();
//
//	    while (ServerThread.database.getResultSet().next()) {
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST,
//			PacketInformation.NoteList.NOTE_NUMBER,
//			Integer.toString(ServerThread.database.getResultSet().getInt(1)));
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST, PacketInformation.NoteList.BEACON_ID,
//			Integer.toString(ServerThread.database.getResultSet().getInt(2)));
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST,
//			PacketInformation.NoteList.USER_NUMBER,
//			Integer.toString(ServerThread.database.getResultSet().getInt(3)));
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST,
//			PacketInformation.NoteList.NOTE_TITLE, ServerThread.database.getResultSet().getString(4));
//		// clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST,
//		// PacketInformation.NoteList.NOTE_BODY,
//		// ServerThread.database.getResultSet().getString(5));
//		// clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST,
//		// PacketInformation.NoteList.NOTE_GOAL_DATE_TIME,
//		// ServerThread.database.getResultSet().getString(6));
//		try {
//		    robot = new Robot();
//		    robot.delay(10);
//		} catch (AWTException e) {
//		    System.out.println("delay error : " + e.toString());
//		}
//	    }
//	    clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST, PacketInformation.Share.IS_END, "a");
//	} catch (Exception e) {
//	    System.out.println();
//	}
//    }
//
//    public void updateNoteInformation() {
//	System.out.println("updateNoteInformation()");
//	ServerThread.database.setQuery("select * from note_info where note_number = "
//		+ clientHandlerThread.currentInformation.noteNumber + ";");
//	ServerThread.database.getData();
//	System.out.println("updateNoteInformation()");
//	try {
//	    if (!ServerThread.database.getResultSet().next()) {
//		// String temp = "insert into note_info(note_number, beacon_id,
//		// user_number, note_title, note_body, note_goal_date_time)
//		// values(" + clientHandlerThread.currentInformation.noteNumber
//		// + ", " +
//		// clientHandlerThread.currentInformation.positionNumber + ", "
//		// + clientHandlerThread.currentInformation.userNumber + ",
//		// old_password('" +
//		// clientHandlerThread.currentInformation.noteTitle + "'),
//		// old_password('" +
//		// clientHandlerThread.currentInformation.noteBody + "'), '" +
//		// clientHandlerThread.currentInformation.goalDateTime + "');";
//		String temp = "insert into note_info(note_number, beacon_id, user_number, note_title, note_body, note_goal_date_time) values("
//			+ clientHandlerThread.currentInformation.noteNumber + ", "
//			+ clientHandlerThread.currentInformation.positionNumber + ", "
//			+ clientHandlerThread.currentInformation.userNumber + ", '"
//			+ clientHandlerThread.currentInformation.noteTitle + "', '"
//			+ clientHandlerThread.currentInformation.noteBody + "', '"
//			+ clientHandlerThread.currentInformation.goalDateTime + "');";
//
//		ServerThread.database.setQuery(temp);
//		ServerThread.database.updateData();
//		System.out.println("updateNoteInformation()");
//	    } else {
//		// ServerThread.database.setQuery("update note_info set
//		// note_title = old_password('" +
//		// clientHandlerThread.currentInformation.noteTitle + "'),
//		// note_body = old_password('" +
//		// clientHandlerThread.currentInformation.noteBody + "'),
//		// beacon_id = " +
//		// clientHandlerThread.currentInformation.positionNumber + ",
//		// note_goal_date_time = '" +
//		// clientHandlerThread.currentInformation.goalDateTime + "'
//		// where note_number = " +
//		// clientHandlerThread.currentInformation.noteNumber + ";");
//		ServerThread.database.setQuery(
//			"update note_info set note_title = '" + clientHandlerThread.currentInformation.noteTitle
//				+ "', note_body = '" + clientHandlerThread.currentInformation.noteBody
//				+ "', beacon_id = " + clientHandlerThread.currentInformation.positionNumber
//				+ ", note_goal_date_time = '" + clientHandlerThread.currentInformation.goalDateTime
//				+ "' where note_number = " + clientHandlerThread.currentInformation.noteNumber + ";");
//		ServerThread.database.updateData();
//		System.out.println("updateNoteInformation()");
//	    }
//	} catch (Exception e) {
//	    System.out.println("updateNoteInformation() error : " + e.toString());
//	}
//    }
//
//    public void noteEditMessage() {
//	System.out.println("send Position Information");
//	ServerThread.database.setQuery("select * from position_info");
//	ServerThread.database.getData();
//
//	String positionNumber = null;
//	String beaconPosition = null;
//	String positionName = null;
//
//	try {
//	    while (ServerThread.database.getResultSet().next()) {
//		positionNumber = Integer.toString(ServerThread.database.getResultSet().getInt(1));
//		beaconPosition = Integer.toString(ServerThread.database.getResultSet().getInt(2));
//		positionName = ServerThread.database.getResultSet().getString(3);
//
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTEEDIT,
//			PacketInformation.NoteEdit.POSITION_NUMBER, positionNumber);
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTEEDIT,
//			PacketInformation.NoteEdit.BEACON_POSITION, beaconPosition);
//		clientHandlerThread.sendData(PacketInformation.Situation.NOTEEDIT,
//			PacketInformation.NoteEdit.POSITION_NAME, positionName);
//
//	    }
//	    clientHandlerThread.sendData(PacketInformation.Situation.NOTEEDIT, PacketInformation.Share.IS_END, "a");
//
//	} catch (Exception e) {
//	    System.out.println("noteEditInformation error : " + e.toString());
//	}
//    }
//
//    public void deleteNote(int noteNumber) {
//	String query = "delete from note_info where note_number = " + noteNumber + ";";
//	ServerThread.database.setQuery(query);
//	ServerThread.database.updateData();
//
//	clientHandlerThread.sendData(PacketInformation.Situation.NOTELIST, PacketInformation.Share.DELETE_NOTE, "a");
//    }
//
//    public void notify(String data) {
//
//	String[] msg = data.split(",");
//	System.out.println("notify() : " + msg[0] + ", " + msg[1]);
//	String query = "select note_number, note_goal_date_time from note_info n, beacon_info b where n.beacon_id = b.beacon_id and b.beacon_minor = "
//		+ Integer.parseInt(msg[0]) + " and n.user_number = " + Integer.parseInt(msg[1]) + ";";
//
//	try {
//	    ServerThread.database.setQuery(query);
//	    ServerThread.database.getData();
//
//	    while (ServerThread.database.getResultSet().next()) {
//		clientHandlerThread.sendData(PacketInformation.Situation.IDLE, PacketInformation.Share.NOTIFY,
//			Integer.toString(ServerThread.database.getResultSet().getInt(1)) + ","
//				+ ServerThread.database.getResultSet().getString(2));
//	    }
//	    // clientHandlerThread.sendData(PacketInformation.Share.NOTIFY,
//	    // PacketInformation.Share.IS_END, "a");
//	} catch (Exception e) {
//	    System.out.println("notify error : " + e.toString());
//	}
//    }
//
//    public void alarm(String data) {
//	String[] temp = data.split(",");
//	System.out.println("alarm()");
//	String query = "select beacon_minor from note_info n, beacon_info b where n.beacon_id = b.beacon_id and n.note_number = "
//		+ temp[0] + " and n.user_number = " + temp[1] + ";";
//
//	try {
//	    ServerThread.database.setQuery(query);
//	    ServerThread.database.getData();
//
//	    ServerThread.database.getResultSet().next();
//	    clientHandlerThread.sendData(PacketInformation.Situation.IDLE, PacketInformation.Share.ALARM,
//		    Integer.toString(ServerThread.database.getResultSet().getInt(1)));
//
//	} catch (Exception e) {
//	    System.out.println("notify error : " + e.toString());
//	}
//    }

}
