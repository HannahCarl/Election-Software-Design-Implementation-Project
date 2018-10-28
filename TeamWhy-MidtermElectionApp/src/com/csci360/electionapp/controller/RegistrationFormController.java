package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import com.csci360.electionapp.model.RegisteringSession;

public class RegistrationFormController {
	
	@FXML
    private CheckBox usCitizenCheckBoxYes;
	@FXML
    private CheckBox usCitizenCheckBoxNo;
	@FXML
    private CheckBox ageCheckBoxYes;
	@FXML
    private CheckBox ageCheckBoxNo;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField midIntField;
    @FXML
    private TextField suffixField;
    @FXML
    private ChoiceBox sexChoiceBox;
    @FXML
    private TextField raceField;
    @FXML
    private TextField socSecField;
    @FXML
    private TextField birthDateField;
    @FXML
    private TextField homeAddStreetField;
    @FXML
    private TextField homeAddAptNumField;
    @FXML
    private TextField homeAddCityField;
    @FXML
    private TextField homeAddStateField;
    @FXML
    private TextField homeAddZipField;
    @FXML
    private TextField mailAddStreetField;
    @FXML
    private TextField mailAddAptNumField;
    @FXML
    private TextField mailAddCityField;
    @FXML
    private TextField mailAddStateField;
    @FXML
    private TextField mailAddZipField;
    @FXML
    private TextField homePhoneField;
    @FXML
    private TextField cellPhoneField;
    @FXML
    private Button submitButton;
    @FXML
    private Button goBackButton;
    
    private Stage dialogueStage;
    private Registrant registrant;
    private RegistrantList registrantList;
    private RegisteringSession rSession;
    private boolean submitClicked = false;

    private MainApp mainApp;
    
    @FXML
    private void initialize(){
    }

    public void setDialogueStage(Stage dialogueStage){
        this.dialogueStage = dialogueStage;
    }
    
    /*public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add registrantList data to the controller
        registrantList = mainApp.getRegistrantList();
    }*/

    public boolean isSubmitClicked(){
        return submitClicked;
    }
    
    /*@FXML
    private void handleSubmit(){
        if (isInputValid()){
            rSession = new RegisteringSession(firstNameField.getText(),lastNameField.getText(),socSecField.getText(),registrantList);

            submitClicked = true;
            System.out.println("Login successful.");

        }
    }*/
    
    private boolean isInputValid(){
        String errorMessage = "";
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0){
            errorMessage += "No valid first name provided.\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0){
            errorMessage += "No valid last name provided.\n";
        }
        if (socSecField.getText() == null || socSecField.getText().length() == 0){
            errorMessage += "No valid social security number.\n";
        }

     

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogueStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
