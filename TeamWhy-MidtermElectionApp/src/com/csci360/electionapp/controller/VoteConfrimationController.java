package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import com.csci360.electionapp.model.VotingSession;

import java.io.IOException;

public class VoteConfrimationController {

    @FXML
    private Button cancel;
    @FXML
    private Button Submit;
    @FXML
    private Label can_name;
    @FXML
    private Label can_title;


    private MainApp mainApp;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void voteConfirm () throws IOException {

        mainApp.showVoteConfirm();

    }

    public  void voteCancel () throws IOException {

        mainApp.showCanSelect();

    }

}
