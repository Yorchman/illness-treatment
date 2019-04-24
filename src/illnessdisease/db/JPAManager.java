package illnessdisease.db;

import illnessdisease.pojo.Doctor;
import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;
import sample.db.pojos.Department;

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

	public void createPatient(Patients p) {

		e.getTransaction().begin();
		e.persist(p);
		e.getTransaction().commit();

	}

	public void createSideEffects(SideEffects s) {

		e.getTransaction().begin();
		e.persist(s);
		e.getTransaction().commit();

	}

	public void createIllness(Illnesses i) {

		e.getTransaction().begin();
		e.persist(i);
		e.getTransaction().commit();

	}

	public void createSymptoms(Symptoms s) {

		e.getTransaction().begin();
		e.persist(s);
		e.getTransaction().commit();

	}

	public void createMedicines(Medicines m) {

		e.getTransaction().begin();
		e.persist(m);
		e.getTransaction().commit();

	}

	public void createIntolerance(Intolerance i) {

		e.getTransaction().begin();
		e.persist(i);
		e.getTransaction().commit();

	}

	public void searchIllnessbyname(Illnesses i) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Write the illness name: ");
		String name = reader.readLine();
		System.out.println("Matching illnesses:");
		Query q1 = e.createNativeQuery("SELECT * FROM Illnesses WHERE name LIKE ?", Illnesses.class);
		q1.setParameter(1, "%" + name + "%");
		List<Illnesses> listIllnesses = (List<Illnesses>) q1.getResultList();
		
		
		for (Illnesses illness : listIllnesses) {
			System.out.println(i);
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
	public void Insert_illness(Illnesses c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Insert_intolerance(Intolerance c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Insert_patients(Patients c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Insert_sideeffects(SideEffects c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Insert_symptoms(Symptoms c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_illness(Illnesses i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_symptoms(Symptoms i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_patients(Patients p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_intolerance(Intolerance in) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_Medicines(Medicines j) {
		// TODO Auto-generated method stub

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
	public void createDoctor(Doctor i) {

		e.getTransaction().begin();
		e.persist(i);
		e.getTransaction().commit();

	}
	public void Update_Doctor(Doctor j) {
		// TODO Auto-generated method stub

	}
	public void Delete_Doctor(Doctor in) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete_doctors(Doctor c) {
		// TODO Auto-generated method stub
		
	}

}
