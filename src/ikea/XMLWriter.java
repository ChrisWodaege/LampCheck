package ikea;

import java.io.File;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLWriter {
	/*
	private String artikelname;
	private String beschreibung;
	private String artikelnummer;
	private String gerätenummer;
	private String[] input = new String[4];
	Element e = null;

	public XMLWriter(String artikelname, String beschreibung, String artikelnummer,
			String gerätenummer) throws Exception {
		this.artikelnummer = artikelnummer;
		this.beschreibung = beschreibung;
		this.artikelname = artikelname;
		this.gerätenummer = gerätenummer;
		//input();
		check();
	}

	public void check() {
		System.out.println(artikelname);
		System.out.println(beschreibung);
		System.out.println(artikelnummer);
		System.out.println(gerätenummer);
	}

	public String[] input() throws Exception {
		try {
			File xmlFile = new File("C:\\LampCheck\\LampsDB\\LampsDB.xml");
			if ()

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("modell");

			Element rootEle = (Element) doc.createElement("modell");

			e = (Element) doc.createElement(artikelname);


		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	} */
}
