package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**Square graphic from Javafx.
 * 
 * @author Paint.IO team.
 *
 */
public class Square {
	protected Rectangle node=null;
	/**Square constructor
	 * 
	 */
	public Square(){
		node=new Rectangle();
	}
	/**the method set to optimal square length and width.
	 * 
	 */
	public void squareSet() {
		node.setX(100);
		node.setY(100);
		node.setWidth(50);
		node.setHeight(50);
		node.setArcHeight(0);
		node.setArcWidth(0);
	}
	/**method to set color of a square Blue is Player 1 and Red is player 2.
	 * 
	 * @param num
	 */
	public void setColor(int num) {
		if(num==1) {
			node.setFill(Color.BLUE);
		}else if(num==2) {
			node.setFill(Color.RED);
		}
	}
/**returns the graphic.
 * 
 * @return
 */
	public Rectangle getnode() {
		node.setFill(Color.WHITE);
		return node;
	}
	/**The color that represents player location in the grid. Dark blue Player 1 and Pink Player 2.
	 * 
	 * @param numplayer
	 */
	public void PlayerCoordinate(int numplayer) {
		if(numplayer==1) {
			node.setFill(Color.DARKBLUE);
		}else if(numplayer==2) {
			node.setFill(Color.PINK);
		}
	}
}

	