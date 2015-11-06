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


public class MainWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;

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
		setBounds(100, 100, 600, 450);
		
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
		panel.setLayout(new MigLayout("", "[]", "[][][]"));
		
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
