package ikea;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class XMLTableReader {

	private String artName;
	private String descr;
	private String artNr;
	private String typNr;

	public XMLTableReader(String artName, String descr, String artNr, String typNr) {
		this.artName = artName;
		this.descr = descr;
		this.artNr = artNr;
		this.typNr = typNr;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getArtNr() {
		return artNr;
	}

	public void setArtNr(String artNr) {
		this.artNr = artNr;
	}

	public String getTypNr() {
		return typNr;
	}



}
