import javax.swing.JOptionPane;


public class MovementThread implements Runnable {

	
	int player1;
	
	static public boolean move1 =  false;
	static public boolean move2 =  false;
	static public boolean move3 =  false;
	static public boolean move4 =  false;
	static boolean firstTime1 = true;
	int movesLeft;
	static public int pos=1;
	
	static public boolean move = false;
	Stats Check = new Stats();
	GUI next = new GUI();
	public static int nextPlayer = 0;
	public static boolean pipi = true;
	//boolean oppo = true;
	public static boolean loop = true;
	static int i =0;
	
	@Override
	public void run() {

			i++;
		//for(int i = (int) System.currentTimeMillis(); i<System.currentTimeMillis()+10; i++){
		
		
///////////////////////////////////TO MOVE PLAYER 1//////////////////////////////////////////////////////////////////////////////////
		
		
		
	try {
		Thread.sleep(10);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		
		//System.out.println("HEEEEEERRRRRRREEEEEEEE: " + move1);
		while(loop){
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/try {
			Thread.sleep(10);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			
		
		while(move1){
			
			if(firstTime1){
				movesLeft = Stats.numMoves;
				firstTime1 = false;
			}
			
			
			
			if(pos<=Stats.player1-1){
				pos++;
				System.out.println("One added to pos, it is now: "+pos);
				
			}
				
			
			
			
			if(pos>98){
				JOptionPane.showMessageDialog(null, "Congrats. You won!!!");
				move1 = false;
				GUI.frame.dispose();
			}
			
			//oppo = false;
			
			System.out.println("MOVING PLAYER 1, MOVES LEFT: " + movesLeft);
			
			//int pos = Stats.player1;
		
		
		
		if(pos == 10 || pos == 20 || pos == 30 || pos == 40|| pos == 50|| pos == 60|| pos == 70|| pos == 80 || pos == 90){
				//MOVE THE JLABEL UP
			    System.out.println("MOVED UP");
				GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x , GUI.ThePlayerLabel.getLocation().y-80);
				movesLeft--;
				
			}
			else if(pos <10 || (pos <30 && pos >20) || (pos>40 && pos <50) || (pos > 60 && pos <70) || (pos>80 && pos<90)){
			//MOVE THE JLABEL TO THE RIGHT
			
				 System.out.println("MOVED RIGHT");
			
			GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x +80, GUI.ThePlayerLabel.getLocation().y);
			
			movesLeft--;
			
		}
		else{
			//MOVE THE JLABEL TO THE LEFT
			 System.out.println("MOVED LEFT");
			GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x -80 , GUI.ThePlayerLabel.getLocation().y);
			movesLeft--;
			
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(movesLeft ==0){
			System.out.println("////////////////////////////FINISHED......CHECKING FOR POS #: " + pos+ " //////////////////////////////");
			
			Check.checkForSpecial(pos+1, 1);
			move = false;
        	move1 = false;
        	GUI.btnSpin.setEnabled(true);

        	//oppo = true;
        	
        	if(GUI.playerCount>1){
        	//BonusThread.done=true;
        	nextPlayer = 2;
        	firstTime1 = true;
        	//BonusThread.done = true;
        	//Stats.Mover.suspend();
        	//next.playerRunCaller(nextPlayer);
        	}else{
        		pipi =false;
        		
        		
        		//System.out.println("NOTICE: Thread suspended from MovementThread");

        	//Stats.Mover.suspend();
        	}Stats.Mover.suspend();
        	//Stats.Mover2.suspend();
        	firstTime1 = true;
        	
        	
        	
        }
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//System.out.println("LOOOOP FALSIFYING");
		if(i ==1)
		loop = false;
	}}


}
