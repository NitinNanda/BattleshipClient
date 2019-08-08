package battleship.controller;

import java.net.URL;
import java.util.ResourceBundle;

import battleship.BattleshipMain;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * The Class GameLayoutController.
 *
 * @author Vsu Chuchra, Nitin Nanda, Simarpreet Kaur Jabbal, Vrind Gupta, Ayush
 *         Arya
 */
public class GameLayoutController implements Initializable{

	/** The main app. */
	private BattleshipMain mainApp;
	/**
	 * Global Game Time label
	 */
	@FXML
	private Label timerLabel;

	/**
	 * Displays they type of gameplay either Salva/Normal
	 */
	@FXML
	private Label gamePlayLabel;

	/**
	 * Ship image of length 5
	 */
	@FXML
	private ImageView ship5ImageView;

	/**
	 * Ship image of length 4
	 */
	@FXML
	private ImageView ship4ImageView;

	/**
	 * Ship image of length 3
	 */
	@FXML
	private ImageView ship3ImageView1;

	/**
	 * Ship image of length 3
	 */
	@FXML
	private ImageView ship3ImageView2;

	/**
	 * Ship image of length 2
	 */
	@FXML
	private ImageView ship2ImageView;

	/**
	 * Its is the left anchorpane on the splitpane at the bottom Contains the
	 * Computer Grid
	 */
	@FXML
	private AnchorPane leftPane;

	/**
	 * Its is the center anchorpane on the splitpane at the bottom It contains all
	 * the timer labels, retry and quit buttons
	 */
	@FXML
	private AnchorPane centerPane;

	/**
	 * Its is the right anchorpane on the splitpane at the bottom Contains the
	 * Computer Grid
	 */
	@FXML
	private AnchorPane rightPane;

	/**
	 * Player Time label
	 */
	@FXML
	private Label playerLabel;
	
	/**
	 * Boolean which tells if ship of length 5 has been dropped
	 */
	private boolean ship5Dropped;
	
	/**
	 * Boolean which tells if ship of length 4 has been dropped
	 */
	private boolean ship4Dropped;
	
	/**
	 * Boolean which tells if ship of length 3 has been dropped
	 */
	private boolean ship3Dropped1;
	
	/**
	 * Boolean which tells if ship of length 3 has been dropped
	 */
	private boolean ship3Dropped2;
	
	/**
	 * Boolean which tells if ship of length 2 has been dropped
	 */
	private boolean ship2Dropped;

	/**
	 * Colours if it is enemy turn
	 */
	@FXML
	private Circle enemyIndicator;

	/**
	 * Colours if it is player turn
	 */
	@FXML
	private Circle playerIndicator;
	
	/**
	 * marks if it is player turn
	 */
	@FXML
	private Label playerEvent;
	
	/**
	 * marks the type of gameevent
	 */
	@FXML
	private Label gameEvent;
	
	/**
	 * marks if it is Server gameplay 
	 */
	@FXML
	private Label serverEvent;

	/**
	 *  Gets the server event 
	 */	
	public Label getServerEvent() {
		return serverEvent;
	}

	/**
	 *  Sets if it is a server event 
	 */	
	public void setServerEvent(String value) {
		this.serverEvent.setText(value);
	}

	/**
	 *  Gets the gameplay label 
	 */	
	public Label getGamePlayLabel() {
		return gamePlayLabel;
	}

	/**
	 *  Sets the gameplay label 
	 */	
	public void setGamePlayLabel(Label gamePlayLabel) {
		this.gamePlayLabel = gamePlayLabel;
	}

	/**
	 *  Gets the player label 
	 */	
	public Label getPlayerLabel() {
		return playerLabel;
	}

	/**
	 *  Sets the player label 
	 */	
	public void setPlayerLabel(Label playerLabel) {
		this.playerLabel = playerLabel;
	}

	public Circle getEnemyIndicator() {
		return enemyIndicator;
	}

	/**
	 * Colours if it is enemy turn
	 */
	public void setEnemyIndicator(Color color) {
		this.enemyIndicator.setFill(color);
	}

	/**
	 * Colours if it is player turn
	 */
	public Circle getPlayerIndicator() {
		return playerIndicator;
	}

	/**
	 * Colours if it is player turn
	 */
	public void setPlayerIndicator(Color color) {
		this.playerIndicator.setFill(color);
	}

	/**
	 * gets text from player event label
	 */
	public Label getPlayerEvent() {
		return playerEvent;
	}

	/**
	 * gets text from player event label
	 */
	public void setPlayerEvent(Label playerEvent) {
		this.playerEvent = playerEvent;
	}

	/**
	 * gets text from game event label
	 */
	public Label getGameEvent() {
		return gameEvent;
	}

	/**
	 * sets text to game event label
	 */
	public void setGameEvent(String message) {
		this.gameEvent.setText(message);
		
	}

	/**
	 * Sets the main app.
	 *
	 * @param mainApp
	 *            the new main app
	 */
	public void setMainApp(BattleshipMain mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Handle retry. Resets the stage so that a new game can be played if the user
	 * choses to abort the current game.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@FXML
	private void handleRetry() throws Exception {
		mainApp.resetGlobalVars();
		mainApp.setLoadGame(false);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameLayoutController.class.getResource("/battleship/view/GameLayout.fxml"));
		loader.setController(mainApp.getGameLayoutController());
		SplitPane gameLayout = (SplitPane) loader.load();
		mainApp.createEnemyContent(leftPane);
		mainApp.createPlayerContent(rightPane);
		Scene scene = new Scene(gameLayout);
		mainApp.getPrimaryStage().setTitle("Battleship");
		mainApp.getPrimaryStage().setScene(scene);
	}
	
	public BattleshipMain getMainApp() {
		return mainApp;
	}

	/**
	 * Handle quit.
	 */
	@FXML
	private void handleQuit() {
		mainApp.setLoadGame(false);
		mainApp.restartGameScreen();
	}

	/**
	 * Updates the global game timer label.
	 */
	public void setTimerLabel(String str) {
		timerLabel.setText(str);
	}

	/**
	 * Updates the player local timer label.
	 */
	public void setTimer2Label(String str) {
		playerLabel.setText(str);
	}

	/**
	 * Initializes objects, methods and variables and performs 
	 * required taskes when GameLayoutController is loaded 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.9), gameEvent);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		fadeTransition.setCycleCount(Animation.INDEFINITE);
		fadeTransition.play();
		gamePlayLabel.setText(mainApp.getGameScreenController().getGamePlay());
		ship5ImageView.setImage(new Image("/battleship/view/images/shipSize5.jpg"));
		ship4ImageView.setImage(new Image("/battleship/view/images/shipSize4.jpg"));
		ship3ImageView1.setImage(new Image("/battleship/view/images/shipSize3.jpg"));
		ship3ImageView2.setImage(new Image("/battleship/view/images/shipSize3.jpg"));
		ship2ImageView.setImage(new Image("/battleship/view/images/shipSize2.jpg"));
		ship5ImageView.setOnDragDetected((MouseEvent event) -> {
			if (ship5ImageView.getImage() != null) {
				resetImageDropProperties();
				Dragboard db = centerPane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(ship5ImageView.getImage());
				String data = ((ship5ImageView).getImage().impl_getUrl().substring(
						(ship5ImageView).getImage().impl_getUrl().indexOf("shipSize") + 8,
						(ship5ImageView).getImage().impl_getUrl().lastIndexOf(".")) + "_" + event.getButton().name());
				content.putString(data);
				db.setContent(content);
				ship5Dropped = true;
			}
			event.consume();
		});
		ship4ImageView.setOnDragDetected((MouseEvent event) -> {
			if (ship4ImageView.getImage() != null) {
				resetImageDropProperties();
				Dragboard db = centerPane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(ship4ImageView.getImage());
				String data = ((ship4ImageView).getImage().impl_getUrl().substring(
						(ship4ImageView).getImage().impl_getUrl().indexOf("shipSize") + 8,
						(ship4ImageView).getImage().impl_getUrl().lastIndexOf(".")) + "_" + event.getButton().name());
				content.putString(data);
				db.setContent(content);
				ship4Dropped = true;
			}
			event.consume();
		});
		ship3ImageView1.setOnDragDetected((MouseEvent event) -> {
			if (ship3ImageView1.getImage() != null) {
				resetImageDropProperties();
				Dragboard db = centerPane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(ship3ImageView1.getImage());
				String data = ((ship3ImageView1).getImage().impl_getUrl().substring(
						(ship3ImageView1).getImage().impl_getUrl().indexOf("shipSize") + 8,
						(ship3ImageView1).getImage().impl_getUrl().lastIndexOf(".")) + "_" + event.getButton().name());
				content.putString(data);
				db.setContent(content);
				ship3Dropped1 = true;
			}
			event.consume();
		});
		ship3ImageView2.setOnDragDetected((MouseEvent event) -> {
			if (ship3ImageView2.getImage() != null) {
				resetImageDropProperties();
				Dragboard db = centerPane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(ship3ImageView2.getImage());
				String data = ((ship3ImageView2).getImage().impl_getUrl().substring(
						(ship3ImageView2).getImage().impl_getUrl().indexOf("shipSize") + 8,
						(ship3ImageView2).getImage().impl_getUrl().lastIndexOf(".")) + "_" + event.getButton().name());
				content.putString(data);
				db.setContent(content);
				ship3Dropped2 = true;
			}
			event.consume();
		});
		ship2ImageView.setOnDragDetected((MouseEvent event) -> {
			if (ship2ImageView.getImage() != null) {
				resetImageDropProperties();
				Dragboard db = centerPane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putImage(ship2ImageView.getImage());
				String data = ((ship2ImageView).getImage().impl_getUrl().substring(
						(ship2ImageView).getImage().impl_getUrl().indexOf("shipSize") + 8,
						(ship2ImageView).getImage().impl_getUrl().lastIndexOf(".")) + "_" + event.getButton().name());
				content.putString(data);
				db.setContent(content);
				ship2Dropped = true;
				event.consume();
			}
		});

		centerPane.setOnDragDone((DragEvent event) -> {
			if (event.getTransferMode() == TransferMode.MOVE && ship5Dropped) {
				ship5ImageView.setImage(null);
			}
			if (event.getTransferMode() == TransferMode.MOVE && ship4Dropped) {
				ship4ImageView.setImage(null);
			}
			if (event.getTransferMode() == TransferMode.MOVE && ship3Dropped1) {
				ship3ImageView1.setImage(null);
			}
			if (event.getTransferMode() == TransferMode.MOVE && ship3Dropped2) {
				ship3ImageView2.setImage(null);
			}
			if (event.getTransferMode() == TransferMode.MOVE && ship2Dropped) {
				ship2ImageView.setImage(null);
			}
			event.consume();
		});

	}

	/**
	 * Resets ship image properties when a new game is 
	 * played after clicking reset or quit 
	 */
	private void resetImageDropProperties() {
		if (ship5ImageView.getImage() == null) {
			ship5Dropped = true;
		} else {
			ship5Dropped = false;
		}
		if (ship4ImageView.getImage() == null) {
			ship4Dropped = true;
		} else {
			ship4Dropped = false;
		}
		if (ship3ImageView1.getImage() == null) {
			ship3Dropped1 = true;
		} else {
			ship3Dropped1 = false;
		}
		if (ship3ImageView2.getImage() == null) {
			ship3Dropped2 = true;
		} else {
			ship3Dropped2 = false;
		}
		if (ship2ImageView.getImage() == null) {
			ship2Dropped = true;
		} else {
			ship2Dropped = false;
		}
	}
	
	/**
	 * boolean to get drop state of ship
	 */
	public boolean isShip5Dropped() {
		return ship5Dropped;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip5Dropped(boolean ship5Dropped) {
		this.ship5Dropped = ship5Dropped;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public boolean isShip4Dropped() {
		return ship4Dropped;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip4Dropped(boolean ship4Dropped) {
		this.ship4Dropped = ship4Dropped;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public boolean isShip3Dropped1() {
		return ship3Dropped1;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip3Dropped1(boolean ship3Dropped1) {
		this.ship3Dropped1 = ship3Dropped1;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public boolean isShip3Dropped2() {
		return ship3Dropped2;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip3Dropped2(boolean ship3Dropped2) {
		this.ship3Dropped2 = ship3Dropped2;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public boolean isShip2Dropped() {
		return ship2Dropped;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip2Dropped(boolean ship2Dropped) {
		this.ship2Dropped = ship2Dropped;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public ImageView getShip5ImageView() {
		return ship5ImageView;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip5ImageView(ImageView ship5ImageView) {
		this.ship5ImageView = ship5ImageView;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public ImageView getShip4ImageView() {
		return ship4ImageView;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip4ImageView(ImageView ship4ImageView) {
		this.ship4ImageView = ship4ImageView;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public ImageView getShip3ImageView1() {
		return ship3ImageView1;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip3ImageView1(ImageView ship3ImageView1) {
		this.ship3ImageView1 = ship3ImageView1;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public ImageView getShip3ImageView2() {
		return ship3ImageView2;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip3ImageView2(ImageView ship3ImageView2) {
		this.ship3ImageView2 = ship3ImageView2;
	}

	/**
	 * boolean to get drop state of ship
	 */
	public ImageView getShip2ImageView() {
		return ship2ImageView;
	}

	/**
	 * boolean to set drop state of ship
	 */
	public void setShip2ImageView(ImageView ship2ImageView) {
		this.ship2ImageView = ship2ImageView;
	}

	/**
	 * saves the game state
	 */
	@FXML
	public void save() throws Exception {
		mainApp.setLoadGame(true);
		mainApp.save();
	}
}
