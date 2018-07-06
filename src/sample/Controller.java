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

    private Poz poz1 = new Poz();
    private Poz poz2 = new Poz();

    public Controller() throws IOException {
    }


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
        poz1.init(getCallsignTextField());
        poz1.findingIndex(getFirstLineTextField(), getSecondLineTextField());

        try {
            poz1.readTable("/home/vovan/Projects/Pet-project callsign/file_table.txt");
        } catch (IOException e) {
            System.out.println("Ошибка здесь!!! В адресе к таблице");
            e.printStackTrace();
        }

        poz1.splitTable();
        setCallsignDayLabel(poz1.finding());


        poz2.init(getCallsignDayLabel());
        poz2.findingIndex(getFirstLineTextField(), getSecondLineTextField());

        try {
            poz2.readTable("/home/vovan/Projects/Pet-project callsign/file_table.txt");
        } catch (IOException e) {
            System.out.println("Ошибка здесь!!!");
            e.printStackTrace();
        }

        poz2.splitTable();
        setCallsignNightLabel(poz2.finding());

    }


}
