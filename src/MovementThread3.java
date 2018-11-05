import javax.swing.JOptionPane;


public class MovementThread3 implements Runnable {


	static public boolean move1 =  false;
	static public boolean move2 =  false;
	static public boolean move3 =  false;
	static public boolean move4 =  false;
	static boolean firstTime1 = true;
	int movesLeft;
	
	static public int pos3=1;

	
	static public boolean move = false;
	Stats Check = new Stats();
	GUI next = new GUI();
	public static int nextPlayer = 0;
	public static boolean pipi = true;
	//boolean oppo = true;
	boolean loop = true;
	
	
	
	
	@Override
	public void run() {
///////////////////////////////////TO MOVE PLAYER 3//////////////////////////////////////////////////////////////////////////////////
		
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
while(move3){
if(firstTime1){
movesLeft = Stats.numMoves;
firstTime1 = false;
}



if(pos3<=Stats.player3-1){
pos3++;
System.out.println("3.One added to pos, it is now: "+pos3);
}



if(pos3>98){
	JOptionPane.showMessageDialog(null, "Couldn't even beat a pile of mung how disappointing.....");
	move3=false;
	GUI.frame.dispose();
	
}
//oppo = false;

System.out.println("MOVING PLAYER 3, MOVES LEFT: " + movesLeft);

//int pos = Stats.player1;



if(pos3 == 10 || pos3 == 20 || pos3 == 30 || pos3 == 40|| pos3 == 50|| pos3 == 60|| pos3 == 70|| pos3 == 80 || pos3 == 90){
//MOVE THE JLABEL UP
System.out.println("3.MOVED UP");
GUI.ThePlayer3Label.setLocation(GUI.ThePlayer3Label.getLocation().x , GUI.ThePlayer3Label.getLocation().y-80);
movesLeft--;

}
else if(pos3 <10 || (pos3 <30 && pos3 >20) || (pos3>40 && pos3 <50) || (pos3 > 60 && pos3 <70) || (pos3>80 && pos3<90)){
//MOVE THE JLABEL TO THE RIGHT

System.out.println("3.MOVED RIGHT");

GUI.ThePlayer3Label.setLocation(GUI.ThePlayer3Label.getLocation().x +80, GUI.ThePlayer3Label.getLocation().y);

movesLeft--;

}
else{
//MOVE THE JLABEL TO THE LEFT
System.out.println("3.MOVED LEFT");
GUI.ThePlayer3Label.setLocation(GUI.ThePlayer3Label.getLocation().x -80 , GUI.ThePlayer3Label.getLocation().y);
movesLeft--;

}

try {
Thread.sleep(100);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

if(movesLeft ==0){
System.out.println("////////////////////////////3.FINISHED......CHECKING FOR POS #: " + pos3+ " //////////////////////////////");
Check.checkForSpecial(pos3+1, 3);
move = false;

move3 = false;
GUI.btnSpin.setEnabled(true);

//oppo = true;
if(GUI.playerCount>3){
nextPlayer = 4;
//Check.move(Check.spin(), nextPlayer);
firstTime1 = true;}
//BonusThread.done=true;}
else{pipi =false;}
Stats.Mover3.suspend();
firstTime1 = true;
}




try {
Thread.sleep(800);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


}
//System.out.println("THIRD LOOOP FALSIFYING");

//loop = false;
	}

	}

	}


