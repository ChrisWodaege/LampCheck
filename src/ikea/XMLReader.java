/*
 * XMLReader
 * Gets entries from XML-dataset
 *
 * @author 	Chris Wodäge
 *
 * @version 1.0
 *
 * @since   2014-03-31
 */

package ikea;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ikea.view.GUIExceptionWindow;

public class XMLReader {

	private static String entry;
	private static boolean found = false;
	private String filePath = "D://java//LampCheckClean//LampCheck2//bin//ikea//LampsDB.xml";
	File xmlFile = new File(filePath);
	private String[] output = new String[3];

	/*
	 * Constructor gets String data from GUIMainFrame class
	 */

	public XMLReader(String entry) {
		XMLReader.entry = entry;
	}

	/*
	 * public String[] output() method iterates through XML-dataset if entry
	 * found in XML-file, it returns the three elements name, farbe and
	 * "Lampe ist zu Prüfen" in a String-array if not, the method returns
	 * "Lampe entsorgen" an two empty Strings
	 */

	public String[] output() throws Exception {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("modell");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (entry.equals(eElement.getElementsByTagName("artikelnummer").item(0).getTextContent())) {

						output[0] = eElement.getElementsByTagName("name").item(0).getTextContent();
						output[1] = eElement.getElementsByTagName("farbe").item(0).getTextContent();
						output[2] = "Lampe ist zu Prüfen";

						found = true;
						break;
					}

					if (entry.equals(eElement.getElementsByTagName("gerätenummer").item(0).getTextContent())) {

						output[0] = eElement.getElementsByTagName("name").item(0).getTextContent();
						output[1] = eElement.getElementsByTagName("farbe").item(0).getTextContent();
						output[2] = "Lampe ist zu Prüfen";

						found = true;
						break;
					}
				}
			}

			if (found == false) {

				output[0] = "Lampe entsorgen";
				output[1] = " ";
				output[2] = " ";
			}

			/*
			 * If fileNotFound exception causes, new exception window will
			 * instantiate
			 */

		} catch (FileNotFoundException e) {

			GUIExceptionWindow fileNotFound = new GUIExceptionWindow("Datei LampsDB.xml nicht gefunden!",
					"bitte kopiere die LampsDB.xml in den Dateipfad:\n "
							+ "RETDE324-NT0001.ikea.com/Projects/Green/E_Geräte/LampCheck/LampsDB",
					e.toString());
			fileNotFound.start(null);

			e.printStackTrace();
		}
		return output;
	}

	/*
	 * getter-method for boolean: found entry in XML-dataset
	 */

	public static boolean isFound() {
		return found;
	}

}
