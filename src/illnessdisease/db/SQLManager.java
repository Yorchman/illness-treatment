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
		+ " gender TEXT NULL )";
		//+ " dob "
		statement.execute(patient);

String sideEffects="CREATE TABLE sideEffects"//Esto esta incompleto y mal.
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ "  )";
		statement.execute(sideEffects);
	}catch(Exception e) {
		e.printStackTrace();
	}

}
 
public void Insert_patients(Integer id, String name, String type, String causes, boolean contagious) {
	try {
		Statement statement2= this.connection.createStatement();
		String sql="INSERT INTO "
		}
	catch(Exception e) {
		e.printStackTrace();
	}
}}





