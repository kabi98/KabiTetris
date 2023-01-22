package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.KTetrisController;
import model.ViewListener;



public class StatusBar extends JPanel implements ActionListener, ViewListener{

	private static final long serialVersionUID = 6871773244395757663L;
	private KTetrisController controller;
//	private JLabel scoreNumberLabel;
	private JButton startButton;
	
	private final static Logger LOG = Logger.getGlobal();
	
	public StatusBar(KTetrisController controller) {
		super();
		
		LOG.info("*** Start ***");
		
		this.controller = controller;
		controller.addViewListener(this);
		this.setBackground(Color.RED);
		this.setBounds(6, 6, 347, 40);

		startButton = new JButton("start");
		startButton.setBounds(200, 6, 100, 27);
		startButton.addActionListener(this);
		this.setLayout(null);
		this.add(startButton);

//		JLabel lblNewLabel = new JLabel("score:");
//		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
//		lblNewLabel.setBounds(6, 6, 57, 27);
//		this.add(lblNewLabel);
//
//		scoreNumberLabel = new JLabel("0");
//		scoreNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		scoreNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
//		scoreNumberLabel.setBounds(75, 6, 100, 27);
//		this.add(scoreNumberLabel);
		LOG.info("*** Finish ***");
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		startButton.setVisible(false);
		controller.gameStart();
	}

	@Override
	public void onRePaint() {
		
	}

}
