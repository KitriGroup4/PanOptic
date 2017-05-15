package com.kitri.pay.join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.pay.main.Main;

public class UserJoinListenter implements ActionListener {

    UserJoin join;

    public UserJoinListenter(UserJoin join) {
	this.join = join;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	if (o == join.joinCloseBtn) {
	    join.setVisible(false);
	} else if (o == join.overCheckBtn) {
//	    Main.network.services.
	} else if( o == join.joinConfirmBtn) {
	    
	}

    }

}
