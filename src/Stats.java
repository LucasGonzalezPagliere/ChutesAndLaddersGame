
public class Stats {
	
	
	
	public int[] moveUP =   {4,9,21,28,36,51,71,80};
	public int[] moveDOWN = {16,47,49,56,62,64,87,93,95,98};

	//MovementThread Move = new MovementThread();
	public static Thread Mover = new Thread( new MovementThread());
	public static Thread Mover2 = new Thread( new MovementThread2());
	public static Thread Mover3 = new Thread( new MovementThread3());
	public static Thread Mover4 = new Thread( new MovementThread4());
	
	public static Thread Bonus = new Thread(new BonusThread());
	
	static boolean firstTime=true;
	static boolean secondTime = false;
	static boolean thirdTime = false;
	static boolean fourthTime = false;
	//private boolean firstTime2=true;
	public static int rPlayer;
	public static int moveX=0;
	public static int moveY=0;
	static boolean edited = false;
	
	public static int player1 =0;
	public static int player2=0;
	public static int player3=0;
	public static int player4=0;
	
	public static int numMoves;
	int i =0;
	//spins the die
	public Stats(){
		
	}
	
	public int spin(){
		
		i++;
		return (int) (6*Math.random()+1);
		//return 100;
		
		
	}
	
	
	
	
	public void move(int num, int player){
		
		//i++;
		 rPlayer = player;
		
		System.out.println("FALSE MEANS RESUME: " +firstTime);
		
		
		
		
		if(firstTime){
			System.out.println("Threads.started");
			Mover.start();
			edited = false;
			firstTime = false;
			MovementThread.pipi = true;
			if(GUI.playerCount>1 && !Mover2.isAlive())
				secondTime = true;
		
		}
		
		else if(secondTime){
			Mover2.start();
			
			secondTime = false;
			if(GUI.playerCount>2&& !Mover3.isAlive())
				thirdTime = true;
			else if(edited){
				firstTime = true; 
		}}
		else if(thirdTime){
			Mover3.start();
			
			thirdTime = false;
			if(GUI.playerCount>3 && !Mover4.isAlive())
				fourthTime = true;
			else if(edited){
				firstTime = true;
			
		}}
		else if(fourthTime){
			Mover4.start();
			
			fourthTime = false;
			
			if(edited && !Mover.isAlive()){
				firstTime = true;
			}
		}
		
		
		
		else{
			System.out.println("ATTEMPTING to Resume");
			System.out.println("Mover 1 State: " + Mover.getState());
			System.out.println("Mover 2 State: " + Mover2.getState());
			System.out.println("Mover 3 State: " + Mover3.getState());
			System.out.println("Mover 4 State: " + Mover4.getState());

			//if(!Mover2.isAlive())
			//Mover.start();

			Mover.resume();
			Mover2.resume();
			Mover3.resume();
			Mover4.resume();

			//Mover.run();
			//Mover.notify();
			//MovementThread.pipi = true;
			}
		
		
		//Mover.resume();
		
		System.out.println("Number being moved: " + num);
		System.out.println("Player being moved: " +player);
		
		
		
		//'player' BELOW IS NUM 1-4 THAT REFERS TO WHAT PLAYER IS BEING MOVED
		switch(player){
		
		case 1: player1 += num;
		
		numMoves = num;
		MovementThread.loop = true;
		MovementThread.move = true;
		MovementThread.move1 = true;
		

		break;
		
		case 2: player2 += num;

		numMoves = num;
		
		MovementThread2.loop = true;
		MovementThread2.move = true;

		MovementThread2.move2 = true;	 

		
		break;
		
		case 3: player3 += num;

		numMoves = num;
		MovementThread2.loop = true;
		MovementThread3.move = true;

		MovementThread3.move3 = true;		
		
		break;
		
		case 4: player4 += num;
		

		numMoves = num;
		MovementThread2.loop = true;
		MovementThread4.move = true;

		MovementThread4.move4 = true;
		
		break;
		}
		
		
		
		
		
	}
	
	
	
	//CHECKS IF JLABEL LANDS ON A BOOST TILE
	public void checkForSpecial(int pos,int player){
		
		
		
		for(int i =0;i<moveUP.length; i++){
			if(pos == moveUP[i]){
				System.out.println("BonusCalled");
				bonus(i+1,player);
				i=moveUP.length;}
		
		}
		for(int i =0;i<moveDOWN.length; i++){
			if(pos == moveDOWN[i]){
				System.out.println("UnBonusCalled");
				unbonus(i+1,player);
			i=moveDOWN.length;}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public void bonus(int whichOne, int player){
		//MOVE UP BASED ON BOOST
		System.out.println("Bonus beginning, the bonus # is: "+whichOne);
		switch(whichOne){
		case 1:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(494,654);
	    		player1 = 13;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(494,654);
	    		player2 = 13;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(494,654);
	    		player3 = 13;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(494,654);
	    		player4 = 13;
	    		MovementThread4.pos4 = player4;
	    	}
		
		
		   break;
		case 2:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(722,496);
	    		player1 = 30;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(722,496);
	    		player2 = 30;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(722,496);
	    		player3 = 30;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(722,496);
	    		player4 = 30;
	    		MovementThread4.pos4 = player4;
	    	}
		
		
			break;
		case 3:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(94,417);
	    		player1 = 41;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(94,417);
	    		player2 = 41;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(94,417);
	    		player3 = 41;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(94,417);
	    		player4 = 41;
	    		MovementThread4.pos4 = player4;
	    	}
		
			break;
		case 4:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(256,96);
	    		player1 = 83;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(256,96);
	    		player2 = 83;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(256,96);
	    		player3 = 83;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(256,96);
	    		player4 = 83;
	    		MovementThread4.pos4 = player4;
	    	}
		
			break;
			
			
			
		case 5:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(255,417);
	    		player1 = 43;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(255,417);
	    		player2 = 43;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(255,417);
	    		player3 = 43;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(255,417);
	    		player4 = 43;
	    		MovementThread4.pos4 = player4;
	    	}
		
			break;
		case 6:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(496,256);
	    		player1 = 66;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(496,256);
	    		player2 = 66;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(496,256);
	    		player3 = 66;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(496,256);
	    		player4 = 66;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
			
		case 7:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(724,12);
	    		player1 = 90;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(724,12);
	    		player2 = 90;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(724,12);
	    		player3 = 90;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(724,12);
	    		player4 = 90;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 8:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(8,8);
	    		player1 = 100;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(8,8);
	    		player2 = 100;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(8,8);
	    		player3 = 100;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(8,8);
	    		player4 = 100;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		
			
			
		}
		
	}
	public void unbonus(int whichOne, int player){
		//MOVE DOWN BASED ON UNBOOST
		switch(whichOne){
	    case 1:
	    	if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(415,730);
	    		player1 = 5;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(415,730);
	    		player2 = 5;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(415,730);
	    		player3 = 5;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(415,730);
	    		player4 = 5;
	    		MovementThread4.pos4 = player4;
	    	}
		   break;
		case 2:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(412,573);
	    		player1 = 25;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(412,573);
	    		player2 = 25;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(412,573);
	    		player3 = 25;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(412,573);
	    		player4 = 25;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 3:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(723,654);
	    		player1 = 10;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(723,654);
	    		player2 = 10;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(723,654);
	    		player3 = 10;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(723,654);
	    		player4 = 10;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 4:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(567,333);
	    		player1 = 52;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(567,333);
	    		player2 = 52;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(567,333);
	    		player3 = 52;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(567,333);
	    		player4 = 52;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 5:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(92,652);
	    		player1 = 18;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(92,652);
	    		player2 = 18;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(92,652);
	    		player3 = 18;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(92,652);
	    		player4 = 18;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 6:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(6,338);
	    		player1 = 59;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(6,338);
	    		player2 = 59;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(6,338);
	    		player3 = 59;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(6,338);
	    		player4 = 59;
	    		MovementThread4.pos4 = player4;
	    	}
			
			break;
		case 7:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(254,576);
	    		player1 = 23;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(254,576);
	    		player2 = 23;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(254,576);
	    		player3 = 23;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(254,576);
	    		player4 = 23;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 8:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(572,178);
	    		player1 = 72;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(572,178);
	    		player2 = 72;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(572,178);
	    		player3 = 72;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(572,178);
	    		player4 = 72;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 9:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(416,178);
	    		player1 = 74;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(416,178);
	    		player2 = 74;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(416,178);
	    		player3 = 74;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(416,178);
	    		player4 = 74;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
		case 10:
			if(player ==1){
	    		GUI.ThePlayerLabel.setLocation(174,178);
	    		player1 = 77;
	    		MovementThread.pos = player1;
	    	}
	    	else if(player == 2){
	    		GUI.ThePlayer2Label.setLocation(174,178);
	    		player2 = 77;
	    		MovementThread2.pos2 = player2;
	    	}
	    	else if(player ==3){
	    		GUI.ThePlayer3Label.setLocation(174,178);
	    		player3 = 77;
	    		MovementThread3.pos3 = player3;
	    	}
	    	else if(player ==4){
	    		GUI.ThePlayer4Label.setLocation(174,178);
	    		player4 = 77;
	    		MovementThread4.pos4 = player4;
	    	}
			break;
	
			
			
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
