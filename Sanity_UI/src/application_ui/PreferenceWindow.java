package application_ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import testdata.TestData;

public class PreferenceWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField reportLocation;
	private JTextField autUsername;
	private JPasswordField autPassword;
	private JButton prefReset;
	private JButton prefUpdate;
	private JLabel reportLocWarningMessage;
	private JFileChooser reportFolderChooser;
	private JButton prefBrowse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {				
				try {
					PreferenceWindow frame = new PreferenceWindow();
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

	public PreferenceWindow() 
	{
		TestData.initializeConfigFile();
		TestData.loadProperties_Sanity();
		TestData.getSanityReportLocation();
		
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
		setBounds(100, 100, 576, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][]", "[][][][][]"));
		
		JLabel lblReportLocation = new JLabel("Report Location");
		contentPane.add(lblReportLocation, "cell 0 0,alignx trailing");
		
		reportLocation = new JTextField();
		reportLocation.setEditable(false);
		contentPane.add(reportLocation, "cell 1 0 2 1,growx");
		reportLocation.setColumns(10);
		
		reportLocation.setText(TestData.reportLocation);
		
		reportFolderChooser = new JFileChooser();
		reportFolderChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
		
		prefBrowse = new JButton("Browse");
		prefBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				reportFolderChooser.setCurrentDirectory(new java.io.File(reportLocation.getText()));
				
				int returnVal = reportFolderChooser.showSaveDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
				    File loc = reportFolderChooser.getSelectedFile();
				    reportLocation.setText(loc.toString()+"\\");
				}

			}
		});
		contentPane.add(prefBrowse, "cell 3 0");
		
		reportLocWarningMessage = new JLabel("");
		reportLocWarningMessage.setForeground(Color.RED);
		contentPane.add(reportLocWarningMessage, "cell 1 1");
		
		JLabel lblAutUsername = new JLabel("AUT Username");
		contentPane.add(lblAutUsername, "cell 0 2,alignx trailing");
		
		autUsername = new JTextField();
		autUsername.setColumns(10);
		contentPane.add(autUsername, "cell 1 2 3 1,growx");
		
		autUsername.setText(TestData.username);
		
		JLabel lblAutPassword = new JLabel("AUT Password");
		contentPane.add(lblAutPassword, "cell 0 3,alignx trailing");
		
		autPassword = new JPasswordField();
		contentPane.add(autPassword, "cell 1 3 3 1,growx");
		
		autPassword.setText(TestData.password);

		prefUpdate = new JButton("Update");
		prefUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				TestData.props.setProperty("userName", autUsername.getText());
				TestData.props.setProperty("password", autPassword.getPassword().toString());
				TestData.props.setProperty("Sanity_parentDir", reportLocation.getText());
				
				TestData.saveChangestoConfigFile();
			}
		});
		contentPane.add(prefUpdate, "cell 2 4");
		
		prefReset = new JButton("Reset");
		prefReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				TestData.initializeConfigFile();
				TestData.loadProperties_Sanity();
				TestData.getSanityReportLocation();
				
				autUsername.setText(TestData.username);
				autPassword.setText(TestData.password);
				reportLocation.setText(TestData.reportLocation);
			}
		});
		contentPane.add(prefReset, "cell 3 4,growx");
	}

}
