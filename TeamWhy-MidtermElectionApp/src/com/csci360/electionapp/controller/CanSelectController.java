package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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


    private String can_name;
    private String can_title;
    private int can_ID;

    @FXML
    private void initialize(){
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    // ------------- P ---------------
    public void select_canidate_1 () throws IOException {

        //ADD Information to pass to ballot class
        mainApp.showSingleVConfirm();

    }
    public void select_canidate_2 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_3 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_4 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_5 () throws IOException {


        mainApp.showSingleVConfirm();

    }
    public void select_canidate_writeIn () throws IOException {

        mainApp.showSingleVConfirm();

    }
    
 // ------------- Senate ---------------
    public void select_canidate_S_1 () throws IOException {

        //ADD Information to pass to ballot class
        mainApp.showSingleVConfirm();

    }
    public void select_canidate_S_2 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_S_3 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_S_4 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_S_5 () throws IOException {


        mainApp.showSingleVConfirm();

    }
    public void select_canidate_S_writeIn () throws IOException {

        mainApp.showSingleVConfirm();

    }
 // ------------- House ---------------
    public void select_canidate_H_1 () throws IOException {

        //ADD Information to pass to ballot class
        mainApp.showSingleVConfirm();

    }
    public void select_canidate_H_2 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_H_3 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_H_4 () throws IOException {

        mainApp.showSingleVConfirm();

    }
    public void select_canidate_H_5 () throws IOException {


        mainApp.showSingleVConfirm();

    }
    public void select_canidate_H_writeIn () throws IOException {

        mainApp.showSingleVConfirm();

    }
    
    public void helpButtonClick(ActionEvent event) throws IOException {

        mainApp.showHelp();

    }

}
