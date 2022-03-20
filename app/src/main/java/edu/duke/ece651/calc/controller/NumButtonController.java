package edu.duke.ece651.calc.controller;

import edu.duke.ece651.calc.model.RPNStack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NumButtonController {
  RPNStack model;
  @FXML
  TextField currentNumber;

  
  public NumButtonController(RPNStack model) {
    this.model = model;
  }
  
  
  void pushCurrentNumIfAny() {
    String s = currentNumber.getText().trim();
    if (!s.equals("")) {
      double d = Double.parseDouble(s);
      model.pushNum(d);
    }
    currentNumber.setText("");
  }

  public void onEnter(ActionEvent e) {
    pushCurrentNumIfAny();
  }
  

  @FXML
  public void onNumberButton(ActionEvent ae) {
    Object source = ae.getSource();
    if (source instanceof Button) {
      Button btn = (Button)source;
      currentNumber.setText(currentNumber.getText() + btn.getText());
    }

    else {
      throw new IllegalArgumentException();
    }
  }
}
