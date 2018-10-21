package com.csci360.electionapp;

import com.csci360.electionapp.controller.LoginVoterController;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import

import java.io.IOException;
import java.util.Date;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private VoterList voterList = new VoterList();

    public MainApp(){
        voterList.addVoter(new Voter("1", "firstname", "lastname", 'M', "000110000", "male", new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress"));
    }

    public VoterList getVoterList() {
        return voterList;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Voting App");

        initRootLayout();

        showLoginVoter();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Show LoginVoter Screen
     */
    public void showLoginVoter() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login_V_Voting.fxml"));
            AnchorPane loginVoter = (AnchorPane) loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter(loginVoter);

            // Give the controller access to the main app.
            LoginVoterController controller = loader.getController();
            controller.setMainApp(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

