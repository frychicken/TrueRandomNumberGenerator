import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import xyz.null0verflow.librandomorgclient.GenerateTrueRandom;

public class Interface extends Component  implements ActionListener{
	private boolean stopc = true;
	private int minimum;
	private int maximum;
	private int baseofnum;
	private int total;
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
	GenerateTrueRandom gtr = new GenerateTrueRandom("bobdinh139@icloud.com");
	JLabel credit0 = new JLabel("TRUE random generator by measuring amospheric noise");
	JLabel credit1 = new JLabel("by @frychicken with special thanks to random.org API ");
	JLabel credit = new JLabel("Powered by librandom.org-client (written by @frychicken)");
	
	JLabel betaalert = new JLabel("Currently in Beta, only random integer works");

	JButton idontunderstand = new JButton("I don't understand");
	
	JRadioButton chooseal = new JRadioButton("Random integer");
	JRadioButton choosea2 = new JRadioButton("Random sequence");
	JRadioButton choosea3 = new JRadioButton("Random string");

	JButton button = new JButton("Generate TRUE random number");
	ButtonGroup bg;
	JLabel show ;

	public void execute() {
		frame = new JFrame("Try your luck tuesday");
		bg = new ButtonGroup(); 
		panel = new JPanel();
		allalbel[0] = new JLabel("Total number");
		allalbel[1] = new JLabel("Min");
		allalbel[2] = new JLabel("Max");
		allalbel[3] = new JLabel("Base");

		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Hi.png")));

		show = new JLabel(icon);


		totalnumber = new JTextField("5");
		min = new JTextField("1");
		max = new JTextField("20");
		base = new JTextField("10");
		panel.setLayout(null);

		int y = 120;
		for (int i=0; i< allalbel.length; allalbel[i++].setBounds(460, y+=30, 100, 25));

		show.setBounds(10, 100, 1000, 1000);
		idontunderstand.setBounds(550, 150, 200,30);
		credit0.setBounds(160, 20, 500, 35);
		credit1.setBounds(220, 60, 400, 25);
		credit.setBounds(220, 80, 400, 25);

		credit0.setFont(new Font("Serif", Font.BOLD, 20));
		credit1.setFont(new Font("Serif", Font.ITALIC, 15));
		credit.setForeground(Color.red);

		betaalert.setBounds(540, 200, 400, 25);
		betaalert.setForeground(Color.BLUE);

		totalnumber.setBounds(250, 150, 200, 25);
		min.setBounds(250, 180, 200, 25);
		max.setBounds(250, 210, 200, 25);
		base.setBounds(250, 240, 200, 25);

		chooseal.setBounds(50, 150, 150, 25);
		choosea2.setBounds(50, 180, 150, 25);
		choosea3.setBounds(50, 210, 150, 25);

		bg.add(chooseal);
		bg.add(choosea2);
		bg.add(choosea3);
		button.setBounds(200, 600, 400, 100);
		button.addActionListener(this);
		idontunderstand.addActionListener(this);
		chooseal.setSelected(true);
		frame.setResizable(false);
		frame.setSize(800, 800); 
		frame.setFocusable(true); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.add(chooseal);
		panel.add(choosea2);
		panel.add(choosea3);
		for (int i=0; i< allalbel.length; panel.add(allalbel[i++]));

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
		frame.add(panel);
		frame.setVisible(true); 
	}
	public void changecolor() {
		button.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		button.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if (s.equals("Generate TRUE random number"))	{
			minimum = Integer.valueOf(min.getText());
			maximum = Integer.valueOf(max.getText());
			total = Integer.valueOf(totalnumber.getText());
			baseofnum = Integer.valueOf(base.getText());

			generateRand(total, minimum, maximum, baseofnum);
		}
		if (s.equals("I don't understand")) {
			new Help().showHelp();
		}

	}

	private void printingNumber(String rannum) {
		if (cc>0)
			for (int i=0; i< albel.length; panel.remove(albel[i++]));
		cc++;
		albel = new JLabel[gtr.getArrayList().size()];
		for (int i=0; i< albel.length; albel[i++] = new JLabel());

		for (int i=0; i< albel.length; albel[i++].setFont(new Font("Serif", Font.BOLD, 60)));

		for(int i=0; i < gtr.getArrayList().size(); i++ ){
			albel[i].setText(gtr.getArrayList().get(i));
		} 


		new Thread(new Runnable() {
			public void run() {
				for (int i=0; i< albel.length; i++) {
					albel[i].setForeground(Color.GREEN);
					panel.add(albel[i]);
					for (int j =0; j< Integer.valueOf(gtr.getArrayList().get(i)); j++) {
						try {
							Thread.sleep(30);
							albel[i].setText(Integer.toString(j));
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();


		int f = -50;
		for (int i=0; i< albel.length; albel[i++].setBounds(f+=150, 400, 100,60));
	}

	private void generateRand(int total, int minimum, int maximum, int baseofnum) {
		stopc = true;
		button.setText("Retrieving TRUE random number from server"); 
		new Thread(new Runnable() {
			public void run() {
				while (stopc) {
					try {
						changecolor();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				String quota = gtr.QuotaCheck();
				betaalert.setText("status code: " + Integer.toString(gtr.getStatusCode()) + " Quota: " + quota);	
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {

				String rannum = "";
				if (chooseal.isSelected())
					rannum = gtr.getRandomNumber(total, minimum, maximum, baseofnum);
				else if (choosea2.isSelected())
					rannum = gtr.sequenceRandomGenerator(minimum, maximum);
				else 
					rannum = gtr.randomStringGenrator(total, maximum-minimum, true, true, true, true);

				printingNumber(rannum);
				button.setText("Done");
				stopc = false;
				button.setBackground(Color.BLACK);
				button.setForeground(Color.WHITE);
                
				try {

					for (int i=10; i >0; i--) {
						Thread.sleep(1000);
						button.setText("Wait for " +i+" second(s) ...");
						Thread.sleep(900);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				button.setBackground(null);
				button.setForeground(null);
				button.setText("Generate TRUE random number");
				
			}

		}).start();
	}
}

