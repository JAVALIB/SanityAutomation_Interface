package application_ui;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][]", "[][][][][]"));
		
		JLabel lblSanityAutomationSuite = new JLabel("Sanity Automation Suite");
		contentPane.add(lblSanityAutomationSuite, "cell 3 0,alignx center");
		
		JLabel lblVersionwip = new JLabel("Version 0.4.7 (WIP alpha)");
		contentPane.add(lblVersionwip, "cell 3 1,alignx center");
		
		JLabel lblCodedBy = new JLabel("Coded By : Nikhil Das");
		contentPane.add(lblCodedBy, "cell 3 2,alignx center");
		
		JLabel lblNewLabel = new JLabel("Special Thanks to Gregor \u010Cre\u0161nar for Icon");
		contentPane.add(lblNewLabel, "cell 3 4,alignx center");
	}

}
