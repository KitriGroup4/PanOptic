package com.kitri.user.messenger;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Messenger extends JFrame {
    private JTextField msgTf;
    private JPanel BackgroundPane;
    private JLabel msgTitleLabel;
    private JPanel MsgTitlePane;
    private JScrollPane MsgTextAreaPane;
    private JTextArea msgtextArea;
    private JPanel MessageTfPane;
    private JPanel MsgSendPane;
    private JButton msgBtn;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Messenger frame = new Messenger();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Messenger() {
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 427, 341);
	BackgroundPane = new JPanel();
	BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(BackgroundPane);
	BackgroundPane.setLayout(null);

	MsgTitlePane = new JPanel();
	FlowLayout fl_MsgTitlePane = (FlowLayout) MsgTitlePane.getLayout();
	fl_MsgTitlePane.setAlignment(FlowLayout.LEFT);
	MsgTitlePane.setBounds(12, 10, 175, 34);
	BackgroundPane.add(MsgTitlePane);

	msgTitleLabel = new JLabel("[ \uB300\uD654\uCC3D ]");
	msgTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
	msgTitleLabel.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 23));
	MsgTitlePane.add(msgTitleLabel);

	MsgTextAreaPane = new JScrollPane();
	MsgTextAreaPane.setBounds(12, 54, 387, 189);
	BackgroundPane.add(MsgTextAreaPane);

	msgtextArea = new JTextArea();
	msgtextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
	MsgTextAreaPane.setViewportView(msgtextArea);

	MessageTfPane = new JPanel();
	MessageTfPane.setBounds(12, 253, 276, 39);
	BackgroundPane.add(MessageTfPane);
	MessageTfPane.setLayout(null);

	msgTf = new JTextField();
	msgTf.setBounds(0, 10, 276, 21);
	MessageTfPane.add(msgTf);
	msgTf.setColumns(10);

	MsgSendPane = new JPanel();
	MsgSendPane.setBounds(289, 253, 122, 39);
	BackgroundPane.add(MsgSendPane);

	msgBtn = new JButton("      \uC804\uC1A1      ");
	msgBtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 12));
	MsgSendPane.add(msgBtn);

	setVisible(false);
    }
}
