package com.csci360.electionapp.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.csci360.electionapp.MainApp;
import com.csci360.electionapp.TestDriverRegistrationForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Registrant;
import com.csci360.electionapp.model.RegistrantList;
import com.csci360.electionapp.model.AESEncryption;
import com.csci360.electionapp.model.RegisteringSession;

public class RegistrationFormController implements Initializable{
	
	@FXML
    private ChoiceBox usCitizenChoiceBox;
	@FXML
    private ChoiceBox ageChoiceBox;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField midIntField;
    @FXML
    private TextField suffixField;
    @FXML
    private ChoiceBox sexChoiceBox;
    @FXML
    private ChoiceBox raceChoiceBox;
    @FXML
    private TextField socSecField;
    @FXML
    private ChoiceBox birthMonthChoiceBox;
    @FXML
    private ChoiceBox birthDayChoiceBox;
    @FXML
    private ChoiceBox birthYearChoiceBox;
    @FXML
    private TextField homeAddStreetField;
    @FXML
    private TextField homeAddAptNumField;
    @FXML
    private TextField homeAddCityField;
    @FXML
    private ChoiceBox homeAddStateChoiceBox;
    @FXML
    private TextField homeAddZipField;
    @FXML
    private TextField mailAddStreetField;
    @FXML
    private TextField mailAddAptNumField;
    @FXML
    private TextField mailAddCityField;
    @FXML
    private ChoiceBox mailAddStateChoiceBox;
    @FXML
    private TextField mailAddZipField;
    @FXML
    private TextField homePhoneField;
    @FXML
    private TextField cellPhoneField;
    @FXML
    private Button submitButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Button continueButton;
    
    
    
    private Stage dialogueStage;
    private Registrant registrant;
    private RegistrantList registrantList;
    private RegisteringSession rSession;
    private boolean submitClicked = false;
    

    private TestDriverRegistrationForm testDriveRegForm;
    private AESEncryption aesObject = new AESEncryption();
    private MainApp mainApp;
    
    @FXML
    private void initialize(){
    	
	
    }
    

    public void setDialogueStage(Stage dialogueStage){
        this.dialogueStage = dialogueStage;
    }
    
    public void setTestDriverRegistrationForm(TestDriverRegistrationForm tesDrRegForm) {
        this.testDriveRegForm = tesDrRegForm;

        // Add registrantList data to the controller
        registrantList = tesDrRegForm.getRegistrantList();
    }
    
    public void setMainApp(MainApp mainA) {
    	this.mainApp = mainA;
    	
    	//Add registrantList data to the controller
    	registrantList = mainA.getRegistrantList();
    }

    public boolean isSubmitClicked(){
        return submitClicked;
    }
    
    @FXML
    private void handleSubmitQuestion(){
    	
        if (isInputValid()){
        	boolean willAppend = true;
        	try(BufferedWriter regQues = new BufferedWriter(new FileWriter("out/registrationInfo.txt", willAppend))){
           
            submitClicked = true;
            System.out.println("Questions submitted successfully.");
            
            
            
            mainApp.showForm02Registrant();
        	}
        	catch(IOException ex) {
        		
        	}

        }
    }
    @FXML
    private void handleSubmitForm() throws Exception{
        if (isInputValidForm()){
        	boolean willAppend = true;
        	boolean confirmClicked = false;
        	String encryptedLastName = "";
        	String encryptedFirstName = "";
        	String encryptedSocialSecurity = "";
        	String encryptedBirthDate = "";
        	String encryptedHomeAddStreet = "";
        	String encryptedHomeAptNum = "";
        	String encryptedHomeCity = "";
        	String encryptedHomeState = "";
        	String encryptedHomeZip = "";
        	String encryptedMailAddStreet = "";
        	String encryptedMailAptNum = "";
        	String encryptedMailCity = "";
        	String encryptedMailState = "";
        	String encryptedMailZip = "";
        	String encryptedHomePhone = "";
        	String encryptedCellPhone = "";
        	
        	final String secretKey = "Registrant2018AZTREQW";
        	String birthDate = "";
        	try(BufferedWriter regForm = new BufferedWriter(new FileWriter("out/registrationInfo.txt", willAppend))){
           
            submitClicked = true;
            
            
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(dialogueStage);
            alert.setTitle("Confirm Information");
            alert.setHeaderText("Please confirm information");
            
            //Confirmation message
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
            	mainApp.showForm03Registrant();
            
            	//Format birthdate to one string
            	birthDate += birthMonthChoiceBox.getValue().toString() + " ";
            	birthDate += birthDayChoiceBox.getValue().toString() + " ";
            	birthDate += birthYearChoiceBox.getValue().toString();
	            System.out.println("Form submitted successfully.");
	            
	            //Encrypt personal information
	            encryptedLastName = AESEncryption.encrypt(lastNameField.getText().toString(), secretKey);
	            encryptedFirstName = AESEncryption.encrypt(firstNameField.getText().toString(), secretKey);
	            encryptedSocialSecurity = AESEncryption.encrypt(socSecField.getText().toString(), secretKey);
	            encryptedHomeAddStreet = AESEncryption.encrypt(homeAddStreetField.getText().toString(), secretKey);
	            encryptedHomeAptNum = AESEncryption.encrypt(homeAddAptNumField.getText().toString(), secretKey);
	            encryptedHomeCity = AESEncryption.encrypt(homeAddCityField.getText().toString(), secretKey);
	            encryptedHomeState = AESEncryption.encrypt(homeAddStateChoiceBox.getValue().toString(), secretKey);
	            encryptedHomeZip = AESEncryption.encrypt(homeAddZipField.getText().toString(), secretKey);
	            encryptedMailAddStreet = AESEncryption.encrypt(mailAddStreetField.getText().toString(), secretKey);
	            encryptedMailAptNum = AESEncryption.encrypt(mailAddAptNumField.getText().toString(), secretKey);
	            encryptedMailCity = AESEncryption.encrypt(mailAddCityField.getText().toString(), secretKey);
	            encryptedMailState = AESEncryption.encrypt(mailAddStateChoiceBox.getValue().toString(), secretKey);
	            encryptedMailZip = AESEncryption.encrypt(mailAddZipField.getText().toString(), secretKey);
	            encryptedHomePhone = AESEncryption.encrypt(homePhoneField.getText().toString(), secretKey);
	            encryptedCellPhone = AESEncryption.encrypt(cellPhoneField.getText().toString(), secretKey);
	            encryptedBirthDate = AESEncryption.encrypt(birthDate, secretKey);
	            
	            
	            //Add information to registration form
	            regForm.append(encryptedLastName + ", ");
	            regForm.append(encryptedFirstName + ", ");
	            regForm.append(midIntField.getText() + ", ");
	            regForm.append(suffixField.getText() + ", ");
	            regForm.append(sexChoiceBox.getValue() + ", ");
	            regForm.append(raceChoiceBox.getValue() + ", ");
	            regForm.append(encryptedSocialSecurity + ", ");
	            regForm.append(encryptedBirthDate + ", ");
	            regForm.append(encryptedHomeAddStreet + ", ");
	            regForm.append(encryptedHomeAptNum + ", ");
	            regForm.append(encryptedHomeCity + ", ");
	            regForm.append(encryptedHomeState + ", ");
	            regForm.append(encryptedHomeZip + ", ");
	            regForm.append(encryptedMailAddStreet + ", ");
	            regForm.append(encryptedMailAptNum + ", ");
	            regForm.append(encryptedMailCity + ", ");
	            regForm.append(encryptedMailState + ", ");
	            regForm.append(encryptedMailZip + ", ");
	            regForm.append(encryptedHomePhone + ", ");
	            regForm.append(encryptedCellPhone);
	            regForm.newLine();
            
            }
            
            }
            catch(IOException ex) {
            	
            	ex.printStackTrace();
        		
        	}
            
        	}
        	

        }
    
    @FXML
    private void handleSubmitInfoConfirm(){
        
           
            submitClicked = true;
            System.out.println("Info Confirm submitted successfully.");
            
            
            mainApp.showLoginRegistrant();

        
    }
    
    public boolean isInputValid(){
    	
        String errorMessage = "";
        
        if(usCitizenChoiceBox.getValue().toString().equals("No") ) {
        	
        	errorMessage += "You must be a citizen to register. Please check with a staff member to continue.\n";
        }
        if(ageChoiceBox.getValue().toString().equals("No") ) {
        	errorMessage += "You must be 18 years old to register. Please check with a staff member to continue.\n";
        	
        }
        
        
     

        if (errorMessage.length() == 0) {
        	
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogueStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
public boolean isInputValidForm(){
    	
        String errorMessage = "";
        
        
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0){
            errorMessage += "No valid first name provided.\n";
        }
        if (firstNameField.getText().toString().matches("[a-zA-Z]+") == false) {
        	errorMessage += "Please enter a first name with letters only and no spaces.\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0){
            errorMessage += "No valid first name provided.\n";
        }
        if (lastNameField.getText().toString().matches("[a-zA-Z]+") == false) {
        	errorMessage += "Please enter a last name with letters only and no spaces.\n";
        }
        if (midIntField.getText() != null && midIntField.getText().length() != 0){  
        	if (midIntField.getText().toString().matches("[a-zA-Z]+") == false) {
	        	errorMessage += "Please enter a middle initial with a letter only and no spaces.\n";
	        }
        }
        if (suffixField.getText() != null && suffixField.getText().length() != 0){ 
	        if (suffixField.getText().toString().matches("[a-zA-Z]+") == false) {
	        	errorMessage += "Please enter a suffix with letters only and no spaces.\n";
	        }
        }
        if (socSecField.getText() == null || socSecField.getText().length() == 0){
            errorMessage += "No valid social security number provided.\n";
        }
        if (socSecField.getText().toString().matches("\\d{3}-\\d{2}-\\d{4}") == false){
            errorMessage += "Please enter a social security formatted 000-00-0000 with numbers only.\n";
        }
        
        if (homeAddStreetField.getText() == null || homeAddStreetField.getText().length() == 0){
            errorMessage += "No valid home address street provided.\n";
        }
        if (homeAddCityField.getText() == null || homeAddCityField.getText().length() == 0){
            errorMessage += "No valid home address city provided.\n";
        }
        if (homeAddCityField.getText().toString().matches("[a-zA-Z]+") == false) {
        	errorMessage += "Please enter a home address city with letters only and no spaces.\n";
        }
        
        if (homeAddZipField.getText() == null || homeAddZipField.getText().length() == 0){
            errorMessage += "No valid home address zip code provided.\n";
        }
        if (homeAddZipField.getText().toString().matches("\\d{5}") == false){
            errorMessage += "Please enter a home address zip code formatted 00000 with numbers only.\n";
        }
        if (mailAddStreetField.getText() == null || mailAddStreetField.getText().length() == 0){
            errorMessage += "No valid mailing address street provided.\n";
        }
        if (mailAddCityField.getText() == null || mailAddCityField.getText().length() == 0){
            errorMessage += "No valid mailing address city provided.\n";
        }
        if (mailAddCityField.getText().toString().matches("[a-zA-Z]+") == false) {
        	errorMessage += "Please enter a mailing address city with letters only and no spaces.\n";
        }
        
        if (mailAddZipField.getText() == null || mailAddZipField.getText().length() == 0){
            errorMessage += "No valid mailing address zip code provided.\n";
        }
        if (mailAddZipField.getText().toString().matches("\\d{5}") == false){
            errorMessage += "Please enter a mailing address zip code formatted 00000 with numbers only.\n";
        }
        if (homePhoneField.getText() == null || homePhoneField.getText().length() == 0){ 
        	errorMessage += "No valid home phone number provided.\n";
        }
        if (homePhoneField.getText().toString().matches("\\d{3}-\\d{3}-\\d{4}") == false){
            errorMessage += "Please enter a home phone number formatted 000-000-0000 with numbers only.\n";
        }
        if (cellPhoneField.getText() == null || cellPhoneField.getText().length() == 0){
            errorMessage += "No valid cell phone number provided.\n";
        }
        if (cellPhoneField.getText().toString().matches("\\d{3}-\\d{3}-\\d{4}") == false){
            errorMessage += "Please enter a home phone number formatted 000-000-0000 with numbers only.\n";
        }
        
     

        if (errorMessage.length() == 0) {
        	
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogueStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
