package application;
import java.util.Random;

/**Matrix class of Galaxy: this class is undergoing construction which means no proper skeleton code.
 * 
 * @author jack
 *
 */
public class Galaxy {
	//protected int StarSystem[][];
	protected int map [][];
	static Random rand=new Random();
	
	public Galaxy(int x, int y) {
	
	}
	/**method assembles the planets inside of the grid: still under construction!
	 * 
	 * @param map
	 */
	public void assemblePlanets(int [][] Planetlist, int [][] map) {
		boolean t=true;
		boolean f=false;
		map=assembleMatrix(map);
		for(int i=0;i<Planetlist.length;i++) {
			for(int j=0;j<Planetlist[i].length;j++) {
			//		StarSystem[i][j]=new StarSystem (map [i][j]);
				}
			}
		}
	/**method assembles a matrix of zeros and ones. Zero (true) One(false)
	 *  
	 * @param a an integer matrix
	 * @return returns the new matrix filled with zeros and ones. Zero(true) One(false)
	 */
	public static int[][] assembleMatrix(int [][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=rand.nextInt(1);
			}
		}
		return a;
		}
	}


