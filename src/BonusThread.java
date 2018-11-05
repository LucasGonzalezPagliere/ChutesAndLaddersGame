
public class BonusThread implements Runnable {

	static public boolean done = false;
	int movedX=0;
	GUI run = new GUI();
	
	int movedY=0;
	
	@Override
	public void run() {
		while(true){

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(done){
    		//System.out.println("NOTICE: Thread suspended from BonusThread");

			//Stats.Mover.suspend();
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			run.playerRunCaller(MovementThread.nextPlayer);
			
			
			
			
			
			
			
			
			
			
			
			done = false;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*
			if(Stats.moveX >=0){

				if(Stats.moveX>movedX){
					movedX+=10;
					GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x+10,GUI.ThePlayerLabel.getLocation().y);
				}//else{=0;
					
				
				if(Stats.moveY>movedY){
					movedY+=10;
					GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x,GUI.ThePlayerLabel.getLocation().y-10);
				}//else{
					//movedX=0;
					//movedY=0;
					//move = false;
				
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
			
			else if(Stats.moveX <0){
				
				if(Stats.moveX<movedX){
					movedX-=10;
					GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x-10,GUI.ThePlayerLabel.getLocation().y);
				}
				if(Stats.moveY>movedY){
					movedY+=10;
					GUI.ThePlayerLabel.setLocation(GUI.ThePlayerLabel.getLocation().x,GUI.ThePlayerLabel.getLocation().y-10);
				}
				/*else{
					movedX=0;
					movedY=0;
					move = false;
				}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				*/
				
			}
			
		}
		
		
		
		
		
		
		
	}
	}


