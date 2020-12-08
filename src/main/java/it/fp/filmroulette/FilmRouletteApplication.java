package it.fp.filmroulette;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class FilmRouletteApplication {

	public static final int TIMER_DELAY = 1000;
	public static final String TEST_TEXT = "12345";
	private int counter = 1;
	private Random rand = new Random();
	private Timer timer;

	public FilmRouletteApplication() {
		createAndShowGui();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(FilmRouletteApplication::new);
	}

	public void createAndShowGui() {

		JFrame frame = new JFrame("Film roulette");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField textField = new JTextField(16);
		JButton button = new JButton("Il film che vedrete sarà...");
		button.setMnemonic(KeyEvent.VK_P);
		JPanel filmRoulettePanel = new JPanel();
		JTextField t1Text = new JTextField();
		JTextField t2Text = new JTextField();
		JTextField t3Text = new JTextField();
		JTextField t4Text = new JTextField();
		JLabel f1Label = new JLabel("Filippo film 1");
		JLabel f2Label = new JLabel("Filippo film 2");
		JLabel l1Label = new JLabel("Laura film 1");
		JLabel l2Label = new JLabel("Laura film 2");
		JLabel show_image = new JLabel("");
		ImageIcon img = new ImageIcon(
				"C:\\Users\\picci\\Documents\\spring-tool-suite-workspace\\film-3\\src\\main\\resources\\static\\roulette_PNG26.png");
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer != null && timer.isRunning()) {
					return;
				}
				
				List<String> givenList = Arrays.asList(t1Text.getText(), t2Text.getText(), t3Text.getText(), t4Text.getText());
			
				textField.setText("");
                counter = 0;
                
                timer = new Timer(TIMER_DELAY, (ActionEvent ev) -> {
                    if (counter >= TEST_TEXT.length()) {
                        ((Timer) ev.getSource()).stop();
                        String randomElement = givenList.get(rand.nextInt(givenList.size()));
                        textField.setText(randomElement);
                    } else {
                        textField.setText(textField.getText() + TEST_TEXT.charAt(counter));
                        counter++;
                    }
			});
                timer.start();
		}
				
			});
		filmRoulettePanel.add(button);
		filmRoulettePanel.add(textField);
		show_image.setIcon(new ImageIcon(
				"C:\\Users\\picci\\Documents\\spring-tool-suite-workspace\\film-3\\src\\main\\resources\\static\\roulette_PNG26.png"));
		frame.add(filmRoulettePanel);
		frame.setIconImage(img.getImage());
		frame.setLayout(new GridLayout(11, 4));
		frame.add(show_image);
		frame.add(show_image);
		frame.add(f1Label);
		frame.add(t1Text);
		frame.add(f2Label);
		frame.add(t2Text);
		frame.add(l1Label);
		frame.add(t3Text);
		frame.add(l2Label);
		frame.add(t4Text);
		frame.setLocationByPlatform(true);
		
		frame.pack();
		frame.setVisible(true);
	}
}
