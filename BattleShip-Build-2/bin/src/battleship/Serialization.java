package battleship;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;


/**
 * @author nitin
 * 
 * Is used to serialize the class variables to be used 
 *
 */
public class Serialization implements Serializable {

	
	/**
	 * sets the default serialversionUID
	 */
	private static final long serialVersionUID = 1L;

		/**
		 * sets enemyships
		 */
		private int enemyShips = 5;
	
		/**
		 * This is the gametimetaskrunning
		 */
		public boolean gameTimerTaskRunning;
		/**
		 * This is the playertimetaskrunning
		 */
		public boolean playerTimerTaskRunning;

	/**
	 * This is the enemyValue
	 */
	private String enemyValue;
	/**
	 * This is the myTurn boolean
	 */
	private boolean isMyTurn = false;
	/**
	 * This is the playerready boolean
	 */
	private boolean playerReady;
	/**
	 * This is the enemyReady boolean
	 */
	private boolean enemyReady;
	/**
	 * This is the isEnemyTurn boolean
	 */
	private boolean isEnemyTurn = false;
	/**
	 * This is the isPlaying boolean
	 */
	private boolean isPlaying = false;
	/**
	 * This is the isServerplay boolean
	 */
	private boolean isServerPlay = false;

	/**
	 * this arraylist contains the shotcell coordinates
	 */
	private ArrayList<Integer> shotCellCoordinates = null;
	/**
	 * this Dequeue arraylist contains the shotcell coordinates
	 */
	Deque<ArrayList<Integer>> shotCellList = new ArrayDeque<ArrayList<Integer>>();

	/**
	 * This is the success boolean
	 */
	boolean success = false;

	/**
	 * This is the ships array
	 */
	public int[] ships = { 5, 4, 3, 3, 2 };
	/**
	 * This is the shipList arrayList boolean
	 */
	private List<ArrayList<Integer>> shipList = new ArrayList<>();
	/**
	 * This is the totalplayertime variable
	 */
	public double totalPlayerTime = 0;
	/**
	 * This 2-D array saves the visited cells
	 */
	private boolean enemyBoardVisited[][] = new boolean[10][10];
	/**
	 * This arrayList saves the enemySipList
	 */
	private List<ArrayList<Integer>> enemyShipList = new ArrayList<>();
	/**
	 * Boolean to depict if ship has been placed
	 */
	private boolean ship5Placed;
	/**
	 * Boolean to depict if ship has been placed
	 */
	private boolean ship4Placed;
	/**
	 * Boolean to depict if ship has been placed
	 */
	private boolean ship3Placed1;
	/**
	 * Boolean to depict if ship has been placed
	 */
	private boolean ship3Placed2;
	/**
	 * Boolean to depict if ship has been placed
	 */
	private boolean ship2Placed;
	/**
	 * This variable states the gameplay
	 */
	private String localGamplay;
	/**
	 * This variable states the Enemy
	 */
	private String Enemy;
	/**
	 * Sets the globalTimeVar
	 */
	public double globalTimeVar = 0;

	/**
	 * Sets the playerTimeVar
	 */
	public double playerTimeVar = 0;

	/**
	 * Sets the finalScore
	 */
	private int finalScore;

	/**
	 * Sets the running boolean
	 */
	private boolean running = false;

	/**
	 * Saves the player turns
	 */
	private int playerTurns;

	/**
	 * Saves the enemy turns
	 */
	private int enemyTurns;

	/**
	 * This 2-D array saves the visited cells
	 */
	private boolean playerBoardVisited[][] = new boolean[10][10];

	/**
	 * This 2-D array saves the ships found on cells that have been shot
	 */
	private boolean shipFoundOnCell[][] = new boolean[10][10];

	/**
	 * 
	 */
	private int totalShips = ships.length;

	/**
	 * 
	 */
	private boolean enemyTurn = false;

	/**
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return
	 */
	public int[] getShips() {
		return ships;
	}

	/**
	 * @param ships
	 */
	public void setShips(int[] ships) {
		this.ships = ships;
	}

	/**
	 * @return
	 */
	public double getTotalPlayerTime() {
		return totalPlayerTime;
	}

	/**
	 * @param totalPlayerTime
	 */
	public void setTotalPlayerTime(double totalPlayerTime) {
		this.totalPlayerTime = totalPlayerTime;
	}

	/**
	 * @return
	 */
	public double getGlobalTimeVar() {
		return globalTimeVar;
	}

	/**
	 * @param globalTimeVar
	 */
	public void setGlobalTimeVar(double globalTimeVar) {
		this.globalTimeVar = globalTimeVar;
	}

	/**
	 * @return
	 */
	public double getPlayerTimeVar() {
		return playerTimeVar;
	}

	/**
	 * @param playerTimeVar
	 */
	public void setPlayerTimeVar(double playerTimeVar) {
		this.playerTimeVar = playerTimeVar;
	}

	/**
	 * @return
	 */
	public int getFinalScore() {
		return finalScore;
	}

	/**
	 * @param finalScore
	 */
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	/**
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * @return
	 */
	public int getPlayerTurns() {
		return playerTurns;
	}

	/**
	 * @param playerTurns
	 */
	public void setPlayerTurns(int playerTurns) {
		this.playerTurns = playerTurns;
	}

	/**
	 * @return
	 */
	public int getEnemyTurns() {
		return enemyTurns;
	}

	/**
	 * @param enemyTurns
	 */
	public void setEnemyTurns(int enemyTurns) {
		this.enemyTurns = enemyTurns;
	}

	/**
	 * @return
	 */
	public boolean[][] getPlayerBoardVisited() {
		return playerBoardVisited;
	}

	/**
	 * @param playerBoardVisited
	 */
	public void setPlayerBoardVisited(boolean[][] playerBoardVisited) {
		this.playerBoardVisited = playerBoardVisited;
	}

	/**
	 * @return
	 */
	public boolean[][] getShipFoundOnCell() {
		return shipFoundOnCell;
	}

	/**
	 * @param shipFoundOnCell
	 */
	public void setShipFoundOnCell(boolean[][] shipFoundOnCell) {
		this.shipFoundOnCell = shipFoundOnCell;
	}

	/**
	 * @return
	 */
	public int getTotalShips() {
		return totalShips;
	}

	/**
	 * @param totalShips
	 */
	public void setTotalShips(int totalShips) {
		this.totalShips = totalShips;
	}

	/**
	 * @return
	 */
	public boolean isEnemyTurn() {
		return enemyTurn;
	}

	/**
	 * @param enemyTurn
	 */
	public void setEnemyTurn(boolean enemyTurn) {
		this.enemyTurn = enemyTurn;
	}

	/**
	 * @return
	 */
	public List<ArrayList<Integer>> getShipList() {
		return shipList;
	}

	/**
	 * @param shipList
	 */
	public void setShipList(List<ArrayList<Integer>> shipList) {
		this.shipList = shipList;
	}

	/**
	 * @return
	 */
	public boolean[][] getEnemyBoardVisited() {
		return enemyBoardVisited;
	}

	/**
	 * @param enemyBoardVisited
	 */
	public void setEnemyBoardVisited(boolean[][] enemyBoardVisited) {
		this.enemyBoardVisited = enemyBoardVisited;
	}

	/**
	 * @return
	 */
	public List<ArrayList<Integer>> getEnemyShipList() {
		return enemyShipList;
	}

	/**
	 * @param enemyShipList
	 */
	public void setEnemyShipList(List<ArrayList<Integer>> enemyShipList) {
		this.enemyShipList = enemyShipList;
	}

	/**
	 * @return
	 */
	public String getLocalGamplay() {
		return localGamplay;
	}

	/**
	 * @param localGamplay
	 */
	public void setLocalGamplay(String localGamplay) {
		this.localGamplay = localGamplay;
	}

	/**
	 * @return
	 */
	public boolean isShip5Placed() {
		return ship5Placed;
	}

	/**
	 * @param ship5Placed
	 */
	public void setShip5Placed(boolean ship5Placed) {
		this.ship5Placed = ship5Placed;
	}

	/**
	 * @return
	 */
	public boolean isShip4Placed() {
		return ship4Placed;
	}

	/**
	 * @param ship4Placed
	 */
	public void setShip4Placed(boolean ship4Placed) {
		this.ship4Placed = ship4Placed;
	}

	/**
	 * @return
	 */
	public boolean isShip3Placed1() {
		return ship3Placed1;
	}

	/**
	 * @param ship3Placed1
	 */
	public void setShip3Placed1(boolean ship3Placed1) {
		this.ship3Placed1 = ship3Placed1;
	}

	/**
	 * @return
	 */
	public boolean isShip3Placed2() {
		return ship3Placed2;
	}

	/**
	 * @param ship3Placed2
	 */
	public void setShip3Placed2(boolean ship3Placed2) {
		this.ship3Placed2 = ship3Placed2;
	}

	/**
	 * @return
	 */
	public boolean isShip2Placed() {
		return ship2Placed;
	}

	/**
	 * @param ship2Placed
	 */
	public void setShip2Placed(boolean ship2Placed) {
		this.ship2Placed = ship2Placed;
	}

	/**
	 * @return
	 */
	public String getEnemy() {
		return Enemy;
	}

	/**
	 * @param enemy
	 */
	public void setEnemy(String enemy) {
		Enemy = enemy;
	}

	/**
	 * @return
	 */
	public int getEnemyShips() {
		return enemyShips;
	}

	/**
	 * @param enemyShips
	 */
	public void setEnemyShips(int enemyShips) {
		this.enemyShips = enemyShips;
	}

	/**
	 * @return
	 */
	public boolean isGameTimerTaskRunning() {
		return gameTimerTaskRunning;
	}

	/**
	 * @param gameTimerTaskRunning
	 */
	public void setGameTimerTaskRunning(boolean gameTimerTaskRunning) {
		this.gameTimerTaskRunning = gameTimerTaskRunning;
	}

	/**
	 * @return
	 */
	public boolean isPlayerTimerTaskRunning() {
		return playerTimerTaskRunning;
	}

	/**
	 * @param playerTimerTaskRunning
	 */
	public void setPlayerTimerTaskRunning(boolean playerTimerTaskRunning) {
		this.playerTimerTaskRunning = playerTimerTaskRunning;
	}

	/**
	 * @return
	 */
	public String getEnemyValue() {
		return enemyValue;
	}

	/**
	 * @param enemyValue
	 */
	public void setEnemyValue(String enemyValue) {
		this.enemyValue = enemyValue;
	}

	/**
	 * @return
	 */
	public boolean isMyTurn() {
		return isMyTurn;
	}

	/**
	 * @param isMyTurn
	 */
	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	/**
	 * @return
	 */
	public boolean isPlayerReady() {
		return playerReady;
	}

	/**
	 * @param playerReady
	 */
	public void setPlayerReady(boolean playerReady) {
		this.playerReady = playerReady;
	}

	/**
	 * @return
	 */
	public boolean isEnemyReady() {
		return enemyReady;
	}

	/**
	 * @param enemyReady
	 */
	public void setEnemyReady(boolean enemyReady) {
		this.enemyReady = enemyReady;
	}

	/**
	 * @return
	 */
	public boolean getIsEnemyTurn() {
		return isEnemyTurn;
	}

	/**
	 * @param isEnemyTurn
	 */
	public void setIsEnemyTurn(boolean isEnemyTurn) {
		this.isEnemyTurn = isEnemyTurn;
	}

	/**
	 * @return
	 */
	public boolean getIsPlaying() {
		return isPlaying;
	}

	/**
	 * @param isPlaying
	 */
	public void setIsPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	/**
	 * @return
	 */
	public boolean isServerPlay() {
		return isServerPlay;
	}

	/**
	 * @param isServerPlay
	 */
	public void setServerPlay(boolean isServerPlay) {
		this.isServerPlay = isServerPlay;
	}

	/**
	 * @return
	 */
	public ArrayList<Integer> getShotCellCoordinates() {
		return shotCellCoordinates;
	}

	/**
	 * @param shotCellCoordinates
	 */
	/**
	 * @param shotCellCoordinates
	 */
	public void setShotCellCoordinates(ArrayList<Integer> shotCellCoordinates) {
		this.shotCellCoordinates = shotCellCoordinates;
	}

	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public Deque<ArrayList<Integer>> getShotCellList() {
		return shotCellList;
	}

	/**
	 * @param shotCellList
	 */
	/**
	 * @param shotCellList
	 */
	public void setShotCellList(Deque<ArrayList<Integer>> shotCellList) {
		this.shotCellList = shotCellList;
	}

}
