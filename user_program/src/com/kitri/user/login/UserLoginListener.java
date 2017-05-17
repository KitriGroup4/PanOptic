package com.kitri.user.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginListener implements ActionListener {

	UserLogin view;
//	UserLoginLogic logic;

	public UserLoginListener(UserLogin view) {
		this.view = view;
//		logic = new UserLoginLogic(view);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == view.joinBtn) {
//			logic.viewJoin();
			view.join.setVisible(true);
		}
		if(o == view.loginBtn){
			
		}
	}
	
	

}
