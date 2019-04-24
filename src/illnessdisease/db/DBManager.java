package illnessdisease.db;

import illnessdisease.pojo.Doctor;
import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;

public interface DBManager {
	public void Insert_illness(Illnesses c);
	public void Insert_intolerance(Intolerance c);
	public void Insert_patients(Patients c);
	public void Insert_sideeffects(SideEffects c);
	public void Insert_symptoms(Symptoms c);
	public void Delete_illness(Illnesses i);
	public void Delete_symptoms(Symptoms i);
	public void Delete_patients(Patients p);
	public void Delete_intolerance(Intolerance in);
	public void Delete_Medicines(Medicines j);
	public void Delete_doctors(Doctor c);
	public void Update_illness(Illnesses i);
	public void Update_patients(Patients p);
	public void Update_symptoms(Symptoms i);
	public void Update_sideeffects(SideEffects s);
	public void Update_intolerance(Intolerance in);
	public void Update_Medicines(Medicines j);
}
