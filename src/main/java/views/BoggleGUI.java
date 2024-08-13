//Ahmad Gaber
package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Boggle;

public class BoggleGUI extends Application {

	private Button newGame = new Button("New Game");
	private Button endGame = new Button("End Game");

	private Boggle game;

	// Graphical Nodes
	private TextArea diceTrayArea;
	private TextArea resultArea;
	private TextArea userInputArea;
	private GridPane everything = new GridPane();
	Label attemptsLabel = new Label("Enter attempts below:");
	Label resultsLabel = new Label("Results:");

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		// Set up window with buttons and labels in row one,
		// textareas in row 2
		layoutWindow();

		Scene scene = new Scene(everything, 900, 330);
		stage.setScene(scene);
		stage.show();
		startNewGame();
		setupHandlers();
	}

	private void startNewGame() {
		game = new Boggle();
		userInputArea.clear();
		resultArea.clear();
		diceTrayArea.setText(game.getBoardString());
	}

	private void setupHandlers() {
		EventHandler<ActionEvent> newGameHandler = new NewGameHandler();
		newGame.setOnAction(newGameHandler);

		EventHandler<ActionEvent> endGameHandler = new EndGameHandler();
		endGame.setOnAction(endGameHandler);
	}

	private void layoutWindow() {
		// Layout the GUI.
		// TODO" Create a new GridPane, add two Buttons, and add to

		diceTrayArea = new TextArea();
		GridPane pane = new GridPane();
		pane.setHgap(30);
		pane.add(newGame, 1, 1);
		pane.add(endGame, 2, 1);
		everything.add(pane, 1, 1);
		everything.add(attemptsLabel, 2, 1);
		everything.add(resultsLabel, 3, 1);

		everything.setVgap(10);
		everything.setHgap(10);
		diceTrayArea.setMaxWidth(250);
		diceTrayArea.setMaxHeight(250);

		// Set the font of diceTrayArea to "Courier New", 24
		diceTrayArea.setFont(new Font("Courier New", 24));
		diceTrayArea.setEditable(false);
		everything.add(diceTrayArea, 1, 2);

		userInputArea = new TextArea();
		// Make userInputArea the least width

		userInputArea.setMaxWidth(150);
		userInputArea.setMaxHeight(250);

		userInputArea.setWrapText(true);
		userInputArea.setEditable(true);
		everything.add(userInputArea, 2, 2);

		resultArea = new TextArea();
		// Make resultArea the widest width
		resultArea.setMaxWidth(450);
		resultArea.setMaxHeight(250);
		resultArea.setEditable(false);
		resultArea.setWrapText(true);
		everything.add(resultArea, 3, 2);

	}

	private class NewGameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			startNewGame();
			userInputArea.setEditable(true);

		}
	}

	private class EndGameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			String[] userWords = userInputArea.getText().split(" ");
			for (String word : userWords) {
				game.processGuess(word);
			}

			resultArea.setText(game.getResults());
			userInputArea.setEditable(false);
		}
	}

}
