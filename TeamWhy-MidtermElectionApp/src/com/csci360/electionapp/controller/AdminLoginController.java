package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import com.csci360.electionapp.TestDriverAdmin;
import com.csci360.electionapp.TestDriverRegistrationForm;
import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.AdminList;
import com.csci360.electionapp.model.AdminSession;
import com.csci360.electionapp.model.RegisteringSession;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AdminLoginController {

	
	@FXML
	private TextField nameField;
	@FXML 
	private TextField idField;
    @FXML
    private Button submit;
    @FXML
    private Button back;


    private Stage dialogueStage;
    private Admin admin;
    private AdminList adminList;
    private AdminSession aSession;
    private boolean submitClicked = false;
    private boolean backClicked = false;

    private TestDriverAdmin testDriveAdmin;
    private MainApp mainApp;
    
    @FXML
    private void initialize(){
    }

    public void setDialogueStage(Stage dialogueStage){
        this.dialogueStage = dialogueStage;
    }

    public void setTestDriverAdmin(TestDriverAdmin tesDrAdForm) {
        this.testDriveAdmin = tesDrAdForm;

        // Add adminList data to the controller
        adminList = tesDrAdForm.getAdminList();
    }
    public void setMainApp(MainApp mainA) {
        this.mainApp = mainA;

        // Add adminList data to the controller
        adminList = mainA.getAdminList();
    }

    public boolean isSubmitClicked(){
        return submitClicked;
    }

    @FXML
    private void handleSubmit(){
        if (isInputValid()){
            aSession = new AdminSession(nameField.getText(),idField.getText(), adminList);

            submitClicked = true;
            System.out.println("Login successful.");
            mainApp.showAdminMenu();

        }
    }
    @FXML
    private void handleBack() throws IOException{
        
            backClicked = true;
            //System.out.println("Back successful.");
            mainApp.showLoginVoter();

        
    }

    private boolean isInputValid(){
        String errorMessage = "";
        if (nameField.getText() == null || nameField.getText().length() == 0){
            errorMessage += "No valid name provided.\n";
        }
        if (idField.getText() == null || idField.getText().length() == 0){
            errorMessage += "No valid ID provided.\n";
        }
        

        if (errorMessage.length() == 0 && (!adminList.checkForAdmin(nameField.getText(),idField.getText()))){
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


