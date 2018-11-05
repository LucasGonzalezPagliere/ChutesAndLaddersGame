import javax.swing.JOptionPane;


public class MovementThread2 implements Runnable {

int player1;
	
	static public boolean move1 =  false;
	static public boolean move2 =  false;
	static public boolean move3 =  false;
	static public boolean move4 =  false;
	static boolean firstTime1 = true;
	int movesLeft;

	static public int pos2=1;
	
	static public boolean move = false;
	Stats Check = new Stats();
	GUI next = new GUI();
	public static int nextPlayer = 0;
	public static boolean pipi = true;
	//boolean oppo = true;
	static boolean loop = true;
	
	
	
	@Override
	public void run(){
		System.out.println("Thread 2 Activated");
///////////////////////////////////TO MOVE PLAYER 2//////////////////////////////////////////////////////////////////////////////////
try {
Thread.sleep(10);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}



//System.out.println(move1);
while(loop){
	try {
		Thread.sleep(10);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
while(move2){
	System.out.println("HERE: "+firstTime1);
if(firstTime1){
movesLeft = Stats.numMoves;
firstTime1 = false;
}



if(pos2<=Stats.player2-1){
pos2++;
System.out.println("2.One added to pos, it is now: "+pos2);

}



if(pos2>98){
	JOptionPane.showMessageDialog(null, "Nice. A damn peice of cheese beat you smh.");
	move2=false;
	GUI.frame.dispose();
	
}




//oppo = false;

System.out.println("MOVING PLAYER 2, MOVES LEFT: " + movesLeft);

//int pos = Stats.player1;



if(pos2 == 10 || pos2 == 20 || pos2 == 30 || pos2 == 40|| pos2 == 50|| pos2 == 60|| pos2 == 70|| pos2 == 80 || pos2 == 90){
//MOVE THE JLABEL UP
System.out.println("2.MOVED UP");
GUI.ThePlayer2Label.setLocation(GUI.ThePlayer2Label.getLocation().x , GUI.ThePlayer2Label.getLocation().y-80);
movesLeft--;

}
else if(pos2 <10 || (pos2 <30 && pos2 >20) || (pos2>40 && pos2 <50) || (pos2 > 60 && pos2 <70) || (pos2>80 && pos2<90)){
//MOVE THE JLABEL TO THE RIGHT

System.out.println("2.MOVED RIGHT");

GUI.ThePlayer2Label.setLocation(GUI.ThePlayer2Label.getLocation().x +80, GUI.ThePlayer2Label.getLocation().y);

movesLeft--;

}
else{
//MOVE THE JLABEL TO THE LEFT
System.out.println("2.MOVED LEFT");
GUI.ThePlayer2Label.setLocation(GUI.ThePlayer2Label.getLocation().x -80 , GUI.ThePlayer2Label.getLocation().y);
movesLeft--;

}

try {
Thread.sleep(100);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

if(movesLeft ==0){
System.out.println("////////////////////////////2.FINISHED......CHECKING FOR POS #: " + pos2+ " //////////////////////////////");
Check.checkForSpecial(pos2+1, 2);
move = false;

move2 = false;
GUI.btnSpin.setEnabled(true);

//oppo = true;
if(GUI.playerCount>2){

	nextPlayer = 3;
	


	firstTime1 = true;
	//Stats.Mover2.suspend();
	//next.playerRunCaller(nextPlayer);
}
//BonusThread.done=true;}

//System.out.println("NOTICE: Thread suspended from MovementThread");
//	pipi =false;
Stats.Mover2.suspend();
firstTime1 = true;}




try {
Thread.sleep(800);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}
//System.out.println("SECOND LOOOP FALSIFYING");
//loop = false;

	}
	
	}
	}
