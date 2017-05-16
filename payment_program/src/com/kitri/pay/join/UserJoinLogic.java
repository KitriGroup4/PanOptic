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
	    String id = join.joinId.getText().trim();
	    String pw = join.joinPw.getText().trim();
	    String pwCheck = join.joinPwCheck.getText().trim();
	    String hp = join.joinHpTf.getText().trim();
	    String email = join.joinEmailTf.getText().trim();
	    String birth = join.joinBirth.getText().trim();
	    String isMale = join.isMale ? "1" : "0";
	    
	    // 유효성검사
	    
	    dto.setUserName(name);
	    dto.setUserId(id);
	    dto.setUserPw(pw);
	    dto.setUserHp(hp);
	    dto.setUserEmail(email);
	    dto.setUserBirth(birth);
	    dto.setIsMale(isMale);
	    Main.network.sendPacket(PacketInformation.Operation.JOIN, PacketInformation.PacketType.USER_INFO, dto.joinToString());
	    
	    
	} else {
	    join.checkIdCheckDialog();
	}
    }
    

}
