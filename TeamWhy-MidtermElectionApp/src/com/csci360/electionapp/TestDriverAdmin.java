package com.csci360.electionapp;

import javafx.application.Application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.csci360.electionapp.controller.RegistrationFormController;
import com.csci360.electionapp.controller.AdminLoginController;
import com.csci360.electionapp.controller.AdminMenuController;
import com.csci360.electionapp.controller.LoginRegistrantController;
import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.AdminList;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class TestDriverAdmin extends Application {
	

	private Stage primaryStage;
    private BorderPane rootLayout;

    private AdminList adminList = new AdminList();
    
    public TestDriverAdmin(){
    	adminList.addAdmin(new Admin("smithJohn", "123ABC"));
        /*try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/registrantList.txt"))){
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] regFromList = line.split("[,]");

        		registrantList.addRegistrant(new Registrant(regFromList[0],regFromList[1],regFromList[2],regFromList[3],"", regFromList[4],"", "",new Date(), "", "", "", "", true, true));
        		//System.out.println(regFromList[0] +" "+regFromList[1]+" "+regFromList[2]+" "+regFromList[3]+" "+regFromList[4]);
        	}
        	
        	
        }
        catch(IOException ex) {
    		
    	}*/
    }
    
    public AdminList getAdminList() {
        return adminList;
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Admin App");

        initRootLayout();

        showLoginAdmin();
        
		
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
     * Show LoginAdmin Screen
     */
    public void showLoginAdmin() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverAdmin.class.getResource("view/Login_A.fxml"));
            AnchorPane loginAdmin = (AnchorPane) loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter(loginAdmin);

            // Give the controller access to the main app.
            AdminLoginController controller = loader.getController();
            controller.setTestDriverAdmin(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Show Admin Menu Screen
     */
    public void showAdminMenuScreen() {
    	try {
        	
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverAdmin.class.getResource("view/admin_menu.fxml"));
            AnchorPane adminMenu = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(adminMenu);
            
         // Give the controller access to the admin menu
            AdminMenuController controller = loader.getController();
            controller.setTestDriverAdmin(this);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }

}

