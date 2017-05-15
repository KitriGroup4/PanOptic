package com.kitri.pay.main;

import java.awt.event.*;

public class MainViewListener extends MouseAdapter implements ActionListener {

    private MainView view;
    public MainViewLogic logic;

    public MainViewListener(MainView view) {
	this.view = view;
	logic = new MainViewLogic();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	super.mouseClicked(e);
	System.out.println(view.timeButton.length);
	Object o = e.getSource();
	
	if (logic.isClickButton(o, view.timeButton, view.isClickTime, view.timeMoney, view)) {
	    logic.setFalseButton(view.pointButton, view.isClickPoint, view.pointMoney, view);
	    System.out.println("time");
	} else if (logic.isClickButton(o, view.pointButton, view.isClickPoint, view.pointMoney, view)) {
	    logic.setFalseButton(view.timeButton, view.isClickTime, view.timeMoney, view);
	    System.out.println("point");
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	logic.isClickButton(o, view.functionButton, view);
	
    }

}
