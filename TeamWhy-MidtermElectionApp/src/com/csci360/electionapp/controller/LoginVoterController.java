package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import com.csci360.electionapp.model.VotingSession;

public class LoginVoterController {

    @FXML
    private TextField voterIDField;
    @FXML
    private TextField socSecField;
    @FXML
    private Button submitButton;

    private Stage dialogueStage;
    private Voter voter;
    private VoterList voterList;
    private VotingSession session;
    private boolean submitClicked = false;

    private MainApp mainApp;

    @FXML
    private void initialize(){
    }

    public void setDialogueStage(Stage dialogueStage){
        this.dialogueStage = dialogueStage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add voterList list data to the list in the controller
        voterList = mainApp.getVoterList();
    }

    public boolean isSubmitClicked(){
        return submitClicked;
    }

    @FXML
    private void handleSubmit(){
        if (isInputValid()){
            session = new VotingSession(voterIDField.getText(),socSecField.getText(),voterList);

            submitClicked = true;
            System.out.println("Login successful.");

        }
    }

    private boolean isInputValid(){
        String errorMessage = "";
        if (voterIDField.getText() == null || voterIDField.getText().length() == 0){
            errorMessage += "No valid voter ID.\n";
        }
        if (socSecField.getText() == null || socSecField.getText().length() == 0){
            errorMessage += "No valid social security number.\n";
        }

        if (errorMessage.length() == 0 && (!voterList.checkForVoter(voterIDField.getText(),socSecField.getText()))){
            errorMessage += "Invalid login.\n";
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
