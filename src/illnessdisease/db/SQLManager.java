package illnessdisease.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import illnessdisease.pojo.Doctor;
import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Symptoms;
import illnessdisease.pojo.Intolerance;
import java.io.*;

public class SQLManager implements DBManager {
	private Connection connection;
//	private Statement statement;
	private static Connection c;

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
		+ " gender TEXT NULL,"
		+ " photo BLOB ,"
		+ "password TEXT NOT NULL)";
		//+ " dob "
		statement.execute(patient);
		
String doctor= "CREATE TABLE doctors"
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " username TEXT ,"
				+ " password TEXT NOT NULL)";
				//+ " dob "
				statement.execute(doctor);

String sideEffects="CREATE TABLE sideEffects"//Esto esta incompleto y mal.
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ "  )";
		statement.execute(sideEffects);


String illness ="CREATE TABLE illness "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " type TEXT,"
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
		
		String sql="INSERT INTO illnesses( name, type, contagious,patients) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, i.getName());
		prep.setString(2, i.getType());
		prep.setBoolean(3, i.isContagious());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Insert_symptoms(Symptoms i) {
	try {
		
		String sql="INSERT INTO symptoms( name, Diagnosis, Areas, Duration) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, i.getName());
		prep.setString(2, i.getDiagnosis());
		prep.setString(3, i.getAreas());
		prep.setInt(4, i.getDuration());
		List<Patients> p=i.getPatients();
		
		for(Patients pa:p) {
		int IDp=pa.getId();
		String query="SELECT last_insert_rowid() AS lastId";
		PreparedStatement prep2=connection.prepareStatement(query);
		ResultSet rs=prep2.executeQuery();
		Integer lastId=rs.getInt("lastId");
		PreparedStatement prep3=connection.prepareStatement("INSERT INTO patients_symptoms(patient.id,symptom.id)"+" VALUES(?,?) ");
		prep3.setInt(1, IDp);
		prep3.setInt(2, lastId);
		prep3.executeUpdate();
		prep3.close();
		rs.close();
		}
	for(Illnesses il:i.getIllnesses()) {
		int IDil=il.getId();
	
		String query="SELECT last_insert_rowid() AS lastId";
		PreparedStatement prep2=connection.prepareStatement(query);
		ResultSet rs=prep2.executeQuery();
		Integer lastId=rs.getInt("lastId");
	PreparedStatement prep4=connection.prepareStatement("INSERT INTO illness_symptoms(illness.id,symptom.id)"+" VALUES(?,?) ");
	prep4.setInt(1, IDil);
	prep4.setInt(2, lastId);
	prep4.executeUpdate();
	prep4.close();
	rs.close();}
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Insert_patients(Patients p) {
	try {
		
		String sql="INSERT INTO patients( SSn, name, DOB, gender , photo, password) "+ "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, p.getSSN());
		prep.setString(2, p.getName());
		prep.setDate(3, p.getDOB());
		prep.setString(4, p.getGender());
		prep.setBytes(5, p.getPhoto());
		prep.setString(6, p.getPassword());
		for(Symptoms s:p.getSymptoms()) {
			int IDs=s.getId();
			String query="SELECT last_insert_rowid() AS lastId";
			PreparedStatement prep2=connection.prepareStatement(query);
			ResultSet rs=prep2.executeQuery();
			Integer lastId=rs.getInt("lastId");
			PreparedStatement prep3=connection.prepareStatement("INSERT INTO patients_symptoms(patient.id,symptom.id)"+" VALUES(?,?) ");
			prep3.setInt(2, IDs);
			prep3.setInt(1, lastId);
			prep3.executeUpdate();
			prep3.close();
			rs.close();
			}
		for(Illnesses il:p.getIllnesses()) {
			int IDil=il.getId();
		
			String query="SELECT last_insert_rowid() AS lastId";
			PreparedStatement prep2=connection.prepareStatement(query);
			ResultSet rs=prep2.executeQuery();
			Integer lastId=rs.getInt("lastId");
		PreparedStatement prep4=connection.prepareStatement("INSERT INTO patient_illness(patients.id,illness.id)"+" VALUES(?,?) ");
		prep4.setInt(2, IDil);
		prep4.setInt(1, lastId);
		prep4.executeUpdate();
		prep4.close();
		rs.close();}
		for(Intolerance in:p.getIntelorance()) {
			int IDin=in.getId();
			String query="SELECT last_insert_rowid() AS lastId";
			PreparedStatement prep2=connection.prepareStatement(query);
			ResultSet rs=prep2.executeQuery();
			Integer lastId=rs.getInt("lastId");
			PreparedStatement prep3=connection.prepareStatement("INSERT INTO patient_intolerance(patient.id,intolerance.id)"+" VALUES(?,?) ");
			prep3.setInt(2, IDin);
			prep3.setInt(1, lastId);
			prep3.executeUpdate();
			prep3.close();
			rs.close();
			}
		for(Medicines me:p.getMedicines()) {
			int IDme=me.getId();
		
			String query="SELECT last_insert_rowid() AS lastId";
			PreparedStatement prep2=connection.prepareStatement(query);
			ResultSet rs=prep2.executeQuery();
			Integer lastId=rs.getInt("lastId");
		PreparedStatement prep4=connection.prepareStatement("INSERT INTO patient_medicines(patient.id,medicines.id)"+" VALUES(?,?) ");
		prep4.setInt(2, IDme);
		prep4.setInt(1, lastId);
		prep4.executeUpdate();
		prep4.close();
		rs.close();}
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
		
public void Insert_sideeffects(SideEffects s) {
	try {
		
		String sql="INSERT INTO side_effects(name, duration, area) "+ "VALUES (?,?,?);";
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
		
public void Insert_intolerance(Intolerance in) {
	try {
		
		String sql ="INSERT INTO intolerance( name) "+ "VALUES (?)";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, in.getName());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
public void Insert_Medicines(Medicines j) {
	try {
		
		String sql="INSERT INTO medicines( name, activePrinciple, price, seguridadSocial) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, j.getName());
		prep.setString(2, j.getActivePrinciple());
		prep.setDouble(3, j.getPrice());
		prep.setBoolean(4, j.isSeguridadSocial());
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public List<Patients> printPatient() throws SQLException {
	List<Patients> list_patients =new ArrayList<Patients>();
	Statement stmt = c.createStatement();
	String sql = "SELECT * FROM patients";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		int SSN = rs.getInt("SSN");
		String name = rs.getString("name");
		Date dob = rs.getDate("dob");
		String gender = rs.getString("gender");
		byte[] photo = rs.getBytes("photo");
		String password =rs.getString("password");
	    Patients patient = new Patients( id, SSN, name, dob, gender, photo, password);
        list_patients.add(patient);
	}
	rs.close();
	stmt.close();
	return list_patients;
}

public void Delete_illness(Illnesses i) {
	try {
		
		String sql="DELETE 	FROM illnesses WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, i.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Delete_symptoms(Symptoms i) {
	try {
		
		String sql="DELETE 	FROM symptoms WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, i.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void Delete_patients(Patients p) {
	try {
		
		String sql="DELETE 	FROM patients WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, p.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
		
public void Delete_sideeffects(SideEffects s) {
	try {
		
		String sql="DELETE 	FROM SideEffects WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, s.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
		
public void Delete_intolerance(Intolerance in) {
	try {
		
		String sql="DELETE 	FROM intolerance WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, in.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
public void Delete_Medicines(Medicines j) {
	try {
		
		String sql="DELETE 	FROM medicines WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, j.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void Update_illness(Illnesses i) {
	try {
		
		String sql="UPDATE INTO illnesses( name, type, contagious) "+ "VALUES (?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, i.getName());
		prep.setString(2, i.getType());
		prep.setBoolean(3, i.isContagious());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Update_patients(Patients p) {
	try {
		
		String sql="INSERT INTO patients( SSn, name, DOB, gender, photo) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, p.getSSN());
		prep.setString(2, p.getName());
		prep.setDate(3, p.getDOB());
		prep.setString(4, p.getGender());
	    prep.setBytes(5, p.getPhoto());
	    prep.setString(6, p.getPassword());
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void Update_symptoms(Symptoms i) {
	try {
		
		String sql="UPDATE INTO illnesses( name, Diagnosis, Areas, Duration) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, i.getName());
		prep.setString(2, i.getDiagnosis());
		prep.setString(3, i.getAreas());
		prep.setInt(4, i.getDuration());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void Update_sideeffects(SideEffects s) {
	try {
		
		String sql="UPDATE INTO side_effects(name, duration, area) "+ "VALUES (?,?,?);";
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
		
public void Update_intolerance(Intolerance in) {
	try {
		
		String sql ="UPDATE INTO intolerance( name) "+ "VALUES (?)";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, in.getName());
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
public void Update_Medicines(Medicines j) {
	try {
		
		String sql="UPDATE INTO medicines( name, activePrinciple, price, seguridadSocial) "+ "VALUES (?,?,?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, j.getName());
		prep.setString(2, j.getActivePrinciple());
		prep.setDouble(3, j.getPrice());
		prep.setBoolean(4, j.isSeguridadSocial());
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public static List<Illnesses> printIllnes() throws SQLException {
	List<Illnesses> list_illness=new ArrayList<Illnesses>();
	Statement stmt = c.createStatement();
	String sql = "SELECT * FROM illnesses";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String type= rs.getString("type");
		String causes = rs.getString("causes");
		boolean contagious=rs.getBoolean("contagious");
	    Illnesses illnes  = new Illnesses(id, name, type, causes, contagious);
		System.out.println(illnes);
	}
	rs.close();
	stmt.close();
	return list_illness;
}

public List<Patients> searchByName(String name){
 List<Patients> list_patients =new ArrayList<Patients>();
	try {
		String search ="SELECT FROM patients WHERE name=?;";
	PreparedStatement ps=connection.prepareStatement(search);
	ps.setString(1,name);
	ResultSet rs=ps.executeQuery(search);
	while(rs.next()){
	int id = rs.getInt("id");
		int SSN = rs.getInt("SSN");
		String name1 = rs.getString("name");
		Date dob = rs.getDate("dob");
		String gender = rs.getString("gender");
		byte[] photo = rs.getBytes("photo");
		String password =rs.getString("password");
	    Patients patient = new Patients( id, SSN, name1, dob, gender, photo, password);
        list_patients.add(patient);}
     return list_patients ;  
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return list_patients;}
public void close() {
	try {
	connection.close();
	}
 catch(Exception e) { e.printStackTrace();}



	
}


public void Delete_doctors(Doctor s) {
	try {
		
		String sql="DELETE 	FROM doctors WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, s.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void Update_Doctors(Doctor j) {
	try {
		
		String sql="UPDATE INTO doctors( userName, password) "+ "VALUES (?,?);";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, j.getUserName());
		prep.setString(2, j.getPassword());
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
