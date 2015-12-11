package application_ui;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import regression_suite.Operations;
import regression_suite.SanitySuite;


public class MainWindow extends JFrame 
{
	private static Thread automation;
	
	private static final long serialVersionUID = 1L;

	public static JCheckBox San_PCLProvisioning;
	public static JCheckBox San_ASN;
	public static JCheckBox San_CUG;
	public static JCheckBox San_FaultManagement;
	public static JCheckBox San_CeaseService;
	public static JCheckBox San_QueryManagement;
	public static JCheckBox San_SinglePayment;
	public static JCheckBox San_MaintainDepositReason;
	public static JCheckBox San_GenerateVerifyReport;
	
	public static JLabel San_PCLProvisioning_status;
	public static JLabel San_ASN_status;
	public static JLabel San_CUG_status;
	public static JLabel San_FaultManagement_status;
	public static JLabel San_CeaseService_status;
	public static JLabel San_QueryManagement_status;
	public static JLabel San_SinglePayment_status;
	public static JLabel San_MaintainDepositReason_status;
	public static JLabel San_GenerateVerifyReport_status;
	
	public static JCheckBox chckbxComverse;
	public static JCheckBox chckbxSelectAll;
	
	public static JComboBox<String> autSelection;
	
	public static JButton btnExecute;
	public static JButton btnClearClose;
	
	public static JTextArea consoleArea = null;
	private JLabel label;
	private JLabel lblReportLocation;
	public static JLabel Reportlocation;
	private JLabel colon_Label_1;
	public static JLabel current_BuildNumber;
	
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
		mntmPreference.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				PreferenceWindow prefWindow = new PreferenceWindow();
				prefWindow.setVisible(true);
			}
		});
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
				aboutwindow.setAlwaysOnTop(true);
			}
		});
		mnHelp.add(mntmAbout_1);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][][][][grow]", "[][][][][][][][][][][][][][grow]"));
		
		chckbxSelectAll = new JCheckBox("");
		chckbxSelectAll.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				if (chckbxSelectAll.isSelected())
				{
					San_PCLProvisioning.setSelected(true);
					San_ASN.setSelected(true);
					San_CUG.setSelected(true);
					San_FaultManagement.setSelected(true);
					San_CeaseService.setSelected(true);
					San_QueryManagement.setSelected(true);
					San_SinglePayment.setSelected(true);
					San_MaintainDepositReason.setSelected(true);
					San_GenerateVerifyReport.setSelected(true);
					
					btnExecute.setEnabled(true);
				}
				
				else
				{
					San_PCLProvisioning.setSelected(false);
					San_ASN.setSelected(false);
					San_CUG.setSelected(false);
					San_FaultManagement.setSelected(false);
					San_CeaseService.setSelected(false);
					San_QueryManagement.setSelected(false);
					San_SinglePayment.setSelected(false);
					San_MaintainDepositReason.setSelected(false);
					San_GenerateVerifyReport.setSelected(false);
					
					btnExecute.setEnabled(false);
				}
			}
		});
		panel.add(chckbxSelectAll, "cell 0 0");
		
		JLabel lblSelectAll = new JLabel("Select All");
		lblSelectAll.setLabelFor(chckbxSelectAll);
		panel.add(lblSelectAll, "cell 1 0,alignx left");
		
		btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SanitySuite suite = new SanitySuite();
		        automation = new Thread(suite);
		        
		        automation.start();
		        
				MainWindow.btnClearClose.setText("Stop");
				MainWindow.btnExecute.setEnabled(false);
				MainWindow.autSelection.setEnabled(false);
			}
		});
		
		autSelection = new JComboBox<String>();
		autSelection.setModel(new DefaultComboBoxModel<String>(new String[] {"13BT", "14AT"}));
		panel.add(autSelection, "cell 2 0,growx");
		panel.add(btnExecute, "cell 3 0");
		
		btnClearClose = new JButton("Clear");
		btnClearClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btnClearClose.getText()=="Stop")
				{
					try
					{
						Operations.driver.close();
					}
					catch(Exception e1)
					{
						writetoUIconsole("Not able to close browser (Already closed or Close it manually)");
					}
					Operations.driver.quit();
					
					MainWindow.btnClearClose.setText("Clear");
					MainWindow.btnExecute.setEnabled(true);
					MainWindow.autSelection.setEnabled(true);
				}
				else if(btnClearClose.getText()=="Clear")
				{
					San_PCLProvisioning.setSelected(false);
					San_ASN.setSelected(false);;
					San_CUG.setSelected(false);;
					San_FaultManagement.setSelected(false);;
					San_CeaseService.setSelected(false);;
					San_QueryManagement.setSelected(false);;
					San_SinglePayment.setSelected(false);;
					San_MaintainDepositReason.setSelected(false);;
					San_GenerateVerifyReport.setSelected(false);;
					
					chckbxSelectAll.setSelected(false);
					MainWindow.btnExecute.setEnabled(true);
					MainWindow.autSelection.setEnabled(true);
				}
			}
		});
		panel.add(btnClearClose, "cell 4 0");
		
		San_PCLProvisioning = new JCheckBox("");
		panel.add(San_PCLProvisioning, "cell 0 2");
		
		JLabel lblPclProvisioning = new JLabel("PCL Provisioning");
		lblPclProvisioning.setLabelFor(San_PCLProvisioning);
		panel.add(lblPclProvisioning, "cell 1 2,alignx left");
		
		San_PCLProvisioning_status = new JLabel("");
		panel.add(San_PCLProvisioning_status, "cell 3 2");
		
		colon_Label_1 = new JLabel(":");
		panel.add(colon_Label_1, "cell 6 3");
		
		current_BuildNumber = new JLabel("");
		panel.add(current_BuildNumber, "cell 7 3");
		
		colon_Label_1 = new JLabel(":");
		panel.add(colon_Label_1, "cell 6 5");
		
		San_ASN = new JCheckBox("");
		panel.add(San_ASN, "cell 0 3");
		
		JLabel lblAlterServiceNumber = new JLabel("Alter Service Number");
		lblAlterServiceNumber.setLabelFor(San_ASN);
		panel.add(lblAlterServiceNumber, "cell 1 3,alignx left");
		
		San_ASN_status = new JLabel("");
		panel.add(San_ASN_status, "cell 3 3");
		
		label = new JLabel("Current Build");
		panel.add(label, "cell 5 3");
		
		San_CUG = new JCheckBox("");
		panel.add(San_CUG, "cell 0 4");
		
		JLabel lblCreatCugAnd = new JLabel("Create CUG and add Service");
		lblCreatCugAnd.setLabelFor(San_CUG);
		panel.add(lblCreatCugAnd, "cell 1 4,alignx left");
		
		San_CUG_status = new JLabel("");
		panel.add(San_CUG_status, "cell 3 4");
		
		San_FaultManagement = new JCheckBox("");
		panel.add(San_FaultManagement, "cell 0 5");
		
		JLabel lblMaintainFault = new JLabel("Maintain Fault");
		lblMaintainFault.setLabelFor(San_FaultManagement);
		panel.add(lblMaintainFault, "cell 1 5,alignx left");
		
		San_FaultManagement_status = new JLabel("");
		panel.add(San_FaultManagement_status, "cell 3 5");
		
		lblReportLocation = new JLabel("Report Location");
		panel.add(lblReportLocation, "cell 5 5");
		
		Reportlocation = new JLabel("");
		Reportlocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) 
			{
				try 
				{
					Desktop.getDesktop().open(new File(Reportlocation.getText()));
				} catch (IOException e) {
					writetoUIconsole("Not able to Open Report Location. Please make sure that the location exists.");
					e.printStackTrace();
				}
			}
		});
		Reportlocation.setForeground(Color.BLUE);
		panel.add(Reportlocation, "cell 7 5");
		
		San_CeaseService = new JCheckBox("");
		panel.add(San_CeaseService, "cell 0 6");
		
		JLabel lblCeaseService = new JLabel("Cease Service");
		lblCeaseService.setLabelFor(San_CeaseService);
		panel.add(lblCeaseService, "cell 1 6,alignx left");
		
		San_CeaseService_status = new JLabel("");
		panel.add(San_CeaseService_status, "cell 3 6");
		
		San_QueryManagement = new JCheckBox("");
		panel.add(San_QueryManagement, "cell 0 7");
		
		JLabel lblMaintainQuery = new JLabel("Maintain Query");
		lblMaintainQuery.setLabelFor(San_QueryManagement);
		panel.add(lblMaintainQuery, "cell 1 7,alignx left");
		
		San_QueryManagement_status = new JLabel("");
		panel.add(San_QueryManagement_status, "cell 3 7");
		
		San_SinglePayment = new JCheckBox("");
		panel.add(San_SinglePayment, "cell 0 8");
		
		JLabel lblSinglePayment = new JLabel("Single Payment");
		lblSinglePayment.setLabelFor(San_SinglePayment);
		panel.add(lblSinglePayment, "cell 1 8,alignx left");
		
		San_SinglePayment_status = new JLabel("");
		panel.add(San_SinglePayment_status, "cell 3 8");
		
		San_MaintainDepositReason = new JCheckBox("");
		panel.add(San_MaintainDepositReason, "cell 0 9");
		
		JLabel lblCreateDepositReason = new JLabel("Create Deposit Reason");
		lblCreateDepositReason.setLabelFor(San_MaintainDepositReason);
		panel.add(lblCreateDepositReason, "cell 1 9,alignx left");
		
		San_MaintainDepositReason_status = new JLabel("");
		panel.add(San_MaintainDepositReason_status, "cell 3 9");
		
		San_GenerateVerifyReport = new JCheckBox("");
		panel.add(San_GenerateVerifyReport, "cell 0 10");
		
		JLabel lblGenerateReport = new JLabel("Generate Report");
		lblGenerateReport.setLabelFor(San_GenerateVerifyReport);
		panel.add(lblGenerateReport, "cell 1 10,alignx left");
		
		San_GenerateVerifyReport_status = new JLabel("");
		panel.add(San_GenerateVerifyReport_status, "cell 3 10");
		
		consoleArea = new JTextArea("");
		
		consoleArea.setForeground(Color.BLUE);
		consoleArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(consoleArea);
		panel.add(scrollPane, "cell 0 11 9 3,grow");
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				AboutWindow aboutwindow = new AboutWindow();
				
				aboutwindow.setVisible(true);
			}
		});
		
	}
	
	public static void writetoUIconsole(String message)
	{
		MainWindow.consoleArea.append("\n"+message);
		MainWindow.consoleArea.revalidate();
		consoleArea.setCaretPosition(consoleArea.getDocument().getLength());
	}
}
