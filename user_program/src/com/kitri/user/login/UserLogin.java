package com.kitri.user.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.*;

import javax.swing.JButton;

public class UserLogin extends JFrame {

    private JPanel contentPane;
    private JTextField pwTf;
    private JPanel EmptyPane;
    private JPanel EmptyPane1;
    private JPanel UserMainComPane;
    private JLabel mainComLabel;
    private JButton joinBtn;
    private JPanel BottomBackgrounPane;
    private JPanel BackgroundCentPane;
    private JPanel NorthEmptyPane;
    private JPanel BottomEmptyPane1;
    private JPanel WestEmptyPane;
    private JLabel emptyLabel1;
    private JLabel emptyLabel3;
    private JPanel EastEmptyPane;
    private JLabel emptyLabel4;
    private JPanel LoginLabePane;
    private JLabel label;
    private JLabel label_1;
    private JPanel LoginInputPane;
    private JTextField idTf;
    private JButton loginBtn;
    private JLabel emptyLabel14;
    private JLabel emptyLabel12;
    private JLabel emptyLabel6;
    private JLabel emptyLabel5;
    private JLabel emptyLabel9;
    private JLabel emptyLabel11;
    private JLabel emptyLabel2;
    private JLabel emptyLabel8;
    private JLabel emptyLabel7;
    private JLabel emptyLabel10;
    private JLabel emptyLabel13;
    private JLabel emptyLabel15;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UserLogin frame = new UserLogin();
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
    public UserLogin() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 556, 445);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));

	NorthEmptyPane = new JPanel();
	contentPane.add(NorthEmptyPane, BorderLayout.NORTH);
	NorthEmptyPane.setLayout(new GridLayout(1, 0, 0, 0));

	emptyLabel1 = new JLabel("         ");
	emptyLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
	NorthEmptyPane.add(emptyLabel1);

	BottomEmptyPane1 = new JPanel();
	contentPane.add(BottomEmptyPane1, BorderLayout.SOUTH);

	emptyLabel2 = new JLabel("         ");
	BottomEmptyPane1.add(emptyLabel2);

	WestEmptyPane = new JPanel();
	contentPane.add(WestEmptyPane, BorderLayout.WEST);

	emptyLabel3 = new JLabel("         ");
	WestEmptyPane.add(emptyLabel3);

	EastEmptyPane = new JPanel();
	contentPane.add(EastEmptyPane, BorderLayout.EAST);

	emptyLabel4 = new JLabel("         ");
	EastEmptyPane.add(emptyLabel4);

	BackgroundCentPane = new JPanel();
	contentPane.add(BackgroundCentPane, BorderLayout.CENTER);
	BackgroundCentPane.setLayout(new BorderLayout(0, 0));

	BottomBackgrounPane = new JPanel();
	BackgroundCentPane.add(BottomBackgrounPane, BorderLayout.SOUTH);
	BottomBackgrounPane.setLayout(new GridLayout(0, 2, 0, 0));

	LoginLabePane = new JPanel();
	BottomBackgrounPane.add(LoginLabePane);
	LoginLabePane.setLayout(new GridLayout(0, 3, 0, 0));

	emptyLabel5 = new JLabel("");
	LoginLabePane.add(emptyLabel5);

	emptyLabel6 = new JLabel("");
	LoginLabePane.add(emptyLabel6);

	label = new JLabel("ID");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabePane.add(label);

	emptyLabel7 = new JLabel("");
	LoginLabePane.add(emptyLabel7);

	emptyLabel8 = new JLabel("");
	LoginLabePane.add(emptyLabel8);

	label_1 = new JLabel("Password");
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	LoginLabePane.add(label_1);

	LoginInputPane = new JPanel();
	BottomBackgrounPane.add(LoginInputPane);
	LoginInputPane.setLayout(new GridLayout(2, 3, 0, 0));

	idTf = new JTextField();
	LoginInputPane.add(idTf);
	idTf.setColumns(10);

	emptyLabel9 = new JLabel("");
	LoginInputPane.add(emptyLabel9);

	emptyLabel10 = new JLabel("");
	LoginInputPane.add(emptyLabel10);

	pwTf = new JTextField();
	pwTf.setColumns(10);
	LoginInputPane.add(pwTf);

	emptyLabel11 = new JLabel("");
	LoginInputPane.add(emptyLabel11);

	EmptyPane = new JPanel();
	BottomBackgrounPane.add(EmptyPane);
	EmptyPane.setLayout(new GridLayout(0, 3, 0, 0));

	emptyLabel12 = new JLabel("");
	EmptyPane.add(emptyLabel12);

	emptyLabel13 = new JLabel("");
	EmptyPane.add(emptyLabel13);

	joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
	EmptyPane.add(joinBtn);

	EmptyPane1 = new JPanel();
	BottomBackgrounPane.add(EmptyPane1);
	EmptyPane1.setLayout(new GridLayout(0, 3, 0, 0));

	loginBtn = new JButton("\uB85C\uADF8\uC778");
	EmptyPane1.add(loginBtn);

	emptyLabel14 = new JLabel("");
	EmptyPane1.add(emptyLabel14);

	emptyLabel15 = new JLabel("");
	EmptyPane1.add(emptyLabel15);

	UserMainComPane = new JPanel();
	FlowLayout fl_UserMainComPane = (FlowLayout) UserMainComPane.getLayout();
	fl_UserMainComPane.setVgap(50);
	fl_UserMainComPane.setHgap(50);
	BackgroundCentPane.add(UserMainComPane, BorderLayout.WEST);

	mainComLabel = new JLabel(" PC1 ");
	UserMainComPane.add(mainComLabel);

	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = environment.getDefaultScreenDevice();
	this.setUndecorated(true);
	device.setFullScreenWindow(this);
    }

}
