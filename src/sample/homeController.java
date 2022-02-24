package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class homeController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button startButton;
    @FXML
    private TextField nameTextField;


    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void startButtonOnAction(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            Parent root = (Parent) loader.load();
            calculatorController secController = loader.getController();
            secController.setLabelName(nameTextField.getText());

            Stage updateStage = new Stage();
            updateStage.initStyle(StageStyle.UNDECORATED);
            updateStage.setScene(new Scene(root, 600, 400));
            updateStage.show();
        }catch(Exception e){
            e.getCause();
            e.printStackTrace();
        }
    }

//    public void myFunction(String text){
//        initialLabel = text;
//    }

}
