import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import xyz.null0verflow.librandomorgclient.GenerateTrueRandom;
import xyz.null0verflow.librandomorgclient.TooManyRequest;

public class ActuallyInterface extends Component{
	protected boolean stopc = true;
	protected int minimum;
	protected int maximum;
	protected int baseofnum;
	protected int total;
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel;
	int cc=0;
	JTextField totalnumber;
	JTextField min;
	JTextField max;
	JTextField base;
	JLabel albel[];
	JLabel allalbel[] = new JLabel[4];
	GenerateTrueRandom gtr;
	RadioActiveDecay rade = new RadioActiveDecay();
	JLabel credit0 = new JLabel("TRUE random generator by measuring amospheric noise and radioactive decay");
	JLabel credit1 = new JLabel("by @frychicken (Bob Dinh) with special thanks to random.org and fourmilab.ch API ");
	JLabel credit = new JLabel("Powered by librandom.org-client, libfourmilab-client (written also by @frychicken) and json-simple-1.1");
	JCheckBox darkmode = new JCheckBox("night-mode");
	JCheckBox lightmode = new JCheckBox("light-mode");
	JLabel betaalert = new JLabel("");
	JButton idontunderstand = new JButton("I have doubts");
	JButton nativedepiction = new JButton("Native Depiction");
	JButton javadepiction = new JButton("Java Depiction");

	ButtonGroup bg2;

	JRadioButton atmosphericNoise = new JRadioButton("Atmospheric Noise");
	JRadioButton radioactivedecay = new JRadioButton("Radioactive Decay");

	JRadioButton chooseal = new JRadioButton("Random integer");
	JRadioButton choosea2 = new JRadioButton("Random sequence");
	JRadioButton choosea3 = new JRadioButton("Random string");
	JCheckBox stringg[] = new JCheckBox[4];
	JButton button = new JButton("Generate TRUE random number");
	ButtonGroup bg;
	JLabel show ;
	boolean isdark;

	// setting up the interface 
	public ActuallyInterface(boolean isdark) {
		this.isdark = isdark;
		try {
			gtr =  new GenerateTrueRandom("bobdinh139@icloud.com");
		} catch (NumberFormatException | TooManyRequest | IOException e1) {
			CheckUpdate.popUp(e1.toString(), "Error");
			e1.printStackTrace();
		}
		frame = new JFrame("True random number generator");
		try {
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Hi.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bg = new ButtonGroup();
		bg2 = new ButtonGroup();
		panel = new JPanel();
		allalbel[0] = new JLabel("Total Number");
		allalbel[1] = new JLabel("Min");
		allalbel[2] = new JLabel("Max");
		allalbel[3] = new JLabel("Base");
		stringg[0] = new JCheckBox("unique");
		stringg[1] = new JCheckBox("uppercase");
		stringg[2] = new JCheckBox("lowercase");
		stringg[3] = new JCheckBox("digit");
		try {
			ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Hi.png")));
			show = new JLabel(icon); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		totalnumber = new JTextField("5");
		min = new JTextField("1");
		max = new JTextField("20");
		base = new JTextField("10");
		panel.setLayout(null);
		int y = 120;
		for (int i=0; i< allalbel.length; allalbel[i++].setBounds(460, y+=30, 100, 25));
		for (int i=0; i< stringg.length; stringg[i++].setSelected(true));

		int cccc = 250;
		for (int i=0; i< stringg.length; stringg[i++].setBounds(250, cccc+=30, 100, 25));
		for (int i=0; i< stringg.length; stringg[i++].setVisible(false));
		darkmode.setVisible(!isdark);
		darkmode.setBounds(600, 150, 150, 25);
		lightmode.setBounds(600, 150, 150, 25);
		nativedepiction.setBounds(30, 300, 200,25);
		nativedepiction.setBackground(Color.MAGENTA);
		javadepiction.setBounds(30, 330, 200,25);
		javadepiction.setBackground(Color.PINK);
		show.setBounds(10, 100, 1000, 1000);
		idontunderstand.setBounds(300, 100, 200,30);
		credit0.setBounds(60, 20, 700, 35);
		credit1.setBounds(150, 50, 550, 25);
		credit.setBounds(100, 70, 700, 25);
		credit0.setFont(new Font("Serif", Font.BOLD, 20));
		credit1.setFont(new Font("Serif", Font.ITALIC, 15));
		credit.setForeground(Color.red);
		betaalert.setBounds(540, 220, 400, 50);
		betaalert.setForeground(Color.BLUE);
		totalnumber.setBounds(250, 150, 200, 25);
		min.setBounds(250, 180, 200, 25);
		max.setBounds(250, 210, 200, 25);
		base.setBounds(250, 240, 200, 25);
		
		chooseal.setBounds(50, 180, 150, 25);
		choosea2.setBounds(50, 210, 150, 25);
		choosea3.setBounds(50, 240, 150, 25);
		bg.add(chooseal);
		bg.add(choosea2);
		bg.add(choosea3);

		atmosphericNoise.setBounds(10, 130, 200, 25);
		radioactivedecay.setBounds(10, 150, 150, 25);
		bg2.add(atmosphericNoise);
		bg2.add(radioactivedecay);
		atmosphericNoise.setSelected(true);

		button.setBounds(200, 600, 400, 100);
		chooseal.setSelected(true);
		frame.setResizable(false);
		frame.setSize(800, 800);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.add(atmosphericNoise);
		panel.add(radioactivedecay);
		panel.add(chooseal);
		panel.add(choosea2);
		panel.add(choosea3);
		for (int i=0; i< allalbel.length; panel.add(allalbel[i++]));
		for (int i=0; i< stringg.length; panel.add(stringg[i++]));
		panel.add(button);
		panel.add(totalnumber);
		panel.add(base);
		panel.add(min);
		panel.add(max);
		panel.add(credit);
		panel.add(credit1);
		panel.add(credit0);
		panel.add(show);
		panel.add(betaalert);
		panel.add(idontunderstand);
		panel.add(darkmode);
		panel.add(lightmode);
		panel.add(nativedepiction);
		panel.add(javadepiction);

		frame.add(panel);
		checkDarkMode();

		frame.setVisible(true);
	}

	// implement dark mode for button, textbox, etc
	private void checkDarkMode() {
		if (isdark) {
			credit0.setForeground(Color.WHITE);
			credit1.setForeground(Color.WHITE);
			chooseal.setBackground(Color.DARK_GRAY);
			chooseal.setForeground(Color.WHITE);
			choosea2.setBackground(Color.DARK_GRAY);
			choosea2.setForeground(Color.WHITE);
			choosea3.setBackground(Color.DARK_GRAY);
			choosea3.setForeground(Color.WHITE);
			atmosphericNoise.setBackground(Color.DARK_GRAY);
			atmosphericNoise.setForeground(Color.WHITE);
			radioactivedecay.setBackground(Color.DARK_GRAY);
			radioactivedecay.setForeground(Color.WHITE);
			darkmode.setBackground(Color.DARK_GRAY);
			darkmode.setForeground(Color.WHITE);
			lightmode.setBackground(Color.DARK_GRAY);
			lightmode.setForeground(Color.WHITE);
			totalnumber.setBackground(Color.DARK_GRAY);
			totalnumber.setForeground(Color.WHITE);
			totalnumber.setCaretColor(Color.WHITE);
			min.setBackground(Color.DARK_GRAY);
			min.setForeground(Color.WHITE);
			min.setCaretColor(Color.WHITE);
			max.setBackground(Color.DARK_GRAY);
			max.setForeground(Color.WHITE);
			max.setCaretColor(Color.WHITE);
			base.setBackground(Color.DARK_GRAY);
			base.setForeground(Color.WHITE);
			base.setCaretColor(Color.WHITE);
			for ( int i=0; i < allalbel.length; allalbel[i++].setForeground(Color.WHITE));
		} else {
			credit0.setForeground(Color.BLACK);
			credit1.setForeground(Color.BLACK);
			chooseal.setBackground(null);
			chooseal.setForeground(Color.BLACK);
			choosea2.setBackground(null);
			choosea2.setForeground(Color.BLACK);
			choosea3.setBackground(null);
			choosea3.setForeground(Color.BLACK);
			atmosphericNoise.setBackground(null);
			atmosphericNoise.setForeground(Color.BLACK);
			radioactivedecay.setBackground(null);
			radioactivedecay.setForeground(Color.BLACK);
			darkmode.setBackground(null);
			darkmode.setForeground(Color.BLACK);
			totalnumber.setBackground(Color.WHITE);
			totalnumber.setForeground(Color.BLACK);
			totalnumber.setCaretColor(Color.BLACK);
			min.setBackground(Color.WHITE);
			min.setForeground(Color.BLACK);
			min.setCaretColor(Color.BLACK);
			max.setBackground(Color.WHITE);
			max.setForeground(Color.BLACK);
			max.setCaretColor(Color.BLACK);
			base.setBackground(Color.WHITE);
			base.setForeground(Color.BLACK);
			base.setCaretColor(Color.BLACK);
			for ( int i=0; i < allalbel.length; allalbel[i++].setForeground(Color.BLACK));
		}
	}

	// yes or no option panel
	protected int foundDups(String op1[], String a, String b) {

		return JOptionPane.showOptionDialog(
				frame,
				a, 
				b,            
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				op1,  
				op1[0] 
				);
	}

	// if select atmosphere noise
	protected void atmosphericSelect() {
		chooseal.setVisible(true);
		choosea2.setVisible(true);
		choosea3.setVisible(true);
		allalbel[2].setVisible(true);
		max.setVisible(true);
		allalbel[1].setText("Min");
		min.setText("1");

	}

	//if select radioactive decay
	protected void radioactiveSelect() {
		chooseal.setVisible(false);
		choosea2.setVisible(false);
		choosea3.setVisible(false);
		allalbel[2].setVisible(false);
		allalbel[3].setVisible(false);
		max.setVisible(false);
		base.setVisible(false);
		for (int i=0; i< stringg.length; stringg[i++].setVisible(false));
		totalnumber.setVisible(true);
		min.setVisible(true);
		min.setText("APIKey Should be here");
		allalbel[1].setText("API key");
		allalbel[0].setText("Total Number");
		allalbel[1].setVisible(true);
		allalbel[0].setVisible(true);
	}

	// when choose native depiction
	protected void toggleNativeDepic() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		new Interface(isdark);
		frame.dispose();
	}

	// when choose java depiction
	protected void toggleJavaDepic() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		new Interface(isdark);
		frame.dispose();
	}

	// choose generate random number from atmospheric noise
	protected void choose1() {
		allalbel[0].setVisible(true);
		allalbel[3].setVisible(true);
		totalnumber.setVisible(true);
		base.setVisible(true);
	}
	protected void choose2() {
		allalbel[0].setVisible(false);
		allalbel[3].setVisible(false);
		totalnumber.setVisible(false);
		base.setVisible(false);
	}

	// choose generate sequences from atmospheric noise
	protected void choose1or2() {
		for (int i=0; i< stringg.length; stringg[i++].setVisible(false));
		allalbel[1].setVisible(true);
		allalbel[2].setText("Max");
		min.setVisible(true);
		base.setVisible(true);
		allalbel[3].setVisible(true);
		allalbel[0].setText("Total number");	
	}
	// choose generate string
	protected void choosechoose3() {
		for (int i=0; i< stringg.length; stringg[i++].setVisible(true));
		allalbel[2].setText("Length");
		min.setVisible(false);
		allalbel[1].setVisible(false);
		allalbel[0].setText("Total String");
		allalbel[0].setVisible(true);
		totalnumber.setVisible(true);

		allalbel[3].setVisible(false);
		base.setVisible(false);
	}

	//night mode for main screen
	protected void togglenight() {
		UIManager.put("OptionPane.background", Color.DARK_GRAY);
		UIManager.put("Panel.background", Color.DARK_GRAY);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		new Interface(true);
		frame.dispose();
	}
	//light mode for main screen
	protected void togglelight() {
		UIManager.put("OptionPane.background", null);
		UIManager.put("Panel.background", null);
		UIManager.put("OptionPane.messageForeground", Color.BLACK);
		new Interface(false);
		frame.dispose();
	}


}