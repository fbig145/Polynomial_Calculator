package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class calculatorController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField firstPolTextField;
    @FXML
    private TextField secondPolTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private Button derivativeButton;
    @FXML
    private Button integrateButton;


   // private String secondLabel;

    addPol polad = new addPol();
    subsPol polsub = new subsPol();
    derivative polder = new derivative();
    integration polinteg = new integration();

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void addButtonOnAction(ActionEvent event){
        resultLabel.setText("");
        polad.parseAndAdd(firstPolTextField.getText(), secondPolTextField.getText());
        resultLabel.setText(polad.resultString);
    }

    public void subtractButtonOnAction(ActionEvent event){
        resultLabel.setText("");
        polsub.parseAndSub(firstPolTextField.getText(), secondPolTextField.getText());
        resultLabel.setText(polsub.resultString);
    }
    public void derivativeButtonOnAction(ActionEvent event){
        resultLabel.setText("");
        polder.parseAndDerivate(firstPolTextField.getText());
        resultLabel.setText(polder.resultString);
    }
    public void integrateButtonOnAction(ActionEvent event){
        resultLabel.setText("");
        polinteg.parseAndIntegrate(firstPolTextField.getText());
        resultLabel.setText(polinteg.resultString);
    }

    public void setLabelName(String text){
        nameLabel.setText(text);
    }


}
