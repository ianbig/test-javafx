package edu.duke.ece651.calc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CalculatorController implements Initializable {
  @FXML
  TextField currentNumber;

  @FXML
  NumButtonController numButtonController;

  public void initialize(URL location, ResourceBundle resources) {
    numButtonController.currentNumber = currentNumber;
  }
}
