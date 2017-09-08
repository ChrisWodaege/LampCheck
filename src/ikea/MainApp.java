/*
 * MainApp
 * Starts the Application, lauchnes the GUI
 *
 * @author 	Chris Wodäge
 *
 * @version 1.0
 *
 * @since   2014-03-31
 */

package ikea;

import ikea.view.GUIMainFrame;
import javafx.application.Application;

public class MainApp {

	public static void main(String[] args) {

		Application.launch(GUIMainFrame.class, args);

	}

}