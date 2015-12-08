package application_ui;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import regression_suite.SanitySuite;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class MainWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public static JCheckBox chckbxPCLProv;
	public static JCheckBox chckbxASN;
	public static JCheckBox chckbxCUG;
	public static JCheckBox chckbxMaintainFault;
	public static JCheckBox chckbxCease;
	public static JCheckBox chckbxQuery;
	public static JCheckBox chckbxSinglePay;
	public static JCheckBox chckbxDepositReason;
	public static JCheckBox chckbxReport;
	public static JCheckBox chckbxComverse;
	public static JCheckBox chckbxSelectAll;
	
	public static JButton btnExecute;
	public static JButton btnClearSelection;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() 
	{		
		File MainWindowIcon = new File("Resources/Icons/MainWindowIcon.png");
		try 
		{
			setIconImage(ImageIO.read(MainWindowIcon ));
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		setTitle("Sanity Automation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
				
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmPreference = new JMenuItem("Preference");
		mnEdit.add(mntmPreference);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout_1 = new JMenuItem("About");
		mntmAbout_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				AboutWindow aboutwindow = new AboutWindow();
				aboutwindow.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout_1);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][][][][][][grow]"));
		
		chckbxSelectAll = new JCheckBox("");
		chckbxSelectAll.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				if (chckbxSelectAll.isSelected())
				{
					chckbxPCLProv.setSelected(true);
					chckbxASN.setSelected(true);
					chckbxCUG.setSelected(true);
					chckbxMaintainFault.setSelected(true);
					chckbxCease.setSelected(true);
					chckbxQuery.setSelected(true);
					chckbxSinglePay.setSelected(true);
					chckbxDepositReason.setSelected(true);
					chckbxReport.setSelected(true);
//					chckbxComverse.setSelected(true);
					
					btnExecute.setEnabled(true);
				}
				
				else
				{
					chckbxPCLProv.setSelected(false);
					chckbxASN.setSelected(false);
					chckbxCUG.setSelected(false);
					chckbxMaintainFault.setSelected(false);
					chckbxCease.setSelected(false);
					chckbxQuery.setSelected(false);
					chckbxSinglePay.setSelected(false);
					chckbxDepositReason.setSelected(false);
					chckbxReport.setSelected(false);
//					chckbxComverse.setSelected(false);
					
					btnExecute.setEnabled(false);
				}
			}
		});
		panel.add(chckbxSelectAll, "cell 0 0");
		
		JLabel lblSelectAll = new JLabel("Select All");
		panel.add(lblSelectAll, "cell 1 0,alignx left");
		
		btnClearSelection = new JButton("Clear Selection");
		btnClearSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				chckbxPCLProv.setSelected(false);
				chckbxASN.setSelected(false);;
				chckbxCUG.setSelected(false);;
				chckbxMaintainFault.setSelected(false);;
				chckbxCease.setSelected(false);;
				chckbxQuery.setSelected(false);;
				chckbxSinglePay.setSelected(false);;
				chckbxDepositReason.setSelected(false);;
				chckbxReport.setSelected(false);;
//				chckbxComverse.setSelected(false);;
				
				chckbxSelectAll.setSelected(false);
			}
		});
		panel.add(btnClearSelection, "cell 3 0");
		
		btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SanitySuite.main(null);
			}
		});
		panel.add(btnExecute, "cell 4 0");
		
		chckbxPCLProv = new JCheckBox("");
		panel.add(chckbxPCLProv, "cell 0 2");
		
		JLabel lblPclProvisioning = new JLabel("PCL Provisioning");
		panel.add(lblPclProvisioning, "cell 1 2,alignx left");
		
		chckbxASN = new JCheckBox("");
		panel.add(chckbxASN, "cell 0 3");
		
		JLabel lblAlterServiceNumber = new JLabel("Alter Service Number");
		panel.add(lblAlterServiceNumber, "cell 1 3,alignx left");
		
		chckbxCUG = new JCheckBox("");
		panel.add(chckbxCUG, "cell 0 4");
		
		JLabel lblCreatCugAnd = new JLabel("Creat CUG and add Service");
		panel.add(lblCreatCugAnd, "cell 1 4,alignx left");
		
		chckbxMaintainFault = new JCheckBox("");
		panel.add(chckbxMaintainFault, "cell 0 5");
		
		JLabel lblMaintainFault = new JLabel("Maintain Fault");
		panel.add(lblMaintainFault, "cell 1 5,alignx left");
		
		chckbxCease = new JCheckBox("");
		panel.add(chckbxCease, "cell 0 6");
		
		JLabel lblCeaseService = new JLabel("Cease Service");
		panel.add(lblCeaseService, "cell 1 6,alignx left");
		
		chckbxQuery = new JCheckBox("");
		panel.add(chckbxQuery, "cell 0 7");
		
		JLabel lblMaintainQuery = new JLabel("Maintain Query");
		panel.add(lblMaintainQuery, "cell 1 7,alignx left");
		
		chckbxSinglePay = new JCheckBox("");
		panel.add(chckbxSinglePay, "cell 0 8");
		
		JLabel lblDoSinglePayment = new JLabel("Do Single Payment");
		panel.add(lblDoSinglePayment, "cell 1 8,alignx left");
		
		chckbxDepositReason = new JCheckBox("");
		panel.add(chckbxDepositReason, "cell 0 9");
		
		JLabel lblCreateDepositReason = new JLabel("Create Deposit Reason");
		panel.add(lblCreateDepositReason, "cell 1 9,alignx left");
		
		chckbxReport = new JCheckBox("");
		panel.add(chckbxReport, "cell 0 10");
		
		JLabel lblGenerateReport = new JLabel("Generate Report");
		panel.add(lblGenerateReport, "cell 1 10,alignx left");
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, "cell 0 12 6 1,grow");
		
//		chckbxComverse = new JCheckBox("");
//		panel.add(chckbxComverse, "cell 0 11");
//		
//		JLabel lblComverseSubscriberRetrieve = new JLabel("Comverse Subscriber Retrieve");
//		panel.add(lblComverseSubscriberRetrieve, "cell 1 11,alignx left");
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				AboutWindow aboutwindow = new AboutWindow();
				
				aboutwindow.setVisible(true);
				//TODO Add About window
			}
		});
		
	}
}
