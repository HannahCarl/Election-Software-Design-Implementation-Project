package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import com.csci360.electionapp.model.Ballot;
import com.csci360.electionapp.model.Candidate;
import com.csci360.electionapp.model.Election;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.ArrayList;

public class CanSelectController {

    @FXML
    private Button helpButton;
    @FXML
    private Button can_1;
    @FXML
    private Button can_2;
    @FXML
    private Button can_3;
    @FXML
    private Button can_4;
    @FXML
    private Button can_5;
    @FXML
    private Button can_writeIn;
    @FXML
    private TextField writeIn;
    @FXML
    private Label office;

    private MainApp mainApp;
    
    private Stage dialogueStage;

    private String can_name;
    private String can_title;
    private int can_ID; 
    private ArrayList<Candidate> presList;
    private ArrayList<Candidate> senList;
    private ArrayList<Candidate> houseList;
    private Candidate presCand;
    private Candidate senCand;
    private Candidate houseCand;
    
    @FXML
    private void initialize(){
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.presList = mainApp.getElection().getCandidateListByFieldNumber(0);
        this.senList = mainApp.getElection().getCandidateListByFieldNumber(1);
        this.houseList = mainApp.getElection().getCandidateListByFieldNumber(2);
        this.presCand = mainApp.getPresCand();
        this.senCand = mainApp.getSenCand();
        this.houseCand = mainApp.getHouseCand();
        
    }

 // ------------- P ---------------
    public void select_canidate_1 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	presCand = presList.get(0);
        	mainApp.setPresCand(presCand);
        	mainApp.showSselect();
        	
        }

    }
    public void select_canidate_2 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	presCand = presList.get(1);
        	mainApp.setPresCand(presCand);
        	mainApp.showSselect();
        	
        }

    }
    public void select_canidate_3 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	presCand = presList.get(2);
        	mainApp.setPresCand(presCand);
        	mainApp.showSselect();
        	
        }

    }
    public void select_canidate_4 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	presCand = presList.get(3);
        	mainApp.setPresCand(presCand);
        	mainApp.showSselect();
        	
        }

    }
    public void select_canidate_writeIn () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	mainApp.showSselect();
        	
        }

    }
    
 // ------------- Senate ---------------
    public void select_canidate_S_1 () throws IOException {

        //ADD Information to pass to ballot class
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	senCand = senList.get(0);
        	mainApp.setSenCand(senCand);
        	mainApp.showHselect();
        	
        }

    }
    public void select_canidate_S_2 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	senCand = senList.get(1);
        	mainApp.setSenCand(senCand);
        	mainApp.showHselect();
        	
        }

    }
    public void select_canidate_S_3 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	senCand = senList.get(2);
        	mainApp.setSenCand(senCand);
        	mainApp.showHselect();
        	
        }

    }
    public void select_canidate_S_4 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	senCand = senList.get(3);
        	mainApp.setSenCand(senCand);
        	mainApp.showHselect();
        	
        }

    }
    public void select_canidate_S_writeIn () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	mainApp.showHselect();
        	
        }

    }
 // ------------- House ---------------
    public void select_canidate_H_1 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	houseCand = houseList.get(0);
        	mainApp.setHouseCand(houseCand);
        	Ballot ballot = new Ballot(mainApp.getVoter());
        	ballot.addVote(mainApp.getPresCand());
        	ballot.addVote(mainApp.getSenCand());
        	ballot.addVote(mainApp.getHouseCand());
        	Election election = mainApp.getElection();
        	election.castBallot(ballot);
        	mainApp.setElection(election);
        	
        	mainApp.showVoteConfirm ();
        	
        }

    }
    public void select_canidate_H_2 () throws IOException {
    	
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	houseCand = houseList.get(1);
        	mainApp.setHouseCand(houseCand);
        	Ballot ballot = new Ballot(mainApp.getVoter());
        	ballot.addVote(mainApp.getPresCand());
        	ballot.addVote(mainApp.getSenCand());
        	ballot.addVote(mainApp.getHouseCand());
        	Election election = mainApp.getElection();
        	election.castBallot(ballot);
        	mainApp.setElection(election);
        	
        	mainApp.showVoteConfirm ();
        	
        }
        
    	//mainApp.showVC_H();

    }
    public void select_canidate_H_3 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	houseCand = houseList.get(2);
        	mainApp.setHouseCand(houseCand);
        	Ballot ballot = new Ballot(mainApp.getVoter());
        	ballot.addVote(mainApp.getPresCand());
        	ballot.addVote(mainApp.getSenCand());
        	ballot.addVote(mainApp.getHouseCand());
        	Election election = mainApp.getElection();
        	election.castBallot(ballot);
        	mainApp.setElection(election);
        	
        	mainApp.showVoteConfirm ();
        	
        }

    }
    public void select_canidate_H_4 () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	houseCand = houseList.get(3);
        	mainApp.setHouseCand(houseCand);
        	Ballot ballot = new Ballot(mainApp.getVoter());
        	ballot.addVote(mainApp.getPresCand());
        	ballot.addVote(mainApp.getSenCand());
        	ballot.addVote(mainApp.getHouseCand());
        	Election election = mainApp.getElection();
        	election.castBallot(ballot);
        	mainApp.setElection(election);
        	
        	mainApp.showVoteConfirm ();
        	
        }

    }
    public void select_canidate_H_writeIn () throws IOException {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(dialogueStage);
        alert.setTitle("Confirm Information");
        alert.setHeaderText("Please confirm information");
        
        //Confirmation message
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	
        	mainApp.showVoteConfirm ();
        	
        }

    }
    
    public void helpButtonClick(ActionEvent event) throws IOException {

        mainApp.showHelp();

    }

}
