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


public class SQLManager implements DBManager {
	private  Connection connection;



public  void connect(String path, String classname) {
	try {

	Class.forName(classname);
	this.connection= DriverManager.getConnection("jdbc:sqlite:" + path);
	connection.createStatement().execute("PRAGMA foreign_keys= ON");
	//System.out.println("database connection opened");

}
	catch(Exception e) {
		e.printStackTrace();
		//System.out.println("La conexi�n no pudo establecerse con �xito");
	}
}

public void createTables() {
	try {
Statement statement= this.connection.createStatement();

String patient= "CREATE TABLE patients"
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "SSNN INTEGER NOT NULL,"
		+ " name TEXT NOT NULL,"
		+ "DOB DATE NOT NULL,"
		+ " gender TEXT NULL,"
		+ " photo BLOB ,"
		+ "password TEXT NOT NULL)";
		statement.execute(patient);
		
String doctor= "CREATE TABLE doctors"
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " username TEXT NOT NULL,"
				+ " password TEXT NOT NULL)";
				statement.execute(doctor);

String sideEffects="CREATE TABLE sideEffects" 
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " duration INTEGER,"
		+ " area TEXT)";
		statement.execute(sideEffects);


String illness ="CREATE TABLE illnesses "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " type TEXT,"
		+ "causes TEXT,"
		+ "contagious BOOLEAN "
		+ "  )";
		statement.execute(illness);
		
String intolerance ="CREATE TABLE intolerance "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL"
		+ "  )";
		statement.execute(intolerance);
		
String medicines ="CREATE TABLE medicines "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ " name TEXT NOT NULL,"
		+ " activePrinciple TEXT, "
		+ " price REAL, "
		+ " SSCover BOOLEAN "
		+ "  )";
		statement.execute(medicines);
		
String symptoms ="CREATE TABLE symptoms "
		+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, "
		+ " name TEXT NOT NULL, "
		+ " diagnosis TEXT, "
		+ " areas TEXT, "
		+ " duration INTEGER "
		+ "  )";

		statement.execute(symptoms);
		
String patient_illness= "CREATE TABLE patient_illness"
		+ "(patient_id INTEGER, "
		+ "illness_id INTEGER, "  
		+ "PRIMARY KEY (patient_id, illness_id), "
		+ " FOREIGN KEY (patient_id) REFERENCES patient(id), "
		+ " FOREIGN KEY (illness_id) REFERENCES illnesses(id) "
		+ ")";
		statement.execute(patient_illness);

String patient_intolerance= "CREATE TABLE patient_intolerance"
		+ "(patient_id INTEGER, "
		+ "intolerance_id INTEGER, "
		+ "PRIMARY KEY (patient_id, intolerance_id), "
		+ " FOREIGN KEY (patient_id) REFERENCES patient(id), "
		+ " FOREIGN KEY (intolerance_id) REFERENCES intolerance(id) "
		+ " )";
		statement.execute(patient_intolerance);
		
String patient_symptoms= "CREATE TABLE patient_symptoms"
		+ "(patient_id INTEGER, "
		+ "symptoms_id INTEGER, "
		+ "PRIMARY KEY (patient_id, symptoms_id), "
		+ " FOREIGN KEY (patient_id) REFERENCES patient(id), "
		+ " FOREIGN KEY (symptoms_id) REFERENCES symptoms(id) "
		+ " )";
		statement.execute(patient_symptoms);

String patient_medicines= "CREATE TABLE patient_medicines"
		+ "(patient_id INTEGER, "
		+ "medicines_id INTEGER, "
		+ "PRIMARY KEY (patient_id, medicines_id), "
		+ " FOREIGN KEY (patient_id) REFERENCES patient(id), "
		+ " FOREIGN KEY (medicines_id) REFERENCES medicines(id) "
		+ " )";
		statement.execute(patient_medicines);

String illness_symptoms = "CREATE TABLE illness_symptoms"
		+ "(illness_id INTEGER, "
		+ "symptoms_id INTEGER, "
		+ " FOREIGN KEY (illness_id) REFERENCES illnesses(id), "
		+ " FOREIGN KEY (symptoms_id) REFERENCES symptoms(id) "
		+ " )";
		statement.execute(illness_symptoms);

String medicines_illness= "CREATE TABLE medicines_illness" 	
		+ "(illness_id INTEGER, "
		+ "medicines_id INTEGER, "
		+ " FOREIGN KEY (illness_id) REFERENCES illnesses(id), "
		+ " FOREIGN KEY (medicines_id) REFERENCES medicines(id) "
		+ " )";
		statement.execute(medicines_illness);

String medicines_sidEffects= "CREATE TABLE medicines_sideEffects"
		+ "(medicines_id INTEGER, "
		+ "sidEffects_id INTEGER, "
		+ " FOREIGN KEY (medicines_id) REFERENCES medicines(id), "
		+ " FOREIGN KEY (sidEffects_id) REFERENCES sidEffects(id) "
		+ " )";
		statement.execute(medicines_sidEffects);
       
		Statement stmtSeq = connection.createStatement();
		String sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('illnesses', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('intolerance', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('medicines', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('symptoms', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('sideEffects', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('patients', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('doctors', 1)";
		stmtSeq.executeUpdate(sqlSeq);
		stmtSeq.close();

	}catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("CREADAS CORRECTAMENTE (Dentro del metodo)");
}





public void Insert_illness(Illnesses i) {
	try {
		
		String sql="INSERT INTO illnesses( name, type, causes, contagious) "+ "VALUES (?,?,?,?);";
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
	PreparedStatement prep4=connection.prepareStatement("INSERT INTO illness_symptoms(illnesses.id,symptom.id)"+" VALUES(?,?) ");
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
		PreparedStatement prep4=connection.prepareStatement("INSERT INTO patient_illness(patients.id,illnesses.id)"+" VALUES(?,?) ");
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
		
		String sql="INSERT INTO medicines( name, activePrinciple, price, SSCover) "+ "VALUES (?,?,?,?);";
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
	Statement stmt = connection.createStatement();
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
	    Patients patient = new Patients( SSN, name, dob, gender,photo, password);
        list_patients.add(patient);
	}
	rs.close();
	stmt.close();
	return list_patients;
}

public void Delete_illness(Illnesses i) {
	try {
		
		String sql="DELETE FROM illnesses WHERE id= ?;";
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
		
		String sql="DELETE  FROM symptoms WHERE id= ?;";
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
		
		String sql="DELETE  FROM patients WHERE id= ?;";
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
		
		String sql="DELETE FROM SideEffects WHERE id= ?;";
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
		
		String sql="DELETE FROM intolerance WHERE id= ?;";
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
		
		String sql="DELETE  FROM medicines WHERE id= ?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, j.getId());
		
	
		prep.executeUpdate();
		prep.close();}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void Update_illness_Name(String new_name, Illnesses i) {
	try {
		
		String sql ="UPDATE illnesses SET name=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_name);
		prep.setInt(2, i.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
//ESTA MAL ESTE METODO(el de abajo)
/*public void Update_illness(Illnesses i) {
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
}*/
//System.out.println("Update finished.");
//Before doing this method we must print a list of patients with their ID, so the user can choose the one to update

public void Update_patients_Name(String new_Name,Patients p) {
	try {
		
		String sql="Update patients SET name=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Name);
		prep.setInt(2, p.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
//Before doing this method we must print a list of patients with their ID, so the user can choose the one to update
public void Update_patients_Gender(String new_Gender,Patients p) {
	try {
		
		String sql="Update patients SET gender=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Gender);
		prep.setInt(2, p.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
public void Update_Symptoms_Diagnosis(String new_Diagnosis, Symptoms s) {
	try {
		
		String sql="Update symptoms SET diagnosis=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Diagnosis);
		prep.setInt(2, s.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
public void Update_Symptoms_Areas(String new_Area, Symptoms s) {
	try {
		
		String sql="Update symptoms SET area=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Area);
		prep.setInt(2, s.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}//System.out.println("Update finished.");
public void Update_Symptoms_Duration(Integer new_Duration, Symptoms s) {
	try {
		
		String sql="Update symptoms SET duration=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, new_Duration);
		prep.setInt(2, s.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
//ESTA MAL ESTE METODO(el de abajo)
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
//System.out.println("Update finished.");
//For this method to work we have to finish the CREATE SideEffects table
public void Update_SideEffects_duration(Integer new_Duration, SideEffects s) {
	try {
		
		String sql="Update sideEffects SET duration=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setInt(1, new_Duration);
		prep.setInt(2, s.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
public void Update_SideEffects_Area(String new_Area, SideEffects s) {
	try {
		
		String sql="Update sideEffects SET area=? where id=?;";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Area);
		prep.setInt(2, s.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
//System.out.println("Update finished.");
//ESTA MAL ESTE METODO(el de abajo)
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
		//System.out.println("Update finished.");
public void Update_intolerance_Name(String new_Name,Intolerance in) {
	try {
		
		String sql ="UPDATE intolerance SET name=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Name);
		prep.setInt(2, in.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
public void Update_Medicines_Name(String new_Name, Medicines m) {
	try {
		
		String sql ="UPDATE medicines SET name=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Name);
		prep.setInt(2, m.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
public void Update_Medicines_ActivePrinciple(String new_ActivePrinciple, Medicines m) {
	try {
		
		String sql ="UPDATE medicines SET activePrinciple=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_ActivePrinciple);
		prep.setInt(2, m.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
public void Update_Medicines_price(double new_price, Medicines m) {
	try {
		
		String sql ="UPDATE medicines SET price=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setDouble(1, new_price);
		prep.setInt(2, m.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
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

public  List<Illnesses> printIllnes() throws SQLException {
	List<Illnesses> list_illness=new ArrayList<Illnesses>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM illnesses";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String type= rs.getString("type");
		String causes = rs.getString("causes");
		boolean contagious=rs.getBoolean("contagious");
	    Illnesses illnes  = new Illnesses(id,name, type, causes, contagious);
		list_illness.add(illnes);
	}
	rs.close();
	stmt.close();
	return list_illness;
}

public  List<Intolerance> printIntolerance() throws SQLException {
	List<Intolerance> list_into=new ArrayList<Intolerance>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM intolerance";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
	    Intolerance intolerances  = new Intolerance(id,name);
		list_into.add(intolerances);
	}
	rs.close();
	stmt.close();
	return list_into;
}

public  List<Doctor> printDoctor() throws SQLException {
	List<Doctor> list_dr=new ArrayList<Doctor>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM doctors";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String Username = rs.getString("username");
		String Password= rs.getString("password");
	    Doctor dr  = new Doctor(id,Username,Password);
		list_dr.add(dr);
	}
	rs.close();
	stmt.close();
	return list_dr;
}

public  List<Medicines> printMedicines() throws SQLException {
	List<Medicines> list_medicines=new ArrayList<Medicines>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM medicines";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String activePrinciple= rs.getString("activePrinciple");
		Double price = rs.getDouble("price");
		Boolean sscover=rs.getBoolean("SSCover");
	    Medicines med  = new Medicines(id,name,activePrinciple,price,sscover);
		list_medicines.add(med);
	}
	rs.close();
	stmt.close();
	return list_medicines;
}

public  List<SideEffects> printSideEffects() throws SQLException {
	List<SideEffects> list_sideEffects=new ArrayList<SideEffects>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM sideEffects";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int duration= rs.getInt("duration");
		String area = rs.getString("area");
		
	    SideEffects side  = new SideEffects(id,name,duration,area);
		list_sideEffects.add(side);
	}
	rs.close();
	stmt.close();
	return list_sideEffects;
}

public  List<Symptoms> printSymptoms() throws SQLException {
	List<Symptoms> list_symp=new ArrayList<Symptoms>();
	Statement stmt = connection.createStatement();
	String sql = "SELECT * FROM symptoms";
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String diagnosis= rs.getString("diagnosis");
		String area = rs.getString("areas");
		int duration =rs.getInt("duration");
	    Symptoms sym  = new Symptoms(id,name, diagnosis, area, duration);
		list_symp.add(sym);
	}
	rs.close();
	stmt.close();
	return list_symp;
}
public List<Patients> searchByName(String name){
 List<Patients> list_patients =new ArrayList<Patients>();
	try {
		String search ="SELECT FROM patients WHERE name=?;";
	PreparedStatement ps=connection.prepareStatement(search);
	ps.setString(1,name);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	int id = rs.getInt("id");
		int SSN = rs.getInt("SSN");
		String name1 = rs.getString("name");
		Date dob = rs.getDate("dob");
		String gender = rs.getString("gender");
		byte[] photo = rs.getBytes("photo");
		String password =rs.getString("password");
	    Patients patient = new Patients( SSN, name1, dob, gender, photo, password);
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



@Override
public void Insert_Doctor(Doctor d) {
//Done in JPA
	
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
//System.out.println("Update finished.");
public void Update_Doctors_UserName(String new_UserName, Doctor d) {
	try {
		
		String sql ="UPDATE doctors SET username=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_UserName);
		prep.setInt(2, d.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
public void Update_Doctors_Password(String new_Password, Doctor d) {
	try {
		
		String sql ="UPDATE doctors SET password=? where id=?";
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, new_Password);
		prep.setInt(2, d.getId());
	  	prep.executeUpdate();
	  	prep.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
//System.out.println("Update finished.");
//ESTE METODO DE ABAJO ESTA MAL.
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
