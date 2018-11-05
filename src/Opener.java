import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Opener {
	
	JFrame frame;
	private JSpinner spinner;
	private JComboBox comboBox;
	
	public static int numberOfPlayers;
	private JButton btnNewButton;
	
	GUI obj;
	
	
	
	public Opener(){
		frame = new JFrame();
		
		
		frame.setBounds(500,500,407,285);
		frame.getContentPane().setLayout(null);
		
		obj=new GUI();		
		
		try {
			UIManager.setLookAndFeel(  UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblChutesLadders = new JLabel("Chutes & Ladders!");
		lblChutesLadders.setFont(new Font("Roller World BTN Bold Out", Font.BOLD, 36));
		lblChutesLadders.setHorizontalAlignment(SwingConstants.CENTER);
		lblChutesLadders.setBounds(10, 21, 386, 45);
		frame.getContentPane().add(lblChutesLadders);
		
		btnNewButton = new JButton("Start!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfPlayers = (int) spinner.getValue();
				frame.dispose();
				obj.start();
			}
		});
		btnNewButton.setBounds(148, 212, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players:");
		lblNumberOfPlayers.setBounds(23, 114, 97, 14);
		frame.getContentPane().add(lblNumberOfPlayers);
		
		JLabel lblDifficulty = new JLabel("Difficulty: ");
		lblDifficulty.setBounds(23, 146, 64, 14);
		frame.getContentPane().add(lblDifficulty);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner.setBounds(130, 111, 29, 20);
		frame.getContentPane().add(spinner);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboBox.setBounds(130, 143, 79, 20);
		frame.getContentPane().add(comboBox);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setVisible(true);
	}
}
