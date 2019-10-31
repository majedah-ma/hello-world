package application;

/**The player class and object attributes.
 * 
 * @author Paint.IO team
 * 
 *       
 *
 */
public class Player {
	private int[] playerCoord;
	private int playerNumber;
	private static int PLAYERNUMBER = 1;
	private int[][] map;
	private String winner = null;
	private int[][] errMap = {{3,3},{3,3}};

	private boolean validMove = true;
	
	
	
	/**Constructor of player.
	 * 
	 * @param playerCoord - array with y position[0] and x position[1] 
	 * @param map - matrix for the class to manipulate and return 
	 */
	public Player(int[][] map, int[] playerCoord) {
		this.playerCoord = playerCoord;
		this.playerNumber = PLAYERNUMBER++;
		this.map = map;
		
	}
	/**
	 * 
	 * @param playerPosition - array with xy coords
	 * @param playerNumber - number of the player for matrix filling purposes 
	 * @param map - matrix to be modified
	 * @return new matrix to be added to getter method and called by game class
	 * 
	 */
	public int[][] playerUp(int[]playerPosition, int playerNumber, int[][] map){
		int mapSize = map[0].length;
		playerCoord = playerPosition;
		int xCoord = setX(playerPosition);
		int yCoord = setY(playerPosition);
		// getting opposing player number
		int opPlayer;
		if( playerNumber == 1) {
			opPlayer = 2;
		}else {
			opPlayer = 1;
		}
		if(yCoord-1 >= mapSize || yCoord-1 <0) {
			// return error matrix
			
		}else if(map[yCoord-1][xCoord] == 0 || map[yCoord-1][xCoord] == playerNumber) {
			try {
			map[yCoord-1][xCoord] = playerNumber;
			playerCoord[0] = yCoord-1;
			}catch(ArrayIndexOutOfBoundsException e) {
				return errMap;
				
			}
		}else {
			// some way to tell game class that fight method needs to be called.
			map[yCoord-1][xCoord] = fight(opPlayer);
			if( map[yCoord-1][xCoord]  == opPlayer) {
				playerCoord[0] = map[yCoord][xCoord];
			}else {
			playerCoord[0] = map[yCoord-1][xCoord];
			}
			// defining who won as a string for use in game class
			if( map[yCoord-1][xCoord] == playerNumber) {
				winner = "P" + playerNumber;
			}else {
				winner = "P" + opPlayer;
			}
		}
		return map;
		
		// setting cell directly above the input position to playerNumber if it is open
		// return matrix
		
	}
	public int[][] playerDown(int[]playerPosition, int playerNumber, int[][] map){
		int mapSize = map[0].length;
		playerCoord = playerPosition;
		int xCoord = setX(playerPosition);
		int yCoord = setY(playerPosition);
		// getting opposing player number
		int opPlayer;
		if( playerNumber == 1) {
			opPlayer = 2;
		}else {
			opPlayer = 1;
		}
		if(yCoord+1 >= mapSize || yCoord+1 <0) {
			// return error matrix
			
		}else if(map[yCoord+1][xCoord] == 0 || map[yCoord+1][xCoord] == playerNumber) {
			try {
			map[yCoord+1][xCoord] = playerNumber;
			playerCoord[0] = yCoord+1;
			}catch(ArrayIndexOutOfBoundsException e) {
				return errMap;
				
			}
		}else {
			// some way to tell game class that fight method needs to be called.
			map[yCoord+1][xCoord] = fight(opPlayer);
			if( map[yCoord+1][xCoord]  == opPlayer) {
				playerCoord[0] = map[yCoord][xCoord];
			}else {
			playerCoord[0] = map[yCoord+1][xCoord];
			}
			// defining who won as a string for use in game class
			if( map[yCoord+1][xCoord] == playerNumber) {
				winner = "P" + playerNumber;
			}else {
				winner = "P" + opPlayer;
			}
		}
		return map;
	}
	public int[][] playerLeft(int[]playerPosition, int playerNumber, int[][] map){
		int mapSize = map[0].length;
		playerCoord = playerPosition;
		int xCoord = setX(playerPosition);
		int yCoord = setY(playerPosition);
		// getting opposing player number
		int opPlayer;
		if( playerNumber == 1) {
			opPlayer = 2;
		}else {
			opPlayer = 1;
		}
		if(xCoord-1 >= mapSize || xCoord-1 <0) {
			// return error matrix
			
		}else if(map[yCoord][xCoord-1] == 0 || map[yCoord][xCoord-1] == playerNumber) {
			try {
			map[yCoord][xCoord-1] = playerNumber;
			playerCoord[1] = xCoord-1;
			}catch(ArrayIndexOutOfBoundsException e) {
				return errMap;
			}
		}else {
		
			// some way to tell game class that fight method needs to be called.
			map[yCoord][xCoord-1] = fight(opPlayer);
			if( map[yCoord][xCoord-1]  == opPlayer) {
				playerCoord[1] = map[yCoord][xCoord];
			}else {
			playerCoord[1] = map[yCoord][xCoord-1];
			}
			// defining who won as a string for use in game class
			if( map[yCoord][xCoord-1] == playerNumber) {
				winner = "P" + playerNumber;
			}else {
				winner = "P" + opPlayer;
			}
		}
		return map;
	}
	public int[][] playerRight(int[]playerPosition, int playerNumber, int[][] map){
		int mapSize = map[0].length;
		int[][] mapTemp = map;
		playerCoord = playerPosition;
		int xCoord = setX(playerPosition);
		int yCoord = setY(playerPosition);
		// getting opposing player number
		int opPlayer;
		if( playerNumber == 1) {
			opPlayer = 2;
		}else {
			opPlayer = 1;
		}
		if(xCoord+1 >= mapSize || xCoord+1 <0) {
			// return error matrix
			
		}else if(map[yCoord][xCoord+1] == 0 || map[yCoord][xCoord+1] == playerNumber) {
			try {
			map[yCoord][xCoord+1] = playerNumber;
			playerCoord[1] = xCoord+1;
			}catch(ArrayIndexOutOfBoundsException e) {
				return errMap;
				
			}
		}else {
			// some way to tell game class that fight method needs to be called.
			map[yCoord][xCoord+1] = fight(opPlayer);
			if( map[yCoord][xCoord+1]  == opPlayer) {
				playerCoord[1] = map[yCoord][xCoord];
			}else {
			playerCoord[1] = map[yCoord][xCoord+1];
			}
			// defining who won as a string for use in game class
			if( map[yCoord][xCoord+1] == playerNumber) {
				winner = "P" + playerNumber;
			}else {
				winner = "P" + opPlayer;
			}
		}
		return map;
	}
	/**
	 * 
	 * @return returns the player number
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	private int setX(int[] playerPosition) {
		return playerPosition[1];
	}
	private int setY(int[] playerPosition) {
		return playerPosition[0];
	}
	/**
	 * 
	 * @return the winner of the fight if a fight ran, useful for setting player back in game class
	 * returns "P" + a player number (ex. "P2")
	 */
	public String getWinner() {
		return winner;
	}
	/**
	 * 
	 * @return boolean validMove - false if move is invalid else true
	 */
	public boolean getValidMove() {
		return validMove;
	}
	public int[] getPlayerCoords() {
		return playerCoord;
	}

/**Method that does combat based on a player percentage win.
 * 
 * @param adv: advantage for a given player.
 * @return
 */
	private int fight(int adv) {
		 double p1 = 5.0;
		 double p2 = 5.0;
		 
		 double p1Roll= Math.random();
		 double p2Roll= Math.random();
		 
		 if(adv == 1) {
		  if((p1Roll*p1)>(p2Roll*(p2-0.5))) {
		   return 1;
		  }else if((p1Roll*p1)<(p2Roll*(p2-0.5))) {
		   return 2;
		  }
		 }else if(adv == 2) {
		  if((p2Roll*p2)>(p1Roll*(p1-0.5))) {
		   return 2;
		  }else if((p2Roll*p2)<(p1Roll*(p1-0.5))) {
		   return 1;
		  }
		 }
		 return adv;
	}
	
}
