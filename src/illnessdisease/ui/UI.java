package illnessdisease.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import illnessdisease.db.*;
//YO creo los objetos y llamo al manager para que inserte movidas
 class UI {
	public static void main(String args[]){
		SQLManager manager;
		int option;
		manager = new SQLManager();
		//Load tables
		manager.createTables();
		//First we look if the user is a doctor or a patient.
		int userType = decideUser(); //1 is patient and 2 is doctor
		if(userType == 1){
			while (true){
				printMenu();
				switch(printMenu()){
				case 1:
					System.out.println("Opci�n 1: Insert");
					manager.createTables();            		
				}
			}
		}else if(userType == 2){
			
		}
        
	}
	
	public static int printMenu(){
		int option;
		try{
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Option 1: Insert an illness\n"
            		+ "Option 2: Delete an illness\n");
            System.out.println("Select an option: ");
            option = Integer.parseInt(consola.readLine());
            return option;
		}catch(IOException ex){
			ex.printStackTrace();
		return 0;
		}
	}
	
	public static int decideUser(){
		int option;
		try{
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What kind of user are you?\n1.Patient\n2.Doctor");
            System.out.println("Select an option: ");
            option = Integer.parseInt(consola.readLine());
            return option;
		}catch(IOException ex){
			ex.printStackTrace();
		return 0;
		}
	}
}
