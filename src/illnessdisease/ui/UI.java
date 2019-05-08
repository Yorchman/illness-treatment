package illnessdisease.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import illnessdisease.db.*;
import illnessdisease.pojo.*;
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;
 */
public class UI //extends Application
	 {
	 
	public static void main(String[] args) {
		
	connect();
	
	
	
	
	}
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*{
	 launch(args);
	 }
	
	 
	 
	 Button btn;
	 @Override public void start (Stage primaryStage)
	 {
	 // Create the button
	 btn = new Button();
	 btn.setText("Click me please!");
	 btn.setOnAction(e -> buttonClick());
	 // Add the button to a layout pane
	 BorderPane pane = new BorderPane();
	 pane.setCenter(btn);
	 // Add the layout pane to a scene
	 Scene scene = new Scene(pane, 300, 250);
	 // Finalize and show the stage
	 primaryStage.setScene(scene);
	 primaryStage.setTitle("The Click Me App");
	 primaryStage.show();
	 }
	 public void buttonClick()
	 {
	 if (btn.getText() == "Click me please!")
	 {
	 btn.setText("You clicked me!");
	 }
	 else
	 {
	 btn.setText("Click me please!");
	 }
	 }
	
	 }
	 
	 
//YO creo los objetos y llamo al manager para que inserte movidas
	/*public static void main(String args[]){
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
	}*/

