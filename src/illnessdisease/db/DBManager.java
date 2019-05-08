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
	public void Insert_Doctor(Doctor d);
	public void Insert_Medicines(Medicines j);
	public void Delete_illness(Illnesses i);
	public void Delete_symptoms(Symptoms i);
	public void Delete_patients(Patients p);
	public void Delete_intolerance(Intolerance in);
	public void Delete_Medicines(Medicines j);
	public void Delete_doctors(Doctor c);
	public void Delete_sideeffects(SideEffects s);
	public void Update_illness_Name(String new_Name,Illnesses i);
	public void Update_patients_Name(String new_Name,Patients p);
	public void Update_patients_Gender(String new_Gender,Patients p);
	public void Update_Symptoms_Diagnosis(String new_Diagnosis, Symptoms s);
	public void Update_Symptoms_Areas(String new_Area, Symptoms s);
	public void Update_Symptoms_Durartion(Integer new_Duration, Symptoms s);
	public void Update_SideEffects_duration(Integer new_Duration, SideEffects s);
	public void Update_SideEffects_Area(Integer new_Area, SideEffects s);
	public void Update_intolerance_Name(String new_Name,Intolerance in);
	public void Update_Medicines_Name(String new_Name, Medicines m);
	public void Update_Medicines_ActivePrinciple(String new_ActivePrinciple, Medicines m);
	public void Update_Medicines_price(double new_price, Medicines m);
	public void Update_Doctors_UserName(String new_UserName, Doctor d);
	public void Update_Doctors_Password(String new_Password, Doctor d);
}
