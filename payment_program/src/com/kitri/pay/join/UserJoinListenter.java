package com.kitri.pay.join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.pay.main.Main;

public class UserJoinListenter implements ActionListener {

    UserJoin join;
    UserJoinLogic logic;

    public UserJoinListenter(UserJoin join) {
	this.join = join;
	logic = new UserJoinLogic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	if (o == join.joinCloseBtn) {
	    join.setVisible(false);
	} else if (o == join.overCheckBtn) {
	    logic.checkId(join.joinId.getText().trim());
	} else if( o == join.joinConfirmBtn) {
	    logic.joinUser(join);
	}
    }

}
