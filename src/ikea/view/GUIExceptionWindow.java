package ikea.view;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GUIExceptionWindow extends Application {

	private String exceptionTitle;
	private String exceptionText;
	private String exceptionStackTrace;

	public GUIExceptionWindow(String exceptionTitle, String exceptionText, String exceptionStackTrace) {
		this.exceptionTitle = exceptionTitle;
		this.exceptionText = exceptionText;
		this.exceptionStackTrace = exceptionStackTrace;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(exceptionTitle);
		alert.setHeaderText(exceptionText);
		alert.setContentText(null);

		TextField exStackTrace = new TextField();
		exStackTrace.setEditable(false);
		exStackTrace.setMaxWidth(Double.MAX_VALUE);
		exStackTrace.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(exStackTrace, Priority.ALWAYS);
		GridPane.setHgrow(exStackTrace, Priority.ALWAYS);

		GridPane content = new GridPane();
		content.add(exStackTrace, 1, 1);
		exStackTrace.setText(exceptionStackTrace);
		alert.getDialogPane().setExpandableContent(content);

		alert.showAndWait();
		System.exit(0);
	}

}
