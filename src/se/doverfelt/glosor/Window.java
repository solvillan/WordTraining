package se.doverfelt.glosor;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.monitor.Monitor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int progress = 0;
	private int i = 1;
	private int progress2 = 0;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	/**
	 * @param args
	 * @throws IOException 
	 */

	public Window(String wordsRaw) {
		super("Glosträning");
		
		setBounds(toolkit.getScreenSize().width / 3, toolkit.getScreenSize().height / 3, 465, 240);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		final String[] words = wordsRaw.split(";");
		final int amount = (words.length / 2) * 10;
		
		final JLabel lblNewLabel = new JLabel("");
		final JLabel lblNewLabel_1 = new JLabel("");
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (i <= words.length) {
					if (arg0.getActionCommand().equalsIgnoreCase(words[i])) {
						lblNewLabel_1.setText("Correct!");
						score++;
					} else {
						lblNewLabel_1.setText("Incorrect, correct word is " + words[i] + ".");
					}
					if (words.length > i + 1) {
						lblNewLabel.setText(words[i + 1]);
					} else {
						lblNewLabel.setText(score + " correct words out of " + (words.length / 2) + ".");
						textField.setEditable(false);
						System.exit(0);
					}
					i += 2;
					
					System.out.println(arg0.getActionCommand());
					progress += 10;
					textField.setText("");
				}
			}
		});
		textField.setBounds(38, 177, 406, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(6, 6, 20, 199);
		progressBar.setMaximum(amount);
		getContentPane().add(progressBar);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(38, 51, 406, 16);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText(words[0]);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(38, 115, 406, 16);
		getContentPane().add(lblNewLabel_1);
		
		setVisible(true);
		
		while (true) {
			
			if (progress2 < progress) {
				progressBar.setValue(progress2);
				progress2++;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				progressBar.setValue(progress2);
			}
		}
		
		
		
	}
	
	private static int score = 0;
	private final JTextField textField;
	
}
