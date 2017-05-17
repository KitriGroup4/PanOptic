package com.kitri.user.messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessengerListener implements ActionListener{
	Messenger msg;
	public MessengerListener(Messenger msg){
		this.msg = msg;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o== msg.msgBtn){
			
		}
		
	}

}
