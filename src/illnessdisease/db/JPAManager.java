package illnessdisease.db;

import illnessdisease.pojo.Doctor;
import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;
import java.util.List;

import javax.persistence.*;

public class JPAManager implements DBManager {

	private EntityManager e;

	public void connect() {
		this.e = Persistence.createEntityManagerFactory("illnessdisease-provider").createEntityManager();
		this.e.getTransaction().begin();
		this.e.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		this.e.getTransaction().commit();
	}

	public void Insert_patients(Patients c) {

		e.getTransaction().begin();
		e.persist(c);
		e.getTransaction().commit();

	}

	public void Insert_sideeffects(SideEffects c) {

		e.getTransaction().begin();
		e.persist(c);
		e.getTransaction().commit();

	}

	public void Insert_illness(Illnesses c) {
		e.getTransaction().begin();
		e.persist(c);
		e.getTransaction().commit();
	}

	public void Insert_symptoms(Symptoms c) {

		e.getTransaction().begin();
		e.persist(c);
		e.getTransaction().commit();

	}

	public void Insert_Medicines(Medicines j) {

		e.getTransaction().begin();
		e.persist(j);
		e.getTransaction().commit();

	}

	public void Insert_intolerance(Intolerance c) {

		e.getTransaction().begin();
		e.persist(c);
		e.getTransaction().commit();

	}
	
	public void Insert_Doctor(Doctor d) {

		e.getTransaction().begin();
		e.persist(d);
		e.getTransaction().commit();

	}

	public List<Illnesses> searchIllnessbyname(String name) {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Illnesses> listIllnesses= null;
	try {
				
		//System.out.print("Write the illness' name: ");
		//String name = reader.readLine();
		//System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM illnesses WHERE name LIKE ?", Illnesses.class);
		q1.setParameter(1, "%" + name + "%");
		listIllnesses = (List<Illnesses>) q1.getResultList();
		if(listIllnesses.size()==0) return null;

}catch (Exception e) {
	e.printStackTrace();	
		}
	return listIllnesses;
	}
	
	public List<Doctor> searchDoctorbyname(String name) {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Doctor> listDoctor= null;
	try {
				
		//System.out.print("Write the illness' name: ");
		//String name = reader.readLine();
		//System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM doctors WHERE name LIKE ?", Doctor.class);
		q1.setParameter(1, "%" + name + "%");
		listDoctor = (List<Doctor>) q1.getResultList();
		if(listDoctor.size()==0) return null;

}catch (Exception e) {
	e.printStackTrace();	
		}
	return listDoctor;
	}
	
	public List<Intolerance> searchIntolerancebyname(String name) {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Intolerance> listIntolerance= null;
	try {
				
		//System.out.print("Write the illness' name: ");
		//String name = reader.readLine();
		//System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM intolerance WHERE name LIKE ?", Intolerance.class);
		q1.setParameter(1, "%" + name + "%");
		listIntolerance = (List<Intolerance>) q1.getResultList();
		if(listIntolerance.size()==0) return null;

}catch (Exception e) {
	e.printStackTrace();	
		}
	return listIntolerance;
	}
	
	public List<Patients> searchPatientsbyname(String name) {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Patients> listPatients= null;
	try {
				
		//System.out.print("Write the patient's name: ");
		//String name = reader.readLine();
		//System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM patients WHERE name LIKE ?", Patients.class);
		q1.setParameter(1, "%" + name + "%");
		listPatients = (List<Patients>) q1.getResultList();

	}catch (Exception e) {
	e.printStackTrace();	
		}
	return listPatients;
	}
	
	public List<Medicines> searchMedicinesbyname(String name) {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Medicines> listMedicines= null;
	try {
				
		//System.out.print("Write the medicine's name: ");
		//String name = reader.readLine();
		//System.out.println("Matching medicines:");
		Query q1 = e.createNativeQuery("SELECT * FROM medicines WHERE name LIKE ?", Medicines.class);
		q1.setParameter(1, "%" + name + "%");
		listMedicines = (List<Medicines>) q1.getResultList();
		
	}catch (Exception e) {
		e.printStackTrace();
		}	
	return listMedicines;
	}
	public List<SideEffects> searchSideEffectsbyname(String name) {
		List<SideEffects> listSideEffects= null;
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		//System.out.print("Write the  SideEffects' name: ");
		//String name = reader.readLine();
		//System.out.println("Matching SideEffects:");
		Query q1 = e.createNativeQuery("SELECT * FROM sideEffects WHERE name LIKE ?", SideEffects.class);
		q1.setParameter(1, "%" + name + "%");
		listSideEffects = (List<SideEffects>) q1.getResultList();
			
		
	}catch (Exception e) {
		e.printStackTrace();
		
		}
	return listSideEffects;	
	}
	
	public List<Symptoms> searchSymptomsbyname(String name) {
		List<Symptoms> listSymptoms= null;
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		//System.out.print("Write the  SideEffects' name: ");
		//String name = reader.readLine();
		//System.out.println("Matching SideEffects:");
		Query q1 = e.createNativeQuery("SELECT * FROM symptoms WHERE name LIKE ?", Symptoms.class);
		q1.setParameter(1, "%" + name + "%");
		listSymptoms = (List<Symptoms>) q1.getResultList();
			
		
	}catch (Exception e) {
		e.printStackTrace();
		
		}
	return listSymptoms;	
	}
	
	public void close() {
		try {
			e.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Delete_illness(Illnesses illness) {

		e.getTransaction().begin();
		e.remove(illness);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_symptoms(Symptoms symptom) {
		e.getTransaction().begin();
		e.remove(symptom);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_patients(Patients patient) {
		e.getTransaction().begin();
		e.remove(patient);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_intolerance(Intolerance intolerance) {
		e.getTransaction().begin();
		e.remove(intolerance);
		e.getTransaction().commit();
		e.close();

	}
	
	public void Delete_doctors(Doctor dr) {

		e.getTransaction().begin();
		e.remove(dr);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_Medicines(Medicines med) {

		e.getTransaction().begin();
		e.remove(med);
		e.getTransaction().commit();
		e.close();


	}
	public void Delete_sideeffects(SideEffects side) {

		e.getTransaction().begin();
		e.remove(side);
		e.getTransaction().commit();
		e.close();


	}
	
	public Illnesses getIllnessFromID(Integer id) {
		Query q1=this.e.createNativeQuery("SELECT * FROM illnesses WHERE id = ?", Illnesses.class);
	    q1.setParameter(1, id);
	    Illnesses ill=(Illnesses) q1.getSingleResult();
	    return ill;
	}
	//use after getIllnessFromID because we will need the object that this method returns.
	public void Update_Illnesses_Name(String new_Name,Illnesses i) {
    e.getTransaction().begin();
    i.setName(new_Name);
	e.getTransaction().commit();
	}

	public Patients getPatientsFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM patients WHERE id = ?", Patients.class);
	q1.setParameter(1, id);
	Patients patient=(Patients) q1.getSingleResult();
	return patient;
	}
	@Override
	public void Update_illness_Name(String new_Name, Illnesses i) {
		e.getTransaction().begin();
		i.setName(new_Name);
		e.getTransaction().commit();
		
	}
	@Override
	public void Update_patients_Name(String new_Name,Patients p) {
	e.getTransaction().begin();
	p.setName(new_Name);
	e.getTransaction().commit();

	}
	public void Update_patients_Gender(String new_Gender,Patients p){
	 e.getTransaction().begin();
	 p.setGender(new_Gender);
	 e.getTransaction().commit();	
	}

	public Symptoms getSymptomsFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM symptoms WHERE id = ?", Symptoms.class);
	q1.setParameter(1, id);
	Symptoms sym=(Symptoms) q1.getSingleResult();
	return sym;
	}
	public void Update_Symptoms_Diagnosis(String new_Diagnosis, Symptoms s) {
    e.getTransaction().begin();
	s.setDiagnosis(new_Diagnosis);
	e.getTransaction().commit();		

	}
    public void Update_Symptoms_Areas(String new_Area, Symptoms s) {
   	 e.getTransaction().begin();
   	 s.setAreas(new_Area);
   	 e.getTransaction().commit();	
    }
    public void Update_Symptoms_Duration(Integer new_Duration, Symptoms s) {
   	 e.getTransaction().begin();
   	 s.setDuration(new_Duration);
   	 e.getTransaction().commit();	
    }
    
	public SideEffects getSideEffectsFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM sideEffects WHERE id = ?", SideEffects.class);
	q1.setParameter(1, id);
	SideEffects sEffect=(SideEffects) q1.getSingleResult();
	return sEffect;
	}
	@Override
	public void Update_SideEffects_duration(Integer new_Duration, SideEffects s) {
	e.getTransaction().begin();
	s.setDuration(new_Duration);
	e.getTransaction().commit();	

	}
	public void Update_SideEffects_Area(String new_Area, SideEffects s) {
	  	 e.getTransaction().begin();
	   	 s.setArea(new_Area);
	   	 e.getTransaction().commit();
	}
	
	public Intolerance getIntoleranceFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM intolerance WHERE id = ?", Intolerance.class);
	q1.setParameter(1, id);
	Intolerance intolerance=(Intolerance) q1.getSingleResult();
	return intolerance;
	}
	@Override
	public void Update_intolerance_Name(String new_Name,Intolerance in) {
	  	 e.getTransaction().begin();
	   	 in.setName(new_Name);
	   	 e.getTransaction().commit();

	}

	public Medicines getMedicinesFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM medicines WHERE id = ?", Medicines.class);
	q1.setParameter(1, id);
	Medicines med=(Medicines) q1.getSingleResult();
	return med;
	}
	
	@Override
	public void Update_Medicines_Name(String new_Name, Medicines m) {
	e.getTransaction().begin();
	m.setName(new_Name);
	e.getTransaction().commit();

	}
	public void Update_Medicines_ActivePrinciple(String new_ActivePrinciple, Medicines m) {
	e.getTransaction().begin();
	m.setName(new_ActivePrinciple);
	e.getTransaction().commit();
	}
    
	public void Update_Medicines_price(double new_price, Medicines m) {
	e.getTransaction().begin();
	m.setPrice(new_price);
	e.getTransaction().commit();
	}

	public Doctor getDoctorFromID(Integer id) {
	Query q1=this.e.createNativeQuery("SELECT * FROM doctors WHERE id = ?", Doctor.class);
	q1.setParameter(1, id);
	Doctor dr=(Doctor) q1.getSingleResult();
	return dr;
	}
	@Override
	public void Update_Doctors_UserName(String new_UserName, Doctor d) {
		e.getTransaction().begin();
		d.setUserName(new_UserName);
		e.getTransaction().commit();
		
	}

	@Override
	public void Update_Doctors_Password(String new_Password, Doctor d) {
		e.getTransaction().begin();
		d.setPassword(new_Password);
		e.getTransaction().commit();
		
	}

	
}


