package moti.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelCover extends JPanel {

	/**
	 * Create the panel.
	 */
	private ActionListener event;
	private MigLayout layout;
	private JButton button;
	
	public PanelCover() {
		setOpaque(false);
		layout = new MigLayout("wrap, fill","[center]", "push[]70[]push");
		setLayout(layout);
		init();
	}
	
	public void init() {
		
		button = new JButton("CLICK ME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event.actionPerformed(e);
			}
		});
		button.setFont(new Font("SansSerif", Font.BOLD, 13));
		button.setForeground(Color.black);
		button.setBackground(Color.gray);
		add(button, "h 5%, w 15%");
	}
	
	public void addEvent(ActionListener event) {
		this.event = event;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setBackground(Color.gray);
	    g2.fillRect(0, 0, getWidth(), getHeight());
	}

}
