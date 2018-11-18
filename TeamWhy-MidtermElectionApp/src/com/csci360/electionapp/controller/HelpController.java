package com.csci360.electionapp.controller;

import com.csci360.electionapp.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelpController {

    @FXML
    private Button helpCloseB;

    private MainApp mainApp;

    @FXML
    private void initialize(){
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void helpClose(ActionEvent event) throws IOException {



    }


}
