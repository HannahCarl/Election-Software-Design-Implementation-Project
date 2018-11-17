package com.csci360.electionapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.csci360.electionapp.controller.RegistrationFormController;
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
    	registrantList.addRegistrant(new Registrant("vote123", "John", "Smith", "M", "Jr", "1234567890", "male", "Hispanic",new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress", true, true));
        try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/registrantList.txt"))){
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] regFromList = line.split("[,]");

        		registrantList.addRegistrant(new Registrant(regFromList[0],regFromList[1],regFromList[2],regFromList[3],"", regFromList[4],"", "",new Date(), "", "", "", "", true, true));
        		System.out.println(regFromList[0] +" "+regFromList[1]+" "+regFromList[2]+" "+regFromList[3]+" "+regFromList[4]);
        	}
        	
        	
        }
        catch(IOException ex) {
    		
    	}
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
        //showForm01Registrant();
		
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
    /**
     * Show Registration01_Question Screen
     */
    public void showForm01Registrant() {
        try {
        	
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
    }
    
    /**
     * Show Registration02_Form Screen
     */
    public void showForm02Registrant() {
        try {
        	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverRegistrationForm.class.getResource("view/Registration02_Form.fxml"));
            AnchorPane regForm02 = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(regForm02);
            
         // Give the controller access to the reg form
            RegistrationFormController controller = loader.getController();
            controller.setTestDriverRegistrationForm(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Show Registration03_InfoConfirm Screen
     */
    public void showForm03Registrant() {
        try {
        	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverRegistrationForm.class.getResource("view/Registration03_InfoConfirm.fxml"));
            AnchorPane regForm03 = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(regForm03);
            
         // Give the controller access to the reg form
            RegistrationFormController controller = loader.getController();
            controller.setTestDriverRegistrationForm(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }

}
