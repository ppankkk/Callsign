package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller {
    @FXML
    private  TextField firstLineTextField;
    @FXML
    private  TextField secondLineTextField;


    @FXML
    public TextField callsignTextField;


    @FXML
    private Label callsignDayLabel;
    @FXML
    private Label callsignNightLabel;





    public String getFirstLineTextField() {
        return firstLineTextField.getText();
    }
    public  String getSecondLineTextField() {
        return secondLineTextField.getText();
    }

    public String getCallsignTextField() {
        return callsignTextField.getText();
    }

    public void setCallsignDayLabel (String str) {
        callsignDayLabel.setText(str);
    }

    public String getCallsignDayLabel() {
        return callsignDayLabel.getText();
    }

    public void setCallsignNightLabel (String str) {
        callsignNightLabel.setText(str);
    }

    @FXML
    public void findingPozivnoi (ActionEvent event) throws Exception {
        Poz cals = new Poz();
        setCallsignDayLabel(cals.resultCallsign());

    }


}
