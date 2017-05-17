package com.kitri.user.main;

import com.kitri.user.login.UserLogin;

public class Main {
	public static UserLogin mView;

	public static void main(String[] args) {
		mView = new UserLogin();
		mView.setVisible(true);
	}
}
