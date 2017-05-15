package com.kitri.pay.join;

import com.kitri.pay.dto.UserInfoDto;
import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation;

public class UserJoinLogic {

    public void checkId(String id) {
	if(!id.isEmpty() && !id.equals("")){	
	    Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.CHECK_USER_ID, id);
	 
	}
   }

    public void joinUser(UserJoin join) {
	if (join.checkId) {
	    UserInfoDto dto = new UserInfoDto();
	    String name = join.joinName.getText().trim();
	    String pw = join.joinPw.getText().trim();
	    String pwCheck = join.joinPwCheck.getText().trim();
	} else {
	    join.checkIdDialog();
	}
    }

}
