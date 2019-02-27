package illnessdisease.db;
import java.sql.*;
import java.io.*;

public class SQLManager {
	private Connection connection;
//	private Statement statement;
	

public void connect(String path, String classname) {
	try {

	Class.forName(classname);
	this.connection= DriverManager.getConnection(path);
	connection.createStatement().execute("PRAGMA foreign_keys= ON");
	//System.out.println("database connection opened");

}
	catch(Exception e) {
		e.printStackTrace();
		//System.out.println("La conexion no pudo establecerse con éxito");
	}}

public void createTables() {
	try {
Statement statement= this.connection.createStatement();
String patient= "CREATE TABLE patients"
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " gender TEXT NULL ,"
		+ " SSN INTEGER ,"
		+ " )";
		//+ " dob "
		statement.execute(patient);

String sideEffects="CREATE TABLE sideEffects"
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " duration INTEGER NOT NULL, "
		+ "area TEXT, "
		+ "  )";
		statement.execute(sideEffects);

String illness ="CREATE TABLE illness "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " type TEXT,"
		+ " causes TEXT,"
		+ "contagious BOOLEAN, "
		+ "  )";
		statement.execute(illness);
		
String intolerance ="CREATE TABLE intolerance "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ "  )";
		statement.execute(intolerance);
		
String medicines ="CREATE TABLE medicines "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " activeprinciple TEXT, "
		+ " restrictions TEXT, "
		+ " price TEXT, "
		+ " SSCover BOOLEAN "
		+ "  )";
		statement.execute(medicines);
		
String symptoms ="CREATE TABLE symptoms "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
		+ " name TEXT NOT NULL, "
		+ " diagnosis TEXT, "
		+ " areas TEXT, "
		+ " duration INTEGER, "
		+ "  )";
		statement.execute(symptoms);
		
String patient_illness= "CREATE TABLE patient_illness"
		+ "(patient.id INTEGER, "
		+ "illness.id INTEGER, "  
		+ "PRIMARY KEY (patient.id, illness.id), "
		+ " FOREIGN KEY (patient.id) REFERENCES patient(id), "
		+ " FOREIGN KEY (illness.id) REFERENCES illness(id), "
		+ ")";
		statement.execute(patient_illness);

String patient_intolerance= "CREATE TABLE patient_intolerance"
		+ "(patient.id INTEGER, "
		+ "intolerance.id INTEGER, "
		+ "PRIMARY KEY (patient.id, intolerance.id), "
		+ " FOREIGN KEY (patient.id) REFERENCES patient(id), "
		+ " FOREIGN KEY (intolerance.id) REFERENCES intolerance(id), "
		+ " )";
		statement.execute(patient_intolerance);
		
String patient_symptoms= "CREATE TABLE patient_symptoms"
		+ "(patient.id INTEGER, "
		+ "symptoms.id INTEGER, "
		+ "PRIMARY KEY (patient.id, symptoms.id), "
		+ " FOREIGN KEY (patient.id) REFERENCES patient(id), "
		+ " FOREIGN KEY (symptoms.id) REFERENCES symptoms(id), "
		+ " )";
		statement.execute(patient_symptoms);

String patient_medicines= "CREATE TABLE patient_medicines"
		+ "(patient.id INTEGER, "
		+ "medicines.id INTEGER, "
		+ "PRIMARY KEY (patient.id, symptoms.id), "
		+ " FOREIGN KEY (patient.id) REFERENCES patient(id), "
		+ " FOREIGN KEY (medicines.id) REFERENCES medicines(id), "
		+ " )";
		statement.execute(patient_medicines);

String illness_symptoms = "CREATE TABLE illness_symptoms"
		+ "(illness.id INTEGER, "
		+ "symptoms.id INTEGER, "
		+ " FOREIGN KEY (illness.id) REFERENCES illness(id), "
		+ " FOREIGN KEY (symptoms.id) REFERENCES symptoms(id), "
		+ " )";
		statement.execute(illness_symptoms);

String illness_medicines= "CREATE TABLE illness_medicines"
		+ "(illness.id INTEGER, "
		+ "medicines.id INTEGER, "
		+ " FOREIGN KEY (illness.id) REFERENCES illness(id), "
		+ " FOREIGN KEY (medicines.id) REFERENCES medicines(id), "
		+ " )";
		statement.execute(illness_medicines);

String medicines_sidEffects= "CREATE TABLE medicines_sidEffects"
		+ "(medicines.id INTEGER, "
		+ "sidEffects.id INTEGER, "
		+ " FOREIGN KEY (medicines.id) REFERENCES medicines(id), "
		+ " FOREIGN KEY (sidEffects.id) REFERENCES sidEffects(id), "
		+ " )";
		statement.execute(medicines_sidEffects);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}



}





