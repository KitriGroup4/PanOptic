package com.kitri.user.join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.main.Main;

public class UserJoinListener implements ActionListener {
	UserJoin join;

	public UserJoinListener(UserJoin join) {
		this.join = join;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == join.overCheckBtn) {

		}
		if (o == join.joinConfirmBtn) {
			joinUser();
		}
		if (o == join.joinCloseBtn) {
			join.setVisible(false);
		}
	}

	private void joinUser() {
		
		String id = join.joinId.getText().trim();
		String pw = join.joinPw.getText().trim();
		String pwCheck = join.joinPwCheck.getText().trim();
		String Email = join.joinEmailTf.getText().trim();
		String hp = join.joinHpTf.getText().trim();
		String birth = join.yy.getSelectedItem() + "-" + join.mm.getSelectedItem() + "-" + join.dd.getSelectedItem();

		int len = pw.length();
		if (len < 8) {
			join.pwTooShort();
			return;
		}
		if (!pw.equals(pwCheck)){
			join.pwCheckError();
			return;
		}
		if (!Email.contains("@") || !Email.contains(".")) {
			join.emailInputError();
			return;
		}
		len = hp.length();
		boolean isHp = true;
		for (int i = 0; i < len; i++) {
			if (hp.charAt(i) < '0' || hp.charAt(i) > '9') {
				isHp = false;
				break;
			}
		}
		if (len != 11 || !hp.startsWith("010") || !isHp) {
			join.hpInputError();
			
		}
	}
}
