import java.awt.event.KeyEvent;

public class Heros {
	public static boolean right,left,up,down,stay;
	public int[] position;
	public int Hp = 3;
	
	Heros(int[]position, int Hp){
	this.position = position;
	this.Hp = Hp;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Heros.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Heros.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Heros.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Heros.down = true;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Heros.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Heros.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Heros.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Heros.down = false;
		}
	}
}
