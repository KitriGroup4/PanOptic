package com.kitri.pay.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentViewListener implements ActionListener {
    PaymentView view;
    PayementViewLogic logic;

    public PaymentViewListener(PaymentView view) {
	this.view = view;
	logic = new PayementViewLogic(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	
	if(o == view.payButton){
	    logic.pay();
	} else if(o == view.closeButton){
	    view.setVisible(false);
	}
	
    }

}
