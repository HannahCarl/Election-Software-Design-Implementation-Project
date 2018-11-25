package com.csci360.electionapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class ResultsDisplay {

	private final SimpleStringProperty candName;
    private final SimpleStringProperty candVotes;
    
    
   
    public ResultsDisplay(String candName, String candVotes) {
        this.candName = new SimpleStringProperty(candName);
        this.candVotes = new SimpleStringProperty(candVotes);
        
    }

    public String getCandName() {
        return candName.get();
    }
    public void setCandName(String cName) {
    	candName.set(cName);
    }
    public String getCandVotes() {
        return candVotes.get();
    }
    public void setCandVotes(String cVotes) {
    	candVotes.set(cVotes);
    }
    
    public ObservableList<ResultsDisplay> buildList(){
    	ObservableList<ResultsDisplay> resultsArrayList = FXCollections.observableArrayList();
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/voteResults.txt"))){
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] resultFromList = line.split("[,]");

        		resultsArrayList.add(new ResultsDisplay(resultFromList[0],resultFromList[1].toString()));
        		//System.out.println(resultFromList[1]);
        	}
        	
        	
        }
        catch(IOException ex) {
    		
    	}
		return resultsArrayList;
    }
    
    
}
