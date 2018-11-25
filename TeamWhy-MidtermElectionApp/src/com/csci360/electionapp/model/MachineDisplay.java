package com.csci360.electionapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class MachineDisplay {

	private final SimpleStringProperty machineNum;
    private final SimpleStringProperty machineVotes;
    
    
   
    public MachineDisplay(String machineNum, String machineVotes) {
        this.machineNum = new SimpleStringProperty(machineNum);
        this.machineVotes = new SimpleStringProperty(machineVotes);
        
    }

    public String getMachineNum() {
        return machineNum.get();
    }
    public void setMachineNum(String mNum) {
    	machineNum.set(mNum);
    }
    public String getMachineVotes() {
        return machineVotes.get();
    }
    public void setMachineVotes(String mVotes) {
    	machineVotes.set(mVotes);
    }
    
    public ObservableList<MachineDisplay> buildList(){
    	ObservableList<MachineDisplay> machineArrayList = FXCollections.observableArrayList();
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/csci360/electionapp/input/totalVoteCounts.txt"))){
        	String line;
        	while ((line = br.readLine()) != null) {
        		String[] resultFromList = line.split("[,]");

        		machineArrayList.add(new MachineDisplay(resultFromList[0],resultFromList[1].toString()));
        		//System.out.println(resultFromList[1]);
        	}
        	
        	
        }
        catch(IOException ex) {
    		
    	}
		return machineArrayList;
    }
    
    
}
