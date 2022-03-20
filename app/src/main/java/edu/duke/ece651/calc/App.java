/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.duke.ece651.calc;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import edu.duke.ece651.calc.controller.CalculatorController;
import edu.duke.ece651.calc.controller.NumButtonController;
import edu.duke.ece651.calc.model.RPNStack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage stage) {
    URL xmlResources = getClass().getResource("/ui/calcbuttons.xml");
    URL cssResources = getClass().getResource("/ui/calcbuttons.css");
    try {
      RPNStack model = new RPNStack();
      FXMLLoader loader = new FXMLLoader(xmlResources);
      HashMap<Class<?>, Object> controllers = new HashMap<>();
      controllers.put(NumButtonController.class, new NumButtonController(model));
      controllers.put(CalculatorController.class, new CalculatorController());
      loader.setControllerFactory((c) -> {
          return controllers.get(c);
        });
      GridPane gp = loader.load();
      Scene s = new Scene(gp, 640, 480);
      s.getStylesheets().add(cssResources.toString());
      stage.setScene(s);
      stage.show();
    }

    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
