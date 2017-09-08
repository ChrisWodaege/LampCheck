/*
 * GUIMainFrame
 * Extends Application and overrides the method public void start()
 *
 * @author 	Chris Wodäge
 *
 * @version 1.0
 *
 * @since   2014-03-31
 */

package ikea.view;

import ikea.XMLReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIMainFrame extends Application {

	private String[] output = null;
	private String input;
	private String[] fullOutput;
	private int entryLength;
	private int count = 0;

	/*
	 * Builds the GUI and starts the MainFrame
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {

		/*
		 * New GUI elements
		 */

		final TextField fieldInput = new TextField();
		Button buttonCheck = new Button("Check");
		Button buttonTableView = new Button("Datensatz aufrufen");
		final Label labelOutput0 = new Label();
		final Label labelOutput1 = new Label();
		final Label labelOutput2 = new Label();

		/*
		 * Adds the GUI elements to the scene
		 */

		VBox container = new VBox();
		container.setSpacing(10);
		container.setPadding(new Insets(50, 0, 0, 50));
		container.getChildren().addAll(fieldInput, buttonCheck, buttonTableView, labelOutput0, labelOutput1,
				labelOutput2);

		/*
		 * Defines the Layout
		 */

		fieldInput.setMinWidth(400.0);
		fieldInput.setPrefWidth(400.0);
		fieldInput.setMaxWidth(400.0);
		fieldInput.setPromptText("Artikelnummer oder Gerätenummer (A1234) eingeben");
		fieldInput.setFocusTraversable(false);

		labelOutput0.setStyle("-fx-font-size: 15pt;");
		labelOutput1.setStyle("-fx-font-size: 15pt;");
		labelOutput2.setStyle("-fx-font-size: 15pt;");

		/*
		 * Initialises and starts the scene with GUI Elements
		 */

		Scene scene = new Scene(container, 600, 350);
		primaryStage.setTitle("LampenCheck by Chris Wodäge");
		primaryStage.setScene(scene);
		primaryStage.show();

		/*
		 * Initialises and starts the scene with GUI Elements
		 */

		buttonCheck.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				input = fieldInput.getText();

				if (input.length() < 8) {
					entryLength = input.length();
				} else {
					entryLength = 8;
				}

				XMLReader entry = new XMLReader(input.trim().substring(0, entryLength));

				try {
					output = entry.output();
				} catch (Exception e) {

					e.printStackTrace();
				}
				fullOutput = new String[3];
				for (String text : output) {
					if (count == 3) {
						count = 0;
					}
					fullOutput[count] = text;

					if (count == 0) {
						labelOutput0.setText(fullOutput[count]);
					}
					if (count == 1) {
						labelOutput1.setText(fullOutput[count]);
					}
					if (count == 2) {
						labelOutput2.setText(fullOutput[count]);
					}

					count++;
				}

				fieldInput.setText(input.trim().substring(0, entryLength));

			}

		});

		/*
		 * Call Button view Table
		 */

		buttonTableView.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
					GUITableView startTableView = new GUITableView();
				try {
					startTableView.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		/*
		 * next
		 */
	}

}
