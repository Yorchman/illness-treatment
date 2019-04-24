package illnessdisease.db;

import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;

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

}
