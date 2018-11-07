package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AdminLoginController {


    @FXML
    private Button submit;
    @FXML
    private Button back;


    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void returToVrLogin (ActionEvent event) throws IOException {

        mainApp.start( mainApp.primaryStage );

    }

    public void login () {

        if(true) {

            // ADD Login Check ---- Levi ----

            mainApp.showAdminMenu();

        }
        else {

        }


    }


}
