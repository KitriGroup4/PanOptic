package com.kitri.pay.network;

/*
 * programvalue/packet_type/data
 */
public class PacketInformation {

    public static class ProgramValue {
	public static final byte ADMIN = 0;
	public static final byte USER = 1;
	public static final byte PAYMENT = 2;
    }

    public static class PacketStructrue {
	public static final byte PROGRAM_VALUE = 0;
	public static final byte PACKET_TYPE = 1;
	public static final byte DATA = 2;
    }
    
    public static class Operation{
	public static final byte GET = 0;
    }

    public static class PacketType {
	public static final byte POINT_INFO = 0;
	public static final byte COM_PREPAID_INFO = 1;
    }
    
    public static class ComPrepaidInfo{
	public static final byte NUM = 0;
	public static final byte TIME = 1;
	public static final byte PRICE = 2;
    }

}
