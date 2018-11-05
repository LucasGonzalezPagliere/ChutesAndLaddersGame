import javax.swing.JOptionPane;


public class MovementThread4 implements Runnable{

	static public boolean move1 =  false;
	static public boolean move2 =  false;
	static public boolean move3 =  false;
	static public boolean move4 =  false;
	static boolean firstTime1 = true;
	int movesLeft;
	

	static public int pos4=1;
	static public boolean move = false;
	Stats Check = new Stats();
	GUI next = new GUI();
	public static int nextPlayer = 0;
	public static boolean pipi = true;
	//boolean oppo = true;
	boolean loop = true;
	
	@Override
	public void run() {
		
///////////////////////////////////TO MOVE PLAYER 4//////////////////////////////////////////////////////////////////////////////////
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
while(move4){
if(firstTime1){
movesLeft = Stats.numMoves;
firstTime1 = false;
}



if(pos4<=Stats.player4-1){
pos4++;
System.out.println("4.One added to pos, it is now: "+pos4);
}

if(pos4>98){
	JOptionPane.showMessageDialog(null, "The pope beat you. What can I say? He had god on his side...");
	move4 = false;
	GUI.frame.dispose();
}
//oppo = false;

System.out.println("MOVING PLAYER 4, MOVES LEFT: " + movesLeft);

//int pos = Stats.player1;



if(pos4 == 10 || pos4 == 20 || pos4 == 30 || pos4 == 40|| pos4 == 50|| pos4 == 60|| pos4 == 70|| pos4 == 80 || pos4 == 90){
//MOVE THE JLABEL UP
System.out.println("4.MOVED UP");
GUI.ThePlayer4Label.setLocation(GUI.ThePlayer4Label.getLocation().x , GUI.ThePlayer4Label.getLocation().y-80);
movesLeft--;

}
else if(pos4 <10 || (pos4 <30 && pos4 >20) || (pos4>40 && pos4 <50) || (pos4 > 60 && pos4 <70) || (pos4>80 && pos4<90)){
//MOVE THE JLABEL TO THE RIGHT

System.out.println("4.MOVED RIGHT");

GUI.ThePlayer4Label.setLocation(GUI.ThePlayer4Label.getLocation().x +80, GUI.ThePlayer4Label.getLocation().y);

movesLeft--;

}
else{
//MOVE THE JLABEL TO THE LEFT
System.out.println("4.MOVED LEFT");
GUI.ThePlayer4Label.setLocation(GUI.ThePlayer4Label.getLocation().x -80 , GUI.ThePlayer4Label.getLocation().y);
movesLeft--;

}

try {
Thread.sleep(100);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

if(movesLeft ==0){
System.out.println("////////////////////////////4.FINISHED......CHECKING FOR POS #: " + pos4+ " //////////////////////////////");
Check.checkForSpecial(pos4+1, 4);
move = false;

move4 = false;
//oppo = true;
//nextPlayer = 3;
//BonusThread.done=true;
//pipi =false;
GUI.btnSpin.setEnabled(true);

Stats.Mover4.suspend();
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




//}



		
	}}


