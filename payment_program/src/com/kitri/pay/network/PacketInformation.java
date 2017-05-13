package com.kitri.pay.network;

/*
 * programvalue/packet_type/data
 */
public class PacketInformation {

    class ProgramValue {
	static final byte ADMIN = 0;
	static final byte USER = 1;
	static final byte PAYMENT = 2;
    }

    class PacketStructrue {
	static final byte PROGRAM_VALUE = 0;
	static final byte PACKET_TYPE = 1;
	static final byte DATA = 2;

    }

    class PacketType {
	static final byte POINT_INFO = 0;
	static final byte TIME_INFO = 1;
    }

}
