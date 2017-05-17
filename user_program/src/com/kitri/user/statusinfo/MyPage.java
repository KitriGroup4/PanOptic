package com.kitri.user.statusinfo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyPage extends JFrame {

	private JPanel BackgroundPane;
	public JTextField mypg_pw_tf;
	public JTextField mypg_hp_tf;
	public JTextField mypg_mail_tf;
	private JPanel Middle_Pane;
	public JLabel mypg_name;
	private JLabel mypg_name_label;
	private JLabel mypg_id_label;
	private JLabel mypg_pw_label;
	private JLabel mypg_hp_label;
	private JLabel mypg_mail_label;
	private JLabel mypg_accu_time_label;
	public JLabel mypg_id;
	private JLabel mypg_point_label;
	public JLabel mypg_rest_time;
	public JLabel mypg_accu_time;
	private JLabel mypg_rest_time_label;
	public JLabel mypg_point;
	public JButton mypg_change_btn;
	public JButton mypg_cancel_btn;
	private JLabel mypage_title_label;
	private JPanel Bottom_Pane;
	private JPanel Title_Pane;
	public MyPageListener listener;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					mypage frame = new mypage();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyPage() {
		listener = new MyPageListener(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 382, 489);
		BackgroundPane = new JPanel();
		BackgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(BackgroundPane);
		BackgroundPane.setLayout(null);
		
		Middle_Pane = new JPanel();
		Middle_Pane.setBounds(0, 80, 366, 267);
		BackgroundPane.add(Middle_Pane);
		Middle_Pane.setLayout(null);
		
		mypg_name = new JLabel("New label");
		mypg_name.setBounds(186, 37, 116, 15);
		Middle_Pane.add(mypg_name);
		
		mypg_name_label = new JLabel("회원이름");
		mypg_name_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_name_label.setVerticalAlignment(SwingConstants.TOP);
		mypg_name_label.setBounds(79, 37, 69, 15);
		Middle_Pane.add(mypg_name_label);
		
		mypg_id_label = new JLabel("ID");
		mypg_id_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_id_label.setBounds(79, 67, 69, 15);
		Middle_Pane.add(mypg_id_label);
		
		mypg_pw_label = new JLabel("PW");
		mypg_pw_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_pw_label.setBounds(79, 97, 69, 15);
		Middle_Pane.add(mypg_pw_label);
		
		mypg_hp_label = new JLabel("핸드폰번호");
		mypg_hp_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_hp_label.setBounds(79, 127, 69, 15);
		Middle_Pane.add(mypg_hp_label);
		
		mypg_mail_label = new JLabel("이메일주소");
		mypg_mail_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_mail_label.setBounds(79, 157, 69, 15);
		Middle_Pane.add(mypg_mail_label);
		
		mypg_accu_time_label = new JLabel("누적사용시간");
		mypg_accu_time_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_accu_time_label.setBounds(68, 182, 80, 15);
		Middle_Pane.add(mypg_accu_time_label);
		
		mypg_rest_time_label = new JLabel("잔여시간");
		mypg_rest_time_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_rest_time_label.setBounds(68, 213, 80, 15);
		Middle_Pane.add(mypg_rest_time_label);
		
		mypg_id = new JLabel("New label");
		mypg_id.setBounds(186, 67, 116, 15);
		Middle_Pane.add(mypg_id);
		
		mypg_pw_tf = new JTextField();
		mypg_pw_tf.setBounds(186, 94, 116, 21);
		Middle_Pane.add(mypg_pw_tf);
		mypg_pw_tf.setColumns(10);
		
		mypg_hp_tf = new JTextField();
		mypg_hp_tf.setColumns(10);
		mypg_hp_tf.setBounds(186, 124, 116, 21);
		Middle_Pane.add(mypg_hp_tf);
		
		mypg_mail_tf = new JTextField();
		mypg_mail_tf.setColumns(10);
		mypg_mail_tf.setBounds(186, 154, 116, 21);
		Middle_Pane.add(mypg_mail_tf);
		
		mypg_accu_time = new JLabel("New label");
		mypg_accu_time.setBounds(186, 185, 116, 15);
		Middle_Pane.add(mypg_accu_time);
		
		mypg_rest_time = new JLabel("New label");
		mypg_rest_time.setBounds(186, 213, 116, 15);
		Middle_Pane.add(mypg_rest_time);
		
		mypg_point_label = new JLabel("포인트");
		mypg_point_label.setHorizontalAlignment(SwingConstants.TRAILING);
		mypg_point_label.setBounds(68, 238, 80, 15);
		Middle_Pane.add(mypg_point_label);
		
		mypg_point = new JLabel("New label");
		mypg_point.setBounds(186, 238, 116, 15);
		Middle_Pane.add(mypg_point);
		
		Bottom_Pane = new JPanel();
		Bottom_Pane.setBounds(87, 357, 185, 62);
		BackgroundPane.add(Bottom_Pane);
		
		mypg_change_btn = new JButton("\uC218\uC815");
		mypg_change_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Bottom_Pane.add(mypg_change_btn);
		
		mypg_cancel_btn = new JButton("\uCDE8\uC18C");
		Bottom_Pane.add(mypg_cancel_btn);
		
		Title_Pane = new JPanel();
		Title_Pane.setBounds(54, 46, 268, 48);
		BackgroundPane.add(Title_Pane);
		
		mypage_title_label = new JLabel("MyPage");
		mypage_title_label.setFont(new Font("굴림", Font.PLAIN, 25));
		Title_Pane.add(mypage_title_label);
		
		setVisible(false);
		mypg_cancel_btn.addActionListener(listener);
		
	}
}
