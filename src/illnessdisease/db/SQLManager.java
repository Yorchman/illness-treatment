package illnessdisease.db;
import java.sql.*;

import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;

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
		+ " gender TEXT NULL )";
		//+ " dob "
		statement.execute(patient);

String sideEffects="CREATE TABLE sideEffects"//Esto esta incompleto y mal.
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
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





public void Insert_illness(Illnesses i) {
	try {
		
		String sql="INSERT INTO illnesses( id, name, type, causes, contagious) "+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, i.getName());
		prep.setString(2, i.getType());
		prep.setString(3, i.getCauses());
		prep.setBoolean(4, i.isContagious());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Insert_patients(Patients p) {
	try {
		
		String sql="INSERT INTO patients( id, SSn, name, DOB, gender) "+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, p.getSSN());
		prep.setString(2, p.getName());
		prep.setDate(3, p.getDOB());
		prep.setString(4, p.getGender());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
		
public void Insert_sideeffects(SideEffects s) {
	try {
		
		String sql="INSERT INTO side_effects( id, name, duration, area) "+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, s.getName());
		prep.setInt(2,s.getDuration());
		prep.setString(3, s.getArea());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
		


}
		
