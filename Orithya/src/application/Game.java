package application;
/**Manages some aspects of game.
 * 
 * @author jack
 *
 */
public class Game {
	
	private int mapSize;
	private int [][] map;
	/**Constructor of game.
	 * 
	 * @param mapSize
	 */
	public Game(int mapSize) {
		this.mapSize = mapSize;
		
	}
/**Method to create the integer matrix of a square matrix.
 * 
 * @param mapSize: maps size 
 * @param p1 player 1
 * @param p2 player 2
 * @return
 */
	public int[][] startGame(int mapSize, Player p1, Player p2) {
		map = new int[mapSize][mapSize];
		int p1Num = p1.getPlayerNumber();
		int p2Num = p2.getPlayerNumber();
		// adding player 1 number to game matrix
		map[0][0] = p1Num;
		// adding player 2 number to game matrix
		map[mapSize - 1][mapSize - 1] = p2Num;
		return map;
	}
	/**will check if a player has won.
	 * 
	 * @param map
	 * @return int of player winning, 0 if tied
	 */
	public int isWon(int[][] map) {
		int mapSize = map.length;
		double winCondition = mapSize * mapSize * .8;
		int p1Count = 0;
		int p2Count = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if (map[i][j] == 1) {
					p1Count++;
				} else if (map[i][j] == 2) {
					p2Count++;
				}
			}
		}
		if (p1Count >= winCondition) {
			return 1;
		} else if (p2Count >= winCondition) {
			return 2;

		} else
			return 0;
	}

}