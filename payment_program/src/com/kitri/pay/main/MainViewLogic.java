package com.kitri.pay.main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainViewLogic {

    public boolean isClickButton(Object o, JLabel[] buttons, boolean[] isClick) {
	boolean result = false;
	int len = buttons.length;
	for (int i = 0; i < len; i++) {
	    if (o == buttons[i]) {
		if (isClick[i]) {
		    isClick[i] = false;
		    buttons[i].setForeground(Color.BLACK);
		} else {
		    buttons[i].setForeground(Color.BLUE);

		    isClick[i] = true;
		}

		result = true;
	    } else {
		buttons[i].setForeground(Color.BLACK);
		isClick[i] = false;
	    }
	}

	return result;
    }

    public boolean isClickButton(Object o, JButton[] buttons, MainView view) {
	boolean result = false;
	int len = buttons.length;

	for (int i = 0; i < len; i++) {
	    if (o == buttons[i]) {
		result = true;

		
		switch (i) {
		case 0: // 회원가입
		    System.out.println("회원가입");
		    break;
		case 1: // 포인트결제
		case 2: // 카드 결제
//		    if (isSelected(view.isClickTime, view.isClickPoint)) {
//			System.out.println("카드 결제");
//		    }
		    break;
		default:
		}
		break;
	    }
	}
	return result;
    }

    private void decisionPayType(int type, MainView view) {
	

    }

    private boolean isSelected(boolean[] is) {
	boolean result = false;

	int len = is.length;
	for (int i = 0; i < len; i++) {
	    if (is[i]) {
		result = true;
		break;
	    }
	}
	return result;
    }

}
