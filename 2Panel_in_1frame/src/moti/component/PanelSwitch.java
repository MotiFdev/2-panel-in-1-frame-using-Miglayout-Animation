package moti.component;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelSwitch extends JLayeredPane {
	private JPanel panel1;
	private JPanel panel2;

	/**
	 * Create the panel.
	 */
	public PanelSwitch() {
		setLayout(new CardLayout(0, 0));
		register();
		login();
	}
	
	public void register() {
		panel1 = new JPanel();
		panel1.setBackground(Color.GRAY);
		panel1.setBounds(0, 0, 552, 390);
		add(panel1);
		panel1.setLayout(new MigLayout("wrap", "push[][][]push", "push[center]push"));
		
		JLabel lblPanel2 = new JLabel("PANEL1");
		lblPanel2.setFont(new Font("sansserif", 1, 30));
		lblPanel2.setForeground(new Color(53, 47, 68));
		panel1.add(lblPanel2, "cell 1 0");
		
		
	}
	
	public void login() {
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 557, 380);
		add(panel2);
		
		panel2.setLayout(new MigLayout("wrap", "push[][][]push", "push[center]push"));
		
		JLabel lblPanel2 = new JLabel("PANEL2");
		lblPanel2.setFont(new Font("sansserif", 1, 30));
		lblPanel2.setForeground(new Color(53, 47, 68));
		panel2.add(lblPanel2, "cell 1 0");
		
	}
	
	public void showregister(boolean show) {
		if(show) {
			panel1.setVisible(true);
			panel2.setVisible(false);
		}else {
			panel1.setVisible(false);
			panel2.setVisible(true);
		}
	}

}
