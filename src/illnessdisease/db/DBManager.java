package illnessdisease.db;

import illnessdisease.pojo.Illnesses;
import illnessdisease.pojo.Intolerance;
import illnessdisease.pojo.Medicines;
import illnessdisease.pojo.Patients;
import illnessdisease.pojo.SideEffects;
import illnessdisease.pojo.Symptoms;

public interface DBManager {
	public void Insert_illness(Illnesses c);
	public void Insert_intolerance(Medicines c);
	public void Insert_intolerance(Intolerance c);
	public void Insert_patients(Patients c);
	public void Insert_sideeffects(SideEffects c);
	public void Insert_symptoms(Symptoms c);
	public void Delete_illness(Illnesses i);
}
