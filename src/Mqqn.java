
public class Mqqn {
	
	
	public static void main(String[] args) {
		Opener obj = new Opener();
		Thread Mover = new Thread( new MovementThread());
		Mover.start();
	}

}
