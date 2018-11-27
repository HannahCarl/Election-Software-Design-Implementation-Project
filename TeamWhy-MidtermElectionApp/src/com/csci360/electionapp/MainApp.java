package com.csci360.electionapp;

import com.csci360.electionapp.controller.*;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterList;
import com.csci360.electionapp.model.Admin;
import com.csci360.electionapp.model.AdminList;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import com.csci360.electionapp.model.ResultsDisplay;
import com.csci360.electionapp.model.MachineDisplay;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Font;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class MainApp extends Application {

    public Stage primaryStage; // Changed to Public ---- Levi ----
    public Stage helpStage;
    private BorderPane rootLayout;
    private BorderPane helpLayout;

    private VoterList voterList = new VoterList();
    private RegistrantList registrantList = new RegistrantList();
    private AdminList adminList = new AdminList();
    private ResultsDisplay resDisplay = new ResultsDisplay("","");
    private MachineDisplay macDisplay = new MachineDisplay("","");
    private TableView<ResultsDisplay> tableVotesSenate = new TableView<ResultsDisplay>();
    private TableView<ResultsDisplay> tableVotesHouse = new TableView<ResultsDisplay>();
    private TableView<ResultsDisplay> tableVotesPresident = new TableView<ResultsDisplay>();
    private TableView<MachineDisplay> macVotes = new TableView<MachineDisplay>();
   

    public MainApp(){
    	
    	buildAdminList();
    	buildRegistrantList();
    	voterList.addVoter(new Voter("1", "firstname", "lastname", 'M', "000110000", "male", new Date(), "444-444-4444", "444-444-4444", "homeAddress", "mailingAddress"));
    }
    
    public void buildAdminList() {
    	//String hashPassword;
    	try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/adminList.txt"))){
	    	String line;
	    	//File file = new File("out/salt.txt");
    		//file.delete();
	    	while ((line = br.readLine()) != null) {
	    		String[] adminFromList = line.split("[,]");
	    		
	    		//hashPassword = adminList.generatePasswordID(adminFromList[1].toString());
	    		//System.out.println(hashPassword);
	    		
	    		adminList.addAdmin(new Admin(adminFromList[0],adminFromList[1]));
    	}
	    	
	    	br.close();
    	
    	}
    	/*catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }*/
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	
    	
    }
    
    public void buildRegistrantList() {
    	try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/registrantList.txt"))){
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] regFromList = line.split("[,]");

        		registrantList.addRegistrant(new Registrant(regFromList[0],regFromList[1],regFromList[2],regFromList[3],"", regFromList[4],"", "",new Date(), "", "", "", "", true, true));
        		
        	}
        	
        	
        }
        catch(IOException ex) {
    		
    	}
    	
    }

    public VoterList getVoterList() {
        return voterList;
    }
    
    public RegistrantList getRegistrantList() {
        return registrantList;
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
            loader.setLocation( MainApp.class.getResource( "view/Login_V_Voting.fxml" ) );
            AnchorPane loginVoter = (AnchorPane) loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( loginVoter );

            // Give the controller access to the main app.
            LoginVoterController controller = loader.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Show Login Confirm ---- Levi ----

    public void showLoginConfirm () {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation( MainApp.class.getResource( "view/LoginConfirmation.fxml" ) );
            AnchorPane loginConfirm = (AnchorPane) loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( loginConfirm );

            // Give the controller access to the main app.
            LoginConfirmController controller = loader.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Open Admin Login ---- Levi ----
    public void showAdminLogin () throws IOException {

        try {
            // Load person overview.
            FXMLLoader adminLoad = new FXMLLoader();
            adminLoad.setLocation( MainApp.class.getResource( "view/Login_A.fxml" ) );
            AnchorPane adminLogin = adminLoad.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( adminLogin );

            // Give the controller access to the main app.
            AdminLoginController controller = adminLoad.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public AdminList getAdminList() {
        return adminList;
    }

    // Show Admin Menu

    public void showAdminMenu() {

        try {
        	// Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestDriverAdmin.class.getResource("view/admin_menu.fxml"));
            AnchorPane adminMenu = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(adminMenu);
            
         // Give the controller access to the admin menu
            AdminMenuController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
 // Show Election results

    public void showViewResults() {
    	Stage stage = new Stage();
    	Scene scene = new Scene(new Group());
    	stage.setTitle("Voting Results");
    	stage.setWidth(1100);
    	stage.setHeight(400);
    	//final Label label = new Label("Vote Results");
    	
    	ObservableList<ResultsDisplay> resultsArrayListSenate = resDisplay.buildListSenate();
    	ObservableList<ResultsDisplay> resultsArrayListHouse = resDisplay.buildListHouse();
    	ObservableList<ResultsDisplay> resultsArrayListPresident = resDisplay.buildListPresident();
    	ObservableList<MachineDisplay> machineArrayList = macDisplay.buildList();
    			
    	tableVotesSenate.setEditable(true);
    	tableVotesHouse.setEditable(true);
    	tableVotesPresident.setEditable(true);
    	macVotes.setEditable(true);
    	
    	TableColumn candColSenate = new TableColumn("Senate Candidate");
    	candColSenate.setMinWidth(150);
    	candColSenate.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candName"));
    	
    	TableColumn candVotesColSenate = new TableColumn("# of Votes");
    	candVotesColSenate.setMinWidth(100);
    	candVotesColSenate.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candVotes"));
    	
    	TableColumn candColHouse = new TableColumn("House Candidate");
    	candColHouse.setMinWidth(150);
    	candColHouse.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candName"));
    	
    	TableColumn candVotesColHouse = new TableColumn("# of Votes");
    	candVotesColHouse.setMinWidth(100);
    	candVotesColHouse.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candVotes"));
    	
    	TableColumn candColPresident = new TableColumn("Presidential Candidate");
    	candColPresident.setMinWidth(150);
    	candColPresident.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candName"));
    	
    	TableColumn candVotesColPresident = new TableColumn("# of Votes");
    	candVotesColPresident.setMinWidth(100);
    	candVotesColPresident.setCellValueFactory(new PropertyValueFactory<ResultsDisplay, String>("candVotes"));
    	
    	TableColumn macCol = new TableColumn("Machine");
    	macCol.setMinWidth(100);
    	macCol.setCellValueFactory(new PropertyValueFactory<MachineDisplay, String>("machineNum"));
    	
    	TableColumn macVoteCol = new TableColumn("# of Votes");
    	macVoteCol.setMinWidth(100);
    	macVoteCol.setCellValueFactory(new PropertyValueFactory<MachineDisplay, String>("machineVotes"));
    	
    	tableVotesSenate.getColumns().clear();
    	tableVotesHouse.getColumns().clear();
    	tableVotesPresident.getColumns().clear();
    	macVotes.getColumns().clear();
    	
    	tableVotesSenate.setItems(resultsArrayListSenate);
    	tableVotesSenate.getColumns().addAll(candColSenate, candVotesColSenate);
    	
    	tableVotesHouse.setItems(resultsArrayListHouse);
    	tableVotesHouse.getColumns().addAll(candColHouse, candVotesColHouse);
    	
    	tableVotesPresident.setItems(resultsArrayListPresident);
    	tableVotesPresident.getColumns().addAll(candColPresident, candVotesColPresident);
    	
    	macVotes.setItems(machineArrayList);
    	macVotes.getColumns().addAll(macCol,macVoteCol);
    	
    	GridPane gridPane = new GridPane();
    	gridPane.setHgap(10);
    	gridPane.setVgap(10);
    	gridPane.add(tableVotesSenate, 0, 0, 1, 1);
    	gridPane.add(tableVotesHouse, 1, 0, 1, 1);
    	gridPane.add(tableVotesPresident, 2, 0, 1, 1);
    	gridPane.add(macVotes, 3, 0, 1, 1);
    	((Group) scene.getRoot()).getChildren().addAll(gridPane);
    	
    	stage.setScene(scene);
    	stage.show();
    
    }


    // Show Can_select_ui on Submit ---- Levi ----
    public void showCanSelect() throws IOException {
        try {
            // Load person overview.
            FXMLLoader can_select_loader = new FXMLLoader();
            can_select_loader.setLocation( MainApp.class.getResource( "view/can_select_ui.fxml" ) );
            AnchorPane canSelect = can_select_loader.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( canSelect );

            // Give the controller access to the main app.
            CanSelectController controller = can_select_loader.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Confirm Single Can Vote ---- Levi ----

    public void showSingleVConfirm () throws IOException{
        try {
            // Load person overview.
            FXMLLoader confirmOne = new FXMLLoader();
            confirmOne.setLocation( MainApp.class.getResource( "view/VoteConfirmation.fxml" ) );
            AnchorPane oneVoteCon = confirmOne.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( oneVoteCon );

            // Give the controller access to the main app.
            VoteConfrimationController controller = confirmOne.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Confirm Vote Submission ---- Levi ----

    public void showVoteConfirm () throws IOException{
        try {
            // Load person overview.
            FXMLLoader confirm = new FXMLLoader();
            confirm.setLocation( MainApp.class.getResource( "view/VoteSubmissionConfirmation.fxml" ) );
            AnchorPane voteSubCon = confirm.load();

            // Set login into the center of root layout.
            rootLayout.setCenter( voteSubCon );

            // Give the controller access to the main app.
            VoteSubConController controller = confirm.getController();
            controller.setMainApp( this );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Opens Help in new Window ---- Levi ----
    
    public void showHelp() throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Instruction_HowToVote.fxml"));
    	Parent helpRoot = (Parent) fxmlLoader.load();
    	helpStage = new Stage();
    	helpStage.setScene(new Scene(helpRoot));
    	helpStage.show();
    	
    }
    
    //Closes Help window ---- Levi ----
    public void closeHelp() {
    	
    	
    	
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
            controller.setMainApp(this);

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
            controller.setMainApp(this);

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
            controller.setMainApp(this);

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
            loader.setLocation(TestDriverRegistrationForm.class.getResource("view/RegistrationConfirmation.fxml"));
            AnchorPane regForm03 = (AnchorPane) loader.load();

            // Set form into the center of root layout.
            rootLayout.setCenter(regForm03);
            
         // Give the controller access to the reg form
            RegistrationFormController controller = loader.getController();
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

