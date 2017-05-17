package com.kitri.admin.server;

public class Main {

    public static boolean isLog = true;

    public static void log(String str) {
	if (isLog) {
	    System.out.println(str);
	}
    }
    
    public static void log(int str) {
	if (isLog) {
	    System.out.println(str);
	}
    }

}
