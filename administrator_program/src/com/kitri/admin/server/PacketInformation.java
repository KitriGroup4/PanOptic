package com.kitri.admin.server;


public class PacketInformation
{
    public static final short packetSize = 3;

    public static class PacketStructure
    {
        public static final short SITUATION = 0;
        public static final short DATA_TYPE = 1;
        public static final short DATA = 2;
    }

    public static class IsSuccess
    {
        public static final short FALSE = 0;
        public static final short TRUE = 1;
    }

    public static class Situation
    {
        public static final short IDLE = 0;
        public static final short LOGIN = 1;
        public static final short JOIN = 2;    
        public static final short NOTEEDIT = 8;
        public static final short NOTELIST = 10;
    }

    public static class Share
    {
        public static final short IS_SUCCESS = -10;
        public static final short MESSAGE = -9;
        public static final short EMERGENCY = -8;
        public static final short IS_END = -7;
        public static final short USER_NUMBER  = -6;
        public static final short NOTIFY = -5;
        public static final short DELETE_NOTE = -4;
        public static final short ALARM = -3;
    }


    public static class Login
    {
        public static final short USER_ID = 0;
        public static final short USER_PASSWORD = 1;      
    }

    public static class Certification
    {
        public static final short USER_NUMBER = 0;
        public static final short CERTIFICATION = 1;
    }

    public static class Join
    {
        public static final short USER_NAME = 0;
        public static final short USER_ID = 1;
        public static final short USER_PASSWORD = 2;
        public static final short USER_PASSWORD_CHECK = 3;
        public static final short USER_PHOME_NUMBER = 4;
    }

    public static class NoteList
    {
        public static final short NOTE_NUMBER = 0;
        public static final short BEACON_ID = 1;
        public static final short USER_NUMBER = 2;
        public static final short NOTE_TITLE = 3;
        public static final short NOTE_BODY = 4;
        public static final short NOTE_GOAL_DATE_TIME = 5;
        
    }

    public static class NoteEdit
    {
        public static final short NOTE_ID = 0;
        public static final short BEACON_POSITION = 1;
        public static final short GOAL_DATETIME = 2;
        public static final short POSITION_NUMBER = 3;
        public static final short POSITION_NAME = 4;
        public static final short NOTE_TITLE = 5;
        public static final short NOTE_BODY = 6;

    }
   
}

