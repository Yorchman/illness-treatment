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
	
/*Statement patient= this.connection.createStatement();
String patienth= "CREATE TABLE patients"
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL";
		//+ " dob "
		//+ " gender TEXT NULL "*/
		

}
}





