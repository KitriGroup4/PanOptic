package com.kitri.pay.payment;

import com.kitri.pay.main.Main;
import com.kitri.pay.network.PacketInformation;

public class PayementViewLogic {
    PaymentView view;

    public PayementViewLogic(PaymentView view) {
	this.view = view;
    }

    public void pay() {
	if (view.draw.points.size() > 0) {
	    if (view.isPoint) {
		Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.POINT,
			view.index + "," + view.price);
	    } else {
		Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.TIME, view.index + "," + view.price);
	    }
	}

    }

}
