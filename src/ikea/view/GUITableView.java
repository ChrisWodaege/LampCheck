package ikea.view;

import java.util.Optional;

import ikea.XMLTableReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUITableView {

	public void start(Stage primaryStage) throws Exception {
		// initialize gui elements
		Dialog<GUITableView> dialog = new Dialog<>();
		dialog.setTitle("Datensatz");
		dialog.setHeaderText("aktuell gespeicherte Lampen");
		dialog.setResizable(true);

		TableView<XMLTableReader> table = new TableView<XMLTableReader>();

		// Create column Artikelname (Data type of String).
		TableColumn<XMLTableReader, String> artNameCol
			= new TableColumn<XMLTableReader, String>("Artikelname");

		// Create column Beschreibung (Data type of String).
		TableColumn<XMLTableReader, String> descrCol
			= new TableColumn<XMLTableReader, String>("Beschreibung");

		// Create column Artikelnummer (Data type of String).
		TableColumn<XMLTableReader, String> artNrCol
			= new TableColumn<XMLTableReader, String>("Artikelnummer");

		// Create column Gerätenummer (Data type of String).
		TableColumn<XMLTableReader, String> typNrCol
			= new TableColumn<XMLTableReader, String>("Gerätenummer");

		// Defines how to fill data for each cell.
		// Get value from property of UserAccount.
		artNameCol.setCellValueFactory(new PropertyValueFactory<>("artName"));
		descrCol.setCellValueFactory(new PropertyValueFactory<>("descr"));
		artNrCol.setCellValueFactory(new PropertyValueFactory<>("artNr"));
		typNrCol.setCellValueFactory(new PropertyValueFactory<>("typNr"));

		 // Display row data
		ObservableList<XMLTableReader> list = getLampList();
		table.setItems(list);
		System.out.println(list);


		// add columns to table
		table.getColumns().addAll(artNameCol, descrCol, artNrCol, typNrCol);


		// add tabel an start dialog
		GridPane content = new GridPane();
		content.add(table, 1, 1);
		dialog.getDialogPane().setContent(content);
		ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		Optional<GUITableView> result = dialog.showAndWait();
	}

	private ObservableList<XMLTableReader> getLampList() {

		XMLTableReader lamp1 = new XMLTableReader("Ekarp", "Standleuchte", "12345678", "a1234");

		ObservableList<XMLTableReader> list = FXCollections.observableArrayList(lamp1);
	    return list;
	}
}
