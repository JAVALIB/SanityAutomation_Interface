package testsuite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class AboutWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutWindow frame = new AboutWindow();
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
	public AboutWindow() {
		
		File MainWindowIcon = new File("Resources/Icons/MainWindowIcon.png");
		try 
		{
			setIconImage(ImageIO.read(MainWindowIcon ));
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAboutSanityAutomation = new JLabel("About Sanity Automation");
		lblAboutSanityAutomation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAboutSanityAutomation, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Coded by : Nikhil Das");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblSpecialThanksTo = new JLabel("Special Thanks to Gregor \u010Cre\u0161nar for Icon");
		lblSpecialThanksTo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSpecialThanksTo, BorderLayout.SOUTH);
	}

}
