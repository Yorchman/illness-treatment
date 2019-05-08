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

	@Override
	public void Update_illness(Illnesses i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_patients(Patients p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_symptoms(Symptoms i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_sideeffects(SideEffects s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_intolerance(Intolerance in) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update_Medicines(Medicines j) {
		// TODO Auto-generated method stub

	}

	public void Update_Doctor(Doctor j) {
		// TODO Auto-generated method stub

	}

}


