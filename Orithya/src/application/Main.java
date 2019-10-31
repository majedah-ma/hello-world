package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**All graphics from Javafx occur here.
 * 
 * @author Paint.IO Team
 *
 */
public class Main extends Application{
	private static int [][] map;
	private static int [][] initialMap;
	private static Square[][] sq;
	private static Game g;
	public int mapSize = 4;
	public static int temp;
	public static int playerMove;
	public static Player p1;
	public static Player p2;
	private int [] p1Coord;
	private int [] p2Coord;
	private int [] tempOord;
	/**The start method that only calls menu.
	 * 
	 */
	public void start(Stage primaryStage){
		
		menu(primaryStage);
	}
	/**Menu methods that displays the menu and size buttons.
	 * 
	 * @param primaryStage: the stage of scene.
	 */
	public void menu(Stage primaryStage){
        Button pBtn = new Button("4X4");
        Button mBtn = new Button("6X6");
        Button bBtn = new Button("8X8");
        
        Text t = new Text();
        t.setText("Paint.io");
        t.setFont(Font.font("Verdana",76));
        Text t2 =new Text();
        t2.setText("Set Map Size");
        t2.setFont(Font.font("Verdana",20));
        Text t3 =new Text();
        t3.setText("");
        t3.setFont(Font.font("Verdana",80));
        Text t4 =new Text();
        t4.setText("");
        t4.setFont(Font.font("Verdana",10));
        Text t5 =new Text();
        t5.setText("");
        t5.setFont(Font.font("Verdana",10));
        
        VBox layout = new VBox();
        layout.setStyle("-fx-background-color: #44FFFF;");
        
        layout.getChildren().addAll(t,t2,t3,pBtn,t4,mBtn,t5,bBtn);
        layout.setAlignment(Pos.TOP_CENTER);
        
        pBtn.setOnAction(e -> {
        	mapSize = 4;
        	temp=mapSize;
        	game(primaryStage);
        });
        
        mBtn.setOnAction(e -> {
        	mapSize = 6;
        	temp=mapSize;
        	game(primaryStage);
        });
        
        bBtn.setOnAction(e -> {
        	mapSize = 8;
        	temp=mapSize;
        	game(primaryStage);
        });  
	    
	    Scene scene = new Scene(layout);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Menu");
	    primaryStage.setWidth(500);
	    primaryStage.setHeight(500);
	    primaryStage.setX(960 - 250);
	    primaryStage.setY(540 - 250);
	    primaryStage.setResizable(false);
	    primaryStage.show();
    }
	/**The method that displays the winner.
	 * 
	 * @param primaryStage: the stage of the scene.
	 * @param winner: the player identification number.
	 */
	public void winner(Stage primaryStage,int winner){
	       Text t= new Text();
	       t.setText ("Player " + winner + " won the game!");
	       HBox hbox = new HBox();
	       hbox.setAlignment(Pos.CENTER);
	       hbox.getChildren().add(t);
	       Scene scene3 = new Scene(hbox, 400, 400);
	       primaryStage.setScene(scene3);
	       primaryStage.show();
	       
	    }
	/**All GridPane() and method calls and object creation are made here along with grid fillers.
	* 
	* @param primaryStage: the stage of the scene.
	*/
	public void game(Stage primaryStage) {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(40, 40, 40, 40));
			grid.setVgap(5);
			grid.setHgap(5);
			grid.setGridLinesVisible(true);

			VBox pane = new VBox();
			HBox panes = new HBox(pane);

			g = new Game(mapSize);
			sMatrix(mapSize);
			p1Coord = new int[2];
			p1Coord[0] = 0;
			p1Coord[1] = 0;
			p2Coord = new int[2];
			p2Coord[0] = mapSize-1;
			p2Coord[1] = mapSize-1;
			p1 = new Player(map, p1Coord);
			p2 = new Player(map, p2Coord);
			map = g.startGame(mapSize, p1, p2);
			for(int i=0;i<sq.length;i++) {
				for(int j=0;j<sq[0].length;j++) {
					grid.add(sq[i][j].getnode(),j,i);
				}
			}
			findSquareForPlayer(sq,p1,p2);
			pane.getChildren().add(grid);
			pane.setAlignment(Pos.CENTER);
			panes.setAlignment(Pos.CENTER);
			Scene scene2 = new Scene(panes);
			primaryStage.setScene(scene2);
			primaryStage.show();
			grid.setOnKeyPressed(e->{
				
				if(e.getCode()==KeyCode.ESCAPE) {
					System.exit(0);
				}
				
				if(e.getCode()==KeyCode.W) {
					tempOord=p1Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p1.getPlayerNumber());
					p1.playerUp(p1Coord, p1.getPlayerNumber(), map);
					p1Coord = p1.getPlayerCoords();
					sq[p1Coord[0]][p1Coord[1]].PlayerCoordinate(p1.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.UP)	{
					tempOord=p2Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p2.getPlayerNumber());
					p2.playerUp(p2Coord, p2.getPlayerNumber(), map);
					p2Coord = p2.getPlayerCoords();
					sq[p2Coord[0]][p2Coord[1]].PlayerCoordinate(p2.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.S) {
					tempOord=p1Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p1.getPlayerNumber());
					p1.playerDown(p1Coord, p1.getPlayerNumber(), map);
					p1Coord = p1.getPlayerCoords();
					sq[p1Coord[0]][p1Coord[1]].PlayerCoordinate(p1.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.DOWN) {
					tempOord=p2Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p2.getPlayerNumber());
					p2.playerDown(p2Coord, p2.getPlayerNumber(), map);
					p2Coord = p2.getPlayerCoords();
					sq[p2Coord[0]][p2Coord[1]].PlayerCoordinate(p2.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.D) {
					tempOord=p1Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p1.getPlayerNumber());
					p1.playerRight(p1Coord, p1.getPlayerNumber(), map);
					p1Coord = p1.getPlayerCoords();
					sq[p1Coord[0]][p1Coord[1]].PlayerCoordinate(p1.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.RIGHT) {	
					tempOord=p2Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p2.getPlayerNumber());
					p2.playerRight(p2Coord, p2.getPlayerNumber(), map);
					p2Coord = p2.getPlayerCoords();
					sq[p2Coord[0]][p2Coord[1]].PlayerCoordinate(p2.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
				if(e.getCode()==KeyCode.A) {
					tempOord=p1Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p1.getPlayerNumber());
					p1.playerLeft(p1Coord, p1.getPlayerNumber(), map);
					p1Coord = p1.getPlayerCoords();
					sq[p1Coord[0]][p1Coord[1]].PlayerCoordinate(p1.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}	
				
				if(e.getCode()==KeyCode.LEFT) {	
					tempOord=p2Coord;
					sq[tempOord[0]][tempOord[1]].setColor(p2.getPlayerNumber());
					p2.playerLeft(p2Coord, p2.getPlayerNumber(), map);
					p2Coord = p2.getPlayerCoords();
					sq[p2Coord[0]][p2Coord[1]].PlayerCoordinate(p2.getPlayerNumber());
					if( g.isWon(map) != 0) {
						winner(primaryStage, g.isWon(map));
						if( e.getCode()==KeyCode.ESCAPE) {
							System.exit(0);
							}
					}
				}
				
			});
			grid.requestFocus();
			
		}
		/**Is used to fill a matrix of squares given the size of the matrix.
		 * 
		 * @param mapsize: the size of the map.
		 * @return sq: the Square matrix filled in.
		 */
		
		public Square[][] sMatrix(int mapsize){
			sq=new Square [mapsize][mapsize];
			for(int l=0;l<sq.length;l++) {
				for(int k=0;k<sq[l].length;k++) {
					sq[l][k]=new Square();
					sq[l][k].squareSet();
				}
			}
			return sq;
		}
		/**Sets up initial player spawn. 
		 * 
		 * @param s: the matrix Square filled.
		 * @param p1: Player 1
		 * @param p2: Player 2
		 */
		public static void findSquareForPlayer(Square [][] s, Player p1, Player p2) {
			initialMap=g.startGame(temp, p1, p2);
				if(initialMap[0][0]==p1.getPlayerNumber()) {
					sq[0][0].PlayerCoordinate(p1.getPlayerNumber());
				if(initialMap[temp-1][temp-1]==p2.getPlayerNumber()) {
					sq[temp-1][temp-1].PlayerCoordinate(p2.getPlayerNumber());
					
				}
			}
		}
		/**Main just launches the GUI from commandline.
		 * 
		 * @param args: please ignore.
		 */
		public static void main(String[] args) {
			launch(args);

	}
	
	}