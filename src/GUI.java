import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GUI {
	
	static JFrame frame;
	private JLabel lblYou;
	private JLabel lblMicheal;
	private JLabel lblJeero;
	private JLabel lblThePope;
	public static JButton btnSpin;
	Stats engine = new Stats();
	public static JLabel ThePlayerLabel;
	private JLabel lblYouSpunA;
	public static JLabel ThePlayer4Label;
	public static JLabel ThePlayer2Label;
	public static JLabel ThePlayer3Label;
	boolean one = true;
	boolean two = false;
	boolean three = false;
	public static int playerCount = 0;
	
	int i =0;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void start(){
	
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		
		
		frame.setBounds(0,0,900,818);
		
		
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		ThePlayerLabel = new JLabel("");
		ThePlayerLabel.setIcon(new ImageIcon(GUI.class.getResource("/Images/You-1-.png")));
		ThePlayerLabel.setBounds(10, 732, 80, 82);
		frame.getContentPane().add(ThePlayerLabel);
		
		ThePlayer2Label = new JLabel("");
		ThePlayer2Label.setIcon(new ImageIcon(GUI.class.getResource("/Images/Cheese.png")));
		ThePlayer2Label.setBounds(10, 732, 80, 80);
		frame.getContentPane().add(ThePlayer2Label);
		
		ThePlayer3Label = new JLabel("");
		ThePlayer3Label.setIcon(new ImageIcon(GUI.class.getResource("/Images/dirt_pile.gif")));
		ThePlayer3Label.setBounds(10, 732, 80, 80);
		frame.getContentPane().add(ThePlayer3Label);
		
		ThePlayer4Label = new JLabel("");
		ThePlayer4Label.setIcon(new ImageIcon(GUI.class.getResource("/Images/thepopi.png")));
		ThePlayer4Label.setBounds(10, 732, 80, 80);
		frame.getContentPane().add(ThePlayer4Label);
		
		
		
		
		
		JLabel contentPane_1 = new JLabel();
		contentPane_1.setBackground(Color.DARK_GRAY);
		contentPane_1.setBounds(0, 0, 900, 818);
	//	contentPane_1.setHorizontalAlignment(0);
		contentPane_1.setIcon(new ImageIcon(GUI.class.getResource("/Images/BackgroundCAL.gif")));
		contentPane_1.setLayout(new SpringLayout());
		frame.getContentPane().add(contentPane_1);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(828, 11, 46, 14);
		frame.getContentPane().add(lblPlayers);
		
		lblYou = new JLabel("You");
		lblYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblYou.setBounds(828, 51, 46, 14);
		frame.getContentPane().add(lblYou);
		
		lblMicheal = new JLabel("Cheese");
		lblMicheal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMicheal.setBounds(828, 111, 46, 14);
		frame.getContentPane().add(lblMicheal);
		
		lblJeero = new JLabel("Pile of dirt");
		lblJeero.setHorizontalAlignment(SwingConstants.CENTER);
		lblJeero.setBounds(828, 170, 46, 14);
		frame.getContentPane().add(lblJeero);
		
		lblThePope = new JLabel("The Pope");
		lblThePope.setBounds(828, 231, 46, 14);
		frame.getContentPane().add(lblThePope);
		
		btnSpin = new JButton("SPIN/AI");
		btnSpin.setBackground(new Color(255, 99, 71));
		btnSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i++;			
				playerCount = Opener.numberOfPlayers;
				
				if(i ==1){
					int x = (int) (Math.random()*playerCount);
							switch(x){
							case 0 : one = true;
								break;
							case 1: one = false; two = true; Stats.secondTime = true;Stats.firstTime = false; Stats.edited = true;
							break;
							case 2: one = false; two = false; three = true; Stats.thirdTime = true; Stats.firstTime = false; Stats.edited = true;
							break;
					
							
					}}
				
				
				
				
				
				System.out.println("Order: 1 physical click");
				btnSpin.setEnabled(false);
				
				if(playerCount ==1){
					playerRun(1);
				}
				
				
				else if(playerCount ==2){
					if(one){
						playerRun(1);
						one = false;
						
					}
					else{
						playerRun(2);
						one = true;
						

					}
				}
				else if(playerCount ==3){
					if(one){
						playerRun(1);
						one = false;
						two=true;}
					else if(two){
						playerRun(2);
						one = false;
						two = false;
					}else{
						playerRun(3);
						one = true;
					}
				
				}
				else if(playerCount ==4){
					if(one){
						playerRun(1);
						one = false;
						two=true;}
					else if(two){
						playerRun(2);
						one = false;
						two = false;
						three = true;
					}else if(three){
						playerRun(3);
						three = false;
					}else{
						playerRun(4);
						one = true;
					}
				}
				//playerRun(2);
				
				//playerRun(2);
				
				
				//playerRun(3);
				//playerRun(4);
			}
		});
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(805, 791, 95, 23);
		frame.getContentPane().add(btnNewButton);
		btnSpin.setBounds(805, 665, 95, 115);
		frame.getContentPane().add(btnSpin);
		
		lblYouSpunA = new JLabel("You spun a :");
		lblYouSpunA.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouSpunA.setBounds(805, 598, 95, 94);
		frame.getContentPane().add(lblYouSpunA);
		//frame.setBackground(new ImageIcon(GUIXlass.class.getResource("/Images/BACKGROUND.png")));
		
		
		
		switch(Opener.numberOfPlayers){
		case 1: lblMicheal.setVisible(false);
		        lblJeero.setVisible(false);
		        lblThePope.setVisible(false);
		        ThePlayer2Label.setVisible(false);
		        ThePlayer3Label.setVisible(false);
		        ThePlayer4Label.setVisible(false);
		break;
		case 2: lblJeero.setVisible(false); 
				lblThePope.setVisible(false);
				ThePlayer3Label.setVisible(false);
				ThePlayer4Label.setVisible(false);
	    break;
		case 3: lblThePope.setVisible(false);
				ThePlayer4Label.setVisible(false);
		break;
		
		
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
	
	}
	
	
	public void playerRunCaller(int player){
		playerRun(player);
		System.out.println("NEXT PLAYER ATTEMPTING TO GO");
	}
	
	public void playerRun(int player){

		System.out.println("CLICKED.......PLAYER NOW STARTING");
		int movement = engine.spin();
		if(player==1)
		lblYouSpunA.setText("You spun a : " +  movement);
		
		engine.move(movement, player);
	}
}
