package illnessdisease.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import illnessdisease.db.*;
import illnessdisease.pojo.*;
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;
 */
public class UI { // extends Application
	public static void main(String[] args) throws SQLException {
	SQLManager sqlm = new SQLManager();
	JPAManager jpam = new JPAManager();
	sqlm.connect("./db/illnessdisease.db", "org.sqlite.JDBC" );
	sqlm.createTables();
	jpam.connect(); 
	System.out.println("CREADAS CORRECTAMENTE (fuera del metodo)");
	
	
	int option;
	while(true){
		try{
	        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
	        printMenu();
	        option = Integer.parseInt(consola.readLine());
	        switch(option){
	        case 1:
	        	System.out.println("YOU SELECTED: ILLNESS, SELECT AN OPTION: ");
	        	Illnesses ill = new Illnesses();
	        	menu2();
	        	option = Integer.parseInt(consola.readLine());
	        	switch(option){
	        	case 1: 
	        		
	        		System.out.println("OPTION SELECTED: INSERT ILLNESS");
	        		String name;
	        		String type;
	        		String causes;
	        		boolean contagious;
	        		
	        		System.out.println("Insert name: ");
	        		name = consola.readLine();
	        		System.out.println("Insert type of illness: ");
	        		type = consola.readLine();
	        		System.out.println("Insert causes: ");
	        		causes = consola.readLine();
	        		while(true){
	        		System.out.println("Is it contagious? (Y/N)");	 
	        		String leido = consola.readLine();
	        			if(leido.equals("Y")){
	        			contagious = true;
	        			break;
	        			}else if(leido.equals("N")){
	        				contagious = false;
	        				break;
	        			}
	        			else System.out.println("ERROR - You didn´t type Y or N, try again :)");	
	        		}
	        		Illnesses insertedIllness = new Illnesses(name,type,causes,contagious); //sin id
	        		System.out.println("Does this illness produce any symptom?(yes/no)");
	        		String respuesta=consola.readLine();
	        		if(respuesta.equals("yes")) {
	        			
	        		
	        		
	        			System.out.println("now i am going to print the symptoms: \n\n");
	        			List<Symptoms> s=sqlm.printSymptoms();
	        			for(Symptoms s2: s) {
	        				System.out.println(s2);
	     
	        		
	        			}
	        			int a=0;
	        			while( a==0) {
	        				System.out.println("introduce the id of the symptom that the illness produces: ");
	        				int ids=Integer.parseInt(consola.readLine());
	        				Symptoms s3=jpam.getSymptomsFromID(ids);
	        		
	        		
	        				insertedIllness.addSymptom(s3);
	        				System.out.println("does the illness produce any more symptoms?(yes/no");
	        				String respuesta2=consola.readLine();
	        				if(respuesta2.equals("yes")) {
	        					a=0;
	        				}
	        				else {
	        					a++;
	        				}
	        			}
	        		}
	        		jpam.Insert_illness(insertedIllness);
	        		System.out.println("AHORA VOY A IMPRIMIR LAS ILLNESSES: \n\n");
	        		List<Illnesses> li=sqlm.printIllnes();
	        		for(Illnesses il: li) {
	        			System.out.println(il);
	        		}
	        		
	        	
	        		break;
	        		
	        	case 2:
	        		System.out.println("OPTION SELECTED: SEARCH ILLNESS");
	        		System.out.println("Introduce the name of the illness you are looking for: ");
	        		String nameIllness=consola.readLine();
	        		List<Illnesses> listIllnesses= jpam.searchIllnessbyname(nameIllness);
	        		if(listIllnesses!=null){		
	        			for(Illnesses s: listIllnesses) {
	        				System.out.println(s);
	        			}
	        		}else {
	        			System.out.println("the illness with that name doesn't appear in our database");
	        		}
	        		break;
	        	case 3: 
	        		System.out.println("OPTION SELECTED: DELETE ILLNESS");
	        		sqlm.printIllnes();
	        		System.out.println("Insert the id of the illness that you want to delete: ");
	        		int id = Integer.parseInt(consola.readLine());
	        		Illnesses illness = jpam.getIllnessFromID(id);
	        		
	        		jpam.Delete_illness(illness);
	        		jpam.close();//eliminamos el illness encontrado
	        		//Se debería meter en un if pero no sé comprobar si el searchIllness ha devuelto algo valido 
	        		//o no. Se podría hacer if(esa movida != null) ???
	        		

	        		break;
	        	case 4: 
	        		System.out.println("OPTION SELECTED: UPDATE ILLNESS");
	        		System.out.println("INTRODUCE THE ID OF THE ILLNESS THAT YOU WANT TO DELETE: ");
	        		id  = Integer.parseInt(consola.readLine());
	        		//Hacer busqueda igual que en el case 3
	        		//Con lo que de esa busqueda:
	        		illness = jpam.getIllnessFromID(id);
	        		System.out.println("Insert the new name: ");
	        		String newName = consola.readLine();
	        		System.out.println("Insert the new type: ");
	        		String newType = consola.readLine();
	        		System.out.println("Insert the new causes: ");
	        		String newCauses = consola.readLine();
	        		jpam.Update_Illnesses_Name(newName, illness); //lo hacemos
	        		//sqlm.Update_illness(i);
	        		//Hacer UPDATE sobre lo que nos dio la busqueda anterior
	        		//sqlm.Update_illness_Name(newName, i);
	        		break;
	        	case 5: 
	        		System.out.println("");
	        		
	        
	        	
	        	
	        	break;}break;
	        case 2: 
	        	System.out.println("YOU SELECTED INTOLERANCE, SELECT AN OPTION:  ");
	        	
	        	menu2();
	        	Integer option2= Integer.parseInt(consola.readLine());
	        	
	        	switch(option2){
	        	case 1: 
	        		
	        		System.out.println("OPTION SELECTED: INSERT INTOLERANCE");
	        		String name;
	        		
	        		System.out.println("Insert name: ");
	        		name = consola.readLine();
	        		Intolerance insertedIntolerance = new Intolerance(name); //sin id
	        		sqlm.Insert_intolerance(insertedIntolerance);
	        		System.out.println("now i am going to print the intolerances: \n\n");
	        		List<Intolerance> in=sqlm.printIntolerance();
	        		for(Intolerance i: in) {
	        			System.out.println(i);
	        		}
	        	
	        		break;
	        		
	        	case 2:
	        		/*System.out.println("OPTION SELECTED: SEARCH INTOLERANCE");
	        		System.out.println("Introduce the name of the intolerance you are looking for: ");
	        		String nameIntolerance=consola.readLine();
	        		List<Intolerance> listIntolerance= jpam.searchIntolerancebyname(nameIntolerance);
	        		if(listIntolerance!=null){		
	        			for(Intolerance into: listIntolerance) {
	        				System.out.println(into);
	        			}
	        		}else {
	        			System.out.println("the intolerance with that name doesn't appear in our database");
	        		}
	        		break;*/
	        	case 3: 
	        		System.out.println("OPTION SELECTED: DELETE INTOLERANCE");
	        		sqlm.printIllnes();
	        		System.out.println("Insert the id of the intolerance that you want to delete: ");
	        		int id = Integer.parseInt(consola.readLine());
	        		Intolerance intolerance = jpam.getIntoleranceFromID(id);
	        		
	        		sqlm.Delete_intolerance(intolerance);
	        		jpam.close();//eliminamos el illness encontrado
	        		//Se debería meter en un if pero no sé comprobar si el searchIllness ha devuelto algo valido 
	        		//o no. Se podría hacer if(esa movida != null) ???
	        		

	        		break;
	        	case 4: 
	        		System.out.println("OPTION SELECTED: UPDATE INTOLERANCE");
	        		System.out.println("INTRODUCE THE ID OF THE INTOLERANCE THAT YOU WANT TO UPDATE: ");
	        		id  = Integer.parseInt(consola.readLine());
	        		//Hacer busqueda igual que en el case 3
	        		//Con lo que de esa busqueda:
	        		intolerance = jpam.getIntoleranceFromID(id);
	        		System.out.println("Insert the new name: ");
	        		String newName = consola.readLine();
	        		jpam.Update_intolerance_Name(newName, intolerance); //lo hacemos
	        		//sqlm.Update_illness(i);
	        		//Hacer UPDATE sobre lo que nos dio la busqueda anterior
	        		//sqlm.Update_illness_Name(newName, i);
	        		break;
	        	case 5: 
	        		List<Intolerance> in2=sqlm.printIntolerance();
	        		for(Intolerance i: in2) {
	        			System.out.println(i);
	        		}
	        	
	        	
	        	break;}
	        break;
	        }
	        	}catch(IOException ex){
			ex.printStackTrace();
		} }
	
	
	}
	
	public static void printMenu(){
		System.out.println("-----WELCOME-----");
		System.out.println("OPTION 1: ILLNESSES");
		System.out.println("OPTION 2: INTOLERANCE");
		System.out.println("OPTION 3: MEDICINES");
		System.out.println("OPTION 4: PATIENTS");
		System.out.println("OPTION 5: SIDE EFFECTS");
		System.out.println("OPTION 6: SYMPTOMS");
		//System.out.println("OPTION 7: INSERT DOCTOR"); HAY QUE DECIDIR DÓNDE PONER ESTO	
	}
	
	//Try catch
	/*
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
	*/
	
	static void menu2(){
		System.out.println("Introduce 1 to insert ");
		System.out.println("Introduce 2 to search");
		System.out.println("Introduce 3 to delete");
		System.out.println("Introduce 4 to update");
		System.out.println("Introduce 5 to print");
		System.out.println("Introduce 6 to exit");
	}
	
	/*
	static void inicilizeTables(){
		try{
		Illnesses ill = new Illnesses();
		ill.SQLCreate();
		}
		catch(TableCreationException e ){
			e.tableExists();

		}
		try{
		FunctionsDB<Nurse> nur = new DB_Nurse();
		nur.SQLCreate();
		}
		catch(TableCreationException e ){
			e.tableExists();
			}
		try{
		FunctionsDB<Cells> cells = new DB_Cells();
		cells.SQLCreate();
		}
		catch(TableCreationException e ){
			e.tableExists();
			}
		try{
		FunctionsDB<Molecules> molecules = new DB_Molecules();
		molecules.SQLCreate();
		}		
		catch(TableCreationException e ){
			e.tableExists();
			 			}
		try{
		FunctionsDB<Symptoms> syn = new DB_Symptoms();
		syn.SQLCreate();
		}
		catch(TableCreationException e ){
			 e.tableExists();
			}
		try{
		FunctionsDB<Illnes> ill = new DB_Illness();
		ill.SQLCreate();
		}
		catch(TableCreationException e ){
			 e.tableExists();
			}
		try{
		FunctionsDB<Patient> pat = new DB_Patient();
		pat.SQLCreate();
		}
		catch(TableCreationException e ){
			e.tableExists();
			}
			
		
	}
	*/

	
	
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

