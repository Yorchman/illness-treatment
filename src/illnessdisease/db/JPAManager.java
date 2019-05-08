package illnessdisease.db;

import illnessdisease.pojo.Doctor;
import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

	public void searchIllnessbyname(Illnesses i) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		System.out.print("Write the illness' name: ");
		String name = reader.readLine();
		System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM Illnesses WHERE name LIKE ?", Illnesses.class);
		q1.setParameter(1, "%" + name + "%");
		List<Illnesses> listIllnesses = (List<Illnesses>) q1.getResultList();
		
		
		for (Illnesses illness : listIllnesses) {
			System.out.println(illness);
		}
	}
	
	catch (Exception e) {
		
		}
	}
	
	public void searchPatientsbyname(Patients p) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		System.out.print("Write the patient's name: ");
		String name = reader.readLine();
		System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM Patients WHERE name LIKE ?", Patients.class);
		q1.setParameter(1, "%" + name + "%");
		List<Patients> listPatients = (List<Patients>) q1.getResultList();
		
		
		for (Patients patients : listPatients) {
			System.out.println(patients);
		}
	}
	
	catch (Exception e) {
		
		}	
	}
	public void searchMedicinesbyname(Medicines m) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		System.out.print("Write the medicine's name: ");
		String name = reader.readLine();
		System.out.println("Matching medicines:");
		Query q1 = e.createNativeQuery("SELECT * FROM Medicines WHERE name LIKE ?", Medicines.class);
		q1.setParameter(1, "%" + name + "%");
		List<Medicines> listMedicines = (List<Medicines>) q1.getResultList();
		
		
		for (Medicines medicines : listMedicines) {
			System.out.println(medicines);
		}
	}
	
	catch (Exception e) {
		
		}	
	}
	public void searchSideEffectsbyname(SideEffects s) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
				
		System.out.print("Write the  SideEffects' name: ");
		String name = reader.readLine();
		System.out.println("Matching SideEffects:");
		Query q1 = e.createNativeQuery("SELECT * FROM SideEffects WHERE name LIKE ?", SideEffects.class);
		q1.setParameter(1, "%" + name + "%");
		List<SideEffects> listSideEffects = (List<SideEffects>) q1.getResultList();
		
		
		for (SideEffects sideEffects : listSideEffects) {
			System.out.println(sideEffects);
		}
	}
	
	catch (Exception e) {
		
		}	
	}
	public void close() {
		try {
			e.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Delete_illness(Illnesses i) {
		Query q1 = e.createNativeQuery("SELECT * FROM illness WHERE id = ?", Illnesses.class);
		q1.setParameter(1, i.getId());
		Illnesses illness = (Illnesses) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(illness);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_symptoms(Symptoms i) {
		Query q1 = e.createNativeQuery("SELECT * FROM symptoms WHERE id = ?", Symptoms.class);
		q1.setParameter(1, i.getId());
		Symptoms symptom = (Symptoms) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(symptom);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_patients(Patients p) {
		Query q1 = e.createNativeQuery("SELECT * FROM patients WHERE id = ?", Patients.class);
		q1.setParameter(1, p.getId());
		Patients patient = (Patients) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(patient);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_intolerance(Intolerance in) {
		Query q1 = e.createNativeQuery("SELECT * FROM intolerance WHERE id = ?", Intolerance.class);
		q1.setParameter(1, in.getId());
		Intolerance intolerance = (Intolerance) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(intolerance);
		e.getTransaction().commit();
		e.close();

	}
	
	public void Delete_doctors(Doctor in) {

		Query q1 = e.createNativeQuery("SELECT * FROM doctors WHERE id = ?", Doctor.class);
		q1.setParameter(1, in.getId());
		Doctor doctor = (Doctor) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(doctor);
		e.getTransaction().commit();
		e.close();

	}

	@Override
	public void Delete_Medicines(Medicines j) {
		Query q1 = e.createNativeQuery("SELECT * FROM medicines WHERE id = ?", Medicines.class);
		q1.setParameter(1, j.getId());
		Medicines medicine = (Medicines) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(medicine);
		e.getTransaction().commit();
		e.close();


	}
	public void Delete_sideeffects(SideEffects j) {
		Query q1 = e.createNativeQuery("SELECT * FROM sideEffects WHERE id = ?", SideEffects.class);
		q1.setParameter(1,j.getId());
		SideEffects side = (SideEffects) q1.getSingleResult();

		e.getTransaction().begin();
		e.remove(side);
		e.getTransaction().commit();
		e.close();


	}
	
	public Illnesses getIllnessFromID(Integer id) {
		Query q1=this.e.createNativeQuery("SELECT * FROM illness WHERE id = ?", Illnesses.class);
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
    public void Update_Symptoms_Durartion(Integer new_Duration, Symptoms s) {
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

	public Medicines getMEdicinesFromID(Integer id) {
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

	@Override
	public void Update_Medicines(Medicines j) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_illness_Name(String new_Name, Illnesses i) {
		// TODO Auto-generated method stub
		
	}
}


