package illnessdisease.db;
import java.sql.*;

import illnessdisease.pojo.Illnesses;

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
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " diagnosis TEXT, "
		+ " areas TEXT, "
		+ " duration INTEGER, "
		+ "  )";
		statement.execute(symptoms);       
	}catch(Exception e) {
		e.printStackTrace();
	}
}





public void Insert_illness(Illnesses i) {
	try {
		
		String sql="INSERT INTO ilnesses( id, name, type, causes, contagious) "+ "VALUES (?,?,?,?,?);";
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
		

}
		
