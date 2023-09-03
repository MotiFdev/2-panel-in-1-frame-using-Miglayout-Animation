package moti.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import moti.component.PanelCover;
import moti.component.PanelSwitch;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel bg;
	private PanelSwitch loginregister;
	private PanelCover cover;
	private MigLayout layout;
	private boolean isLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void init() {

		loginregister = new PanelSwitch();

		TimingTarget target = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				if (fraction >= 0.5f) {
					loginregister.showregister(isLogin);
				}
			}

			@Override
			public void end() {
				isLogin = !isLogin;
			}
		};

		Animator animator = new Animator(10, target);
		animator.setResolution(0);

		layout = new MigLayout("fill, insets -10", "[][]", "[]");
		cover = new PanelCover();
		bg.setLayout(layout);
		bg.add(cover, "pos 0al -5 null 120%,cell 0 0,width 35%");
		cover.addEvent(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!animator.isRunning()) {
					animator.start();
				}

			}
		});
		bg.add(loginregister, "pos 1al -5 null 110%,cell 0 0,width 70%");
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 470);
		bg = new JPanel();
		bg.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(bg);
		init();
	}

}
