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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AdminMenuController {
	
	@FXML
    private Button submit;
    @FXML
    private Button logOut;
    @FXML
    private Button back;
    @FXML
    private Button recount;
    @FXML
    private Button startRegistrationPeriod;
    @FXML
    private Button endRegistrationPeriod;
    @FXML
    private Button setUpNewElection;
    @FXML
    private Button startVotingPeriod;
    @FXML
    private Button endVotingPeriod;
    @FXML
    private Button viewResults;
    @FXML
    private TableView voteResults;
    @FXML
    private TableView totalVotes;
    
    private Stage dialogueStage;
    private AdminList adminList;
    private boolean submitClicked = false;
    private boolean logOutClicked = false;
    private boolean viewResultsClicked = false;
    private boolean backClicked = false;
    
    private TestDriverAdmin testDriveAdmin;
    private MainApp mainApp;
    
    
    @FXML
    private void initialize(){
	
    }
    @FXML
    private void handleLogOut() throws IOException{
        
            logOutClicked = true;
            //System.out.println("Logout successful.");
            mainApp.showAdminLogin();

        
    }
    @FXML
    private void handleViewResults() throws IOException{
        
            viewResultsClicked = true;
            
            
            
            mainApp.showViewResults();

        
    }
    @FXML
    private void handleBack() throws IOException{
        
            backClicked = true;
            
            mainApp.showAdminMenu();

        
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

}
