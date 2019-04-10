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
		try{
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select an option: ");
            option = Integer.parseInt(consola.readLine());
            while (true){
            	printMenu();
            	switch(option){
            	case 1:
            		System.out.println("Opción 1: Insert");
            		manager.createTables();
            		
            	}
            }
            
            
		}catch(IOException ex){
			ex.printStackTrace();
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
}
