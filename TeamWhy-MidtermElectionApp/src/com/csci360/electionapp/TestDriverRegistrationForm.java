package com.csci360.electionapp;

import com.csci360.electionapp.controller.LoginVoterController;
import com.csci360.electionapp.controller.RegistrationFormController;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import com.csci360.electionapp.controller.LoginRegistrantController;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class TestDriverRegistrationForm extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;

    private RegistrantList registrantList = new RegistrantList();
    
    public TestDriverRegistrationForm(){
        registrantList.addRegistrant(new Registrant("vote123", "John", "Smith", 'M', "1234567890", "male", new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress", true, true));
    }
    
    public RegistrantList getRegistrantList() {
        return registrantList;
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Registration App");

        initRootLayout();

        showLoginRegistrant();
		
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
     * Show LoginRegistrant Screen
     */
    public void showLoginRegistrant() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverRegistrationForm.class.getResource("view/Login_V_Register.fxml"));
            AnchorPane loginRegistrant = (AnchorPane) loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter(loginRegistrant);

            // Give the controller access to the main app.
            LoginRegistrantController controller = loader.getController();
            controller.setTestDriverRegistrationForm(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void showForm01Registrant() {
        try {
        	initRootLayout();
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverRegistrationForm.class.getResource("view/Registration01_Question.fxml"));
            AnchorPane regForm01 = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(regForm01);
            
         // Give the controller access to the reg form
            RegistrationFormController controller = loader.getController();
            controller.setTestDriverRegistrationForm(this);
            
         

            

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    public static void main(String[] args) {
        launch(args);
    }

}
