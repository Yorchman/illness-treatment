package illnessdisease.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import illnessdisease.db.*;
import illnessdisease.pojo.*;

/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;
 */

public class UI { // extends Application
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static void main(String[] args) throws SQLException {

		SQLManager sqlm = new SQLManager();
		JPAManager jpam = new JPAManager();
		sqlm.connect("./db/illnessdisease.db", "org.sqlite.JDBC");
		sqlm.createTables();
		jpam.connect();
		System.out.println("CREADAS CORRECTAMENTE (fuera del metodo)");

		int option;
		while (true) {
			try {
				BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
				printMenu();
				option = Integer.parseInt(consola.readLine());
				switch (option) {
				case 1:
					System.out.println("YOU SELECTED: ILLNESS, SELECT AN OPTION: ");
					Illnesses ill = new Illnesses();
					menu2();
					option = Integer.parseInt(consola.readLine());
					switch (option) {
					case 1:

						System.out.println("OPTION SELECTED: INSERT ILLNESS");
						String name;
						String type;
						String causes;
						boolean contagious;

						System.out.println("Insert name: ");
						name = consola.readLine();
						System.out.println("Insert type of illness: ");
						type = consola.readLine();
						System.out.println("Insert causes: ");
						causes = consola.readLine();
						while (true) {
							System.out.println("Is it contagious? (Y/N)");
							String leido = consola.readLine();
							if (leido.equals("Y")) {
								contagious = true;
								break;
							} else if (leido.equals("N")) {
								contagious = false;
								break;
							} else
								System.out.println("ERROR - You didn´t type Y or N, try again :)");
						}
						Illnesses insertedIllness = new Illnesses(name, type, causes, contagious); // sin
																									// id
						System.out.println("Does this illness produce any symptom?(yes/no)");
						String respuesta = consola.readLine();
						while (true) {

							if (respuesta.equals("yes")) {

								System.out.println("now i am going to print the symptoms: \n\n");
								System.out.print("if there isn't the symptoms wich the illnes is relationated return to the menu to introduce it \n");
								List<Symptoms> s = sqlm.printSymptoms();
								for (Symptoms s2 : s) {
									System.out.println(s2);

								}
								
								int a = 0;
								if(s.size()==0) {
									a=1;
								}
								while (a == 0) {
									System.out.println("introduce the id of the symptom that the illness produces: ");
									int ids = Integer.parseInt(consola.readLine());
									Symptoms s3 = jpam.getSymptomsFromID(ids);

									insertedIllness.addSymptom(s3);
									System.out.println("does the illness produce any more symptoms?(yes/no");
									String respuesta2 = consola.readLine();
									if (respuesta2.equals("yes")) {
										a = 0;
									} else {
										a++;
									}
								}
								break;
							}else if (respuesta.equals("no")){break;}
				
						}

						jpam.Insert_illness(insertedIllness);
						System.out.println("NOW I AM GOING TO PRINT THE ILLNESSES: \n\n");
						List<Illnesses> li = sqlm.printIllnes();
						for (Illnesses il : li) {
							System.out.println(il);
						}break;

					case 2:
						System.out.println("OPTION SELECTED: SEARCH ILLNESS");
						System.out.println("Introduce the name of the illness you are looking for: ");
						String nameIllness = consola.readLine();
						List<Illnesses> listIllnesses = jpam.searchIllnessbyname(nameIllness);
						if (listIllnesses != null) {
							for (Illnesses s : listIllnesses) {
								System.out.println(s);
							}
						} else {
							System.out.println("the illness with that name doesn't appear in our database");
						}
						break;
					case 3:
						System.out.println("OPTION SELECTED: DELETE ILLNESS");
						List<Illnesses> li3 = sqlm.printIllnes();
						for (Illnesses il3 : li3) {
							System.out.println(il3);
						}

						System.out.println("Insert the id of the illness that you want to delete: ");
						//If no es un int pide otra vez
						int id = Integer.parseInt(consola.readLine());
						Illnesses illness = jpam.getIllnessFromID(id);
						System.out.println(illness);
						sqlm.Delete_illness(illness);
						jpam.close();// eliminamos el illness encontrado
						// Se debería meter en un if pero no sé comprobar si el
						// searchIllness ha devuelto algo valido
						// o no. Se podría hacer if(esa movida != null) ???
						break;

					case 4:
						System.out.println("OPTION SELECTED: UPDATE ILLNESS");
						System.out.println("NOW I AM GOING TO PRINT THE ILLNESSES: \n\n");
						List<Illnesses> li2 = sqlm.printIllnes();
						for (Illnesses il : li2) {
							System.out.println(il);
						}
						System.out.println("INTRODUCE THE ID OF THE ILLNESS THAT YOU WANT TO UPDATE: ");
						id = Integer.parseInt(consola.readLine());
						// Hacer busqueda igual que en el case 3
						// Con lo que de esa busqueda:
						illness = jpam.getIllnessFromID(id);
						System.out.println("Insert the new name: ");
						String newName = consola.readLine();
						jpam.Update_Illnesses_Name(newName, illness);
						// lo
																		// hacemos
						// sqlm.Update_illness(i);
						// Hacer UPDATE sobre lo que nos dio la busqueda
						// anterior
						// sqlm.Update_illness_Name(newName, i);
						break;
					case 5:
						// Print illness
						System.out.println("NOW I AM GOING TO PRINT THE ILLNESSES: \n\n");
						List<Illnesses> li4 = sqlm.printIllnes();
						for (Illnesses il : li4) {
							System.out.println(il);
						}

						break;
					case 6:
						break;

					}
				
					break;

				case 2:
					System.out.println("YOU SELECTED INTOLERANCE, SELECT AN OPTION:  ");

					menu2();
					Integer option2 = Integer.parseInt(consola.readLine());

					switch (option2) {
					case 1:

						System.out.println("OPTION SELECTED: INSERT Intolerance");
						String name;
						

						System.out.println("Insert name: ");
						name = consola.readLine();
					
						
						
						Intolerance insertedIntolerance = new Intolerance(name); // sin
																									// id
						System.out.println("Do any patients suffered this intolerance?(yes/no)");
						String respuesta = consola.readLine();
						while (true) {

							if (respuesta.equals("yes")) {

								System.out.println("now i am going to print the patients: \n\n");
								System.out.print("if there aren't any patient yet suffering the intolerance, return to the menu to introduce it \n");
								List<Patients> p = sqlm.printPatient();
								for (Patients s2 : p) {
									System.out.println(s2);

								}
								
								int a = 0;
								if(p.size()==0) {
									a=1;
								}
								while (a == 0) {
									System.out.println("introduce the id of the symptom that the illness produces: ");
									int ids = Integer.parseInt(consola.readLine());
									Patients p3 = jpam.getPatientsFromID(ids);

									insertedIntolerance.addPatient(p3);
									System.out.println("does any more patient suffer this intolerance?(yes/no");
									String respuesta2 = consola.readLine();
									if (respuesta2.equals("yes")) {
										a = 0;
									} else {
										a++;
									}
								}
								break;
							}else if (respuesta.equals("no")){break;}
				
						}

						jpam.Insert_intolerance(insertedIntolerance);
						System.out.println("NOW I AM GOING TO PRINT THE INTOLERANCE: \n\n");
						List<Intolerance> in = sqlm.printIntolerance();
						for (Intolerance in2 : in) {
							System.out.println(in2);
						}break;

					case 2:
						System.out.println("OPTION SELECTED: SEARCH INTOLERANCE");
						/*System.out.println("Introduce the name of the intolerance you are looking for: ");
						String nameIntolerance = consola.readLine();
						List<Illnesses> listIllnesses = jpam.sea(nameIntolerance);
						if (listIllnesses != null) {
							for (Illnesses s : listIllnesses) {
								System.out.println(s);
							}
						} else {
							System.out.println("the illness with that name doesn't appear in our database");
						}
						break;*/
					case 3:
						System.out.println("OPTION SELECTED: DELETE INTOLERANCE");
						List<Intolerance> in3 = sqlm.printIntolerance();
						for (Intolerance in4 : in3) {
							System.out.println(in4);
						}

						System.out.println("Insert the id of the intolerance that you want to delete: ");
						//If no es un int pide otra vez
						int id = Integer.parseInt(consola.readLine());
						Intolerance intolerance = jpam.getIntoleranceFromID(id);
						System.out.println(intolerance);
						sqlm.Delete_intolerance(intolerance);
						jpam.close();
						break;

					case 4:
						System.out.println("OPTION SELECTED: UPDATE INTOLERANCE");
						System.out.println("NOW I AM GOING TO PRINT THE INTOLERANCE: \n\n");
						List<Intolerance> in2 = sqlm.printIntolerance();
						for (Intolerance in4: in2) {
							System.out.println(in4);
						}
						System.out.println("INTRODUCE THE ID OF THE INTOLERANCE THAT YOU WANT TO UPDATE: ");
						id = Integer.parseInt(consola.readLine());
						// Hacer busqueda igual que en el case 3
						// Con lo que de esa busqueda:
						intolerance = jpam.getIntoleranceFromID(id);
						System.out.println("Insert the new name: ");
						String newName = consola.readLine();
						jpam.Update_intolerance_Name(newName, intolerance);
						// lo
																		// hacemos
						// sqlm.Update_illness(i);
						// Hacer UPDATE sobre lo que nos dio la busqueda
						// anterior
						// sqlm.Update_illness_Name(newName, i);
						break;
					case 5:
						// Print illness
						List<Intolerance> in5 = sqlm.printIntolerance();
						for (Intolerance in4: in5) {
							System.out.println(in4);
						}

						break;
					case 6:
						break;

					}
					break;
				case 3:
					System.out.println("YOU SELECTED: MEDICINES, SELECT AN OPTION: ");
					menu2();
					option = Integer.parseInt(consola.readLine());
					switch (option) {
					case 1:
						System.out.println("YOU SELECTED: MEDICINES, SELECT AN OPTION: ");
						Medicines med = new Medicines();
						menu2();
						option = Integer.parseInt(consola.readLine());
						switch (option) {
						case 1:

							System.out.println("OPTION SELECTED: INSERT MEDICINES");
							String name;
							String activePrinciple;
							Double price;
							boolean SSCover;

							System.out.println("Insert name: ");
							name = consola.readLine();
							System.out.println("Insert active Principle: ");
							activePrinciple = consola.readLine();
							System.out.println("Insert the price: ");
							price = Double.parseDouble(consola.readLine());
							while (true) {
								System.out.println("Is it covered by SS? (Y/N)");
								String leido = consola.readLine();
								if (leido.equals("Y")) {
									SSCover = true;
									break;
								} else if (leido.equals("N")) {
									SSCover = false;
									break;
								} else
									System.out.println("ERROR - You didn´t type Y or N, try again :)");
							}
							Medicines insertedMedicine = new Medicines(name, activePrinciple, price, SSCover); // sin
																										// id
							System.out.println("Does this meicinine is been used by any patient ?(yes/no)");
							String respuesta = consola.readLine();
							while (true) {

								if (respuesta.equals("yes")) {

									System.out.println("now i am going to print the patients: \n\n");
									System.out.print("if there isn't the patients using this medicine return to the menu to introduce it \n");
									List<Patients> p = sqlm.printPatient();
									for (Patients p2 : p) {
										System.out.println(p2);

									}
									
									int a = 0;
									if(p.size()==0) {
										a=1;
									}
									while (a == 0) {
										System.out.println("introduce the id of the patient that is using this medicine: ");
										int ids = Integer.parseInt(consola.readLine());
										Patients p3 = jpam.getPatientsFromID(ids);

										insertedMedicine.addPatient(p3);
										System.out.println("does the medicine is used by any other patient?(yes/no");
										String respuesta2 = consola.readLine();
										if (respuesta2.equals("yes")) {
											a = 0;
										} else {
											a++;
										}
									}
									break;
								}else if (respuesta.equals("no")){break;}
					
							}

							jpam.Insert_Medicines(insertedMedicine);
							System.out.println("NOW I AM GOING TO PRINT THE MEDICINE: \n\n");
							List<Medicines> med2 = sqlm.printMedicines();
							for (Medicines med3 : med2) {
								System.out.println(med3);
							}break;

						case 2:
							System.out.println("OPTION SELECTED: SEARCH MEDICINES");
							System.out.println("Introduce the name of the medicines you are looking for: ");
							String nameMedicines = consola.readLine();
							List<Medicines> listMedicines = jpam.searchMedicinesbyname(nameMedicines);
							if (listMedicines != null) {
								for (Medicines med3 : listMedicines) {
									System.out.println(med3);
								}
							} else {
								System.out.println("the medicine with that name doesn't appear in our database");
							}
							break;
						case 3:
							System.out.println("OPTION SELECTED: DELETE MEDICINES");
							List<Medicines> med3 = sqlm.printMedicines();
							for (Medicines med4 : med3) {
								System.out.println(med4);
							}

							System.out.println("Insert the id of the medicine that you want to delete: ");
							//If no es un int pide otra vez
							int id = Integer.parseInt(consola.readLine());
							Medicines medicines = jpam.getMedicinesFromID(id);
							System.out.println(medicines);
							sqlm.Delete_Medicines(medicines);
							jpam.close();// eliminamos el illness encontrado
							// Se debería meter en un if pero no sé comprobar si el
							// searchIllness ha devuelto algo valido
							// o no. Se podría hacer if(esa movida != null) ???
							break;

						case 4:
							System.out.println("OPTION SELECTED: UPDATE MEDICINES");
							System.out.println("NOW I AM GOING TO PRINT THE MEDICINES: \n\n");
							List<Medicines> med4 = sqlm.printMedicines();
							for (Medicines med5 : med4) {
								System.out.println(med5);
							}
							System.out.println("INTRODUCE THE ID OF THE MEDICINES THAT YOU WANT TO UPDATE: ");
							id = Integer.parseInt(consola.readLine());
							// Hacer busqueda igual que en el case 3
							// Con lo que de esa busqueda:
						medicines = jpam.getMedicinesFromID(id);
							System.out.println("Insert the new name: ");
							String newName = consola.readLine();
							jpam.Update_Medicines_Name(newName, medicines);
							// lo
																			// hacemos
							// sqlm.Update_illness(i);
							// Hacer UPDATE sobre lo que nos dio la busqueda
							// anterior
							// sqlm.Update_illness_Name(newName, i);
							break;
						case 5:
							// Print illness
							System.out.println("NOW I AM GOING TO PRINT THE ILLNESSES: \n\n");
							List<Medicines> med1 = sqlm.printMedicines();
							for (Medicines med5 : med1) {
								System.out.println(med1);
							}

							break;
						case 6:
							break;

						}
					

				case 4:
					System.out.println("YOU SELECTED: PATIENTS, SELECT AN OPTION: ");

					menu2();
					option2 = Integer.parseInt(consola.readLine());

						switch (option) {
						case 1:

							System.out.println("OPTION SELECTED: INSERT PATIENTS");
							Integer SSN;
							String name;
							Date date;
							String gender;
							 byte[] photo;
							 String password;

							System.out.println("Insert SSN: ");
							SSN = Integer.parseInt(consola.readLine());
							System.out.println("Insert the name: ");
							name = consola.readLine();
							System.out.println("Insert dob: ");
							System.out.print("Date of Birth (yyyy-MM-dd): ");
							String dob = consola.readLine();
							LocalDate dobDate = LocalDate.parse(dob, formatter);
							System.out.println("introduce the gender: ");
							gender=consola.readLine();
							System.out.println("does the patient have a photo?");
							System.out.println("introduce Y/N: ");
						
							String leido=consola.readLine();
							photo=null;
							int a=0;
							while (true) {
								if (leido.equals("Y")) {
									System.out.println("introduce the name of the file: ");
									String fileName=consola.readLine();
									File photox = new File("./photos/" + fileName);
									InputStream streamBlob = new FileInputStream(photox);
									photo = new byte[streamBlob.available()];
									a++;
									break;
								} else if (leido.equals("N")) {
									
									break;
								} else
									System.out.println("ERROR - You didn´t type Y or N, try again :)");
							}
							System.out.println("introduce the password: ");
							password=consola.readLine();
							if(a!=0) {
							//Patients patients=new Patients(SSN,name,dobDate,gender,password); // sin
							}else {
							//	Patients patients=new Patients(SSN,name,dobDate,gender,photo,password);
							}
							break;

						case 2:
							System.out.println("OPTION SELECTED: SEARCH PATIENTS");
							System.out.println("Introduce the name of the patients you are looking for: ");
							String namePatient = consola.readLine();
							List<Patients> listPatients = jpam.searchPatientsbyname(namePatient);
							if (listPatients != null) {
								for (Patients p : listPatients) {
									System.out.println(p);
								}
							} else {
								System.out.println("the patients with that name doesn't appear in our database");
							}
							break;
						case 3:
							System.out.println("OPTION SELECTED: DELETE PATIENTS");
							List<Patients> pa = sqlm.printPatient();
							for (Patients p2 : pa) {
								System.out.println(p2);
							}

							System.out.println("Insert the id of the patient that you want to delete: ");
							//If no es un int pide otra vez
							int id = Integer.parseInt(consola.readLine());
							Patients patient = jpam.getPatientsFromID(id);
							System.out.println(patient);
							sqlm.Delete_patients(patient);
							jpam.close();// eliminamos el illness encontrado
							// Se debería meter en un if pero no sé comprobar si el
							// searchIllness ha devuelto algo valido
							// o no. Se podría hacer if(esa movida != null) ???
							break;

						case 4:
							System.out.println("OPTION SELECTED: UPDATE PATIENTS");
							System.out.println("NOW I AM GOING TO PRINT THE PATIENTS: \n\n");
							List<Patients> pat = sqlm.printPatient();
							for (Patients p : pat) {
								System.out.println(p);
							}
							System.out.println("INTRODUCE THE ID OF THE PATIENT THAT YOU WANT TO UPDATE: ");
							id = Integer.parseInt(consola.readLine());
							// Hacer busqueda igual que en el case 3
							// Con lo que de esa busqueda:
							Patients patientup= jpam.getPatientsFromID(id);
							System.out.println("Insert the new name: ");
							String newName = consola.readLine();
							jpam.Update_patients_Name(newName, patientup);
							// lo
																			// hacemos
							// sqlm.Update_illness(i);
							// Hacer UPDATE sobre lo que nos dio la busqueda
							// anterior
							// sqlm.Update_illness_Name(newName, i);
							break;
						case 5:
							// Print illness
							System.out.println("OPTION SELECTED: UPDATE PATIENTS");
							System.out.println("NOW I AM GOING TO PRINT THE PATIENTS: \n\n");
							List<Patients> pati = sqlm.printPatient();
							for (Patients p : pati) {
								System.out.println(p);
							}

							break;}
					break;

				case 5:
					System.out.println("YOU SELECTED: SIDE EFFECTS, SELECT AN OPTION: ");

					menu2();
					option2 = Integer.parseInt(consola.readLine());

					switch (option2) {
					case 1:
						// INSERT SIDE EFFECT
						/*
						 * System.out.println(
						 * "OPTION SELECTED: INSERT SIDE EFFECT"); String name;
						 * 
						 * System.out.println("Insert name: "); name =
						 * consola.readLine(); Intolerance insertedIntolerance =
						 * new Intolerance(name); // sin // id
						 * sqlm.Insert_intolerance(insertedIntolerance);
						 * System.out.println(
						 * "now i am going to print the intolerances: \n\n");
						 * List<Intolerance> in = sqlm.printIntolerance(); for
						 * (Intolerance i : in) { System.out.println(i); }
						 */
						break;

					case 2:

						// SEARCH SIDE EFFECT
						/*
						 * System.out.println(
						 * "OPTION SELECTED: SEARCH INTOLERANCE");
						 * System.out.println(
						 * "Introduce the name of the intolerance you are looking for: "
						 * ); String nameIntolerance=consola.readLine();
						 * List<Intolerance> listIntolerance=
						 * jpam.searchIntolerancebyname(nameIntolerance);
						 * if(listIntolerance!=null){ for(Intolerance into:
						 * listIntolerance) { System.out.println(into); } }else
						 * { System.out.println(
						 * "the intolerance with that name doesn't appear in our database"
						 * ); }
						 */
						break;
					case 3:
						// DELETE SIDE EFFECT
						/*
						 * System.out.println(
						 * "OPTION SELECTED: DELETE INTOLERANCE");
						 * sqlm.printIllnes(); System.out.println(
						 * "Insert the id of the intolerance that you want to delete: "
						 * ); int id = Integer.parseInt(consola.readLine());
						 * Intolerance intolerance =
						 * jpam.getIntoleranceFromID(id);
						 * 
						 * sqlm.Delete_intolerance(intolerance); jpam.close();//
						 * eliminamos el illness encontrado // Se debería meter
						 * en un if pero no sé comprobar si el // searchIllness
						 * ha devuelto algo valido // o no. Se podría hacer
						 * if(esa movida != null) ???
						 */
						break;
					case 4:
						// UPDATE SIDE EFFECT

						/*
						 * System.out.println(
						 * "OPTION SELECTED: UPDATE INTOLERANCE");
						 * System.out.println(
						 * "INTRODUCE THE ID OF THE INTOLERANCE THAT YOU WANT TO UPDATE: "
						 * ); id = Integer.parseInt(consola.readLine()); //
						 * Hacer busqueda igual que en el case 3 // Con lo que
						 * de esa busqueda: intolerance =
						 * jpam.getIntoleranceFromID(id); System.out.println(
						 * "Insert the new name: "); String newName =
						 * consola.readLine();
						 * jpam.Update_intolerance_Name(newName, intolerance);
						 * // lo hacemos // sqlm.Update_illness(i); // Hacer
						 * UPDATE sobre lo que nos dio la busqueda // anterior
						 * // sqlm.Update_illness_Name(newName, i);
						 * 
						 */
						break;
					case 5:
						List<SideEffects> in2 = sqlm.printSideEffects();
						for (SideEffects i : in2) {
							System.out.println(i);
						}
						break;
					}
					break;

				case 6:
					System.out.println("YOU SELECTED: SYMPTOMS, SELECT AN OPTION: ");

					menu2();
					option2 = Integer.parseInt(consola.readLine());

					switch (option2) {
					case 1:
						// INSERT SYMPTOM
						/*
						 * System.out.println(
						 * "OPTION SELECTED: INSERT SIDE EFFECT"); String name;
						 * 
						 * System.out.println("Insert name: "); name =
						 * consola.readLine(); Intolerance insertedIntolerance =
						 * new Intolerance(name); // sin // id
						 * sqlm.Insert_intolerance(insertedIntolerance);
						 * System.out.println(
						 * "now i am going to print the intolerances: \n\n");
						 * List<Intolerance> in = sqlm.printIntolerance(); for
						 * (Intolerance i : in) { System.out.println(i); }
						 */
						break;

					case 2:

						// SEARCH SYMPTOM
						/*
						 * System.out.println(
						 * "OPTION SELECTED: SEARCH INTOLERANCE");
						 * System.out.println(
						 * "Introduce the name of the intolerance you are looking for: "
						 * ); String nameIntolerance=consola.readLine();
						 * List<Intolerance> listIntolerance=
						 * jpam.searchIntolerancebyname(nameIntolerance);
						 * if(listIntolerance!=null){ for(Intolerance into:
						 * listIntolerance) { System.out.println(into); } }else
						 * { System.out.println(
						 * "the intolerance with that name doesn't appear in our database"
						 * ); }
						 */
						break;
					case 3:
						// DELETE SYMPTOM
						/*
						 * System.out.println(
						 * "OPTION SELECTED: DELETE INTOLERANCE");
						 * sqlm.printIllnes(); System.out.println(
						 * "Insert the id of the intolerance that you want to delete: "
						 * ); int id = Integer.parseInt(consola.readLine());
						 * Intolerance intolerance =
						 * jpam.getIntoleranceFromID(id);
						 * 
						 * sqlm.Delete_intolerance(intolerance); jpam.close();//
						 * eliminamos el illness encontrado // Se debería meter
						 * en un if pero no sé comprobar si el // searchIllness
						 * ha devuelto algo valido // o no. Se podría hacer
						 * if(esa movida != null) ???
						 */
						break;
					case 4:
						// UPDATE SYMPTOM

						/*
						 * System.out.println(
						 * "OPTION SELECTED: UPDATE INTOLERANCE");
						 * System.out.println(
						 * "INTRODUCE THE ID OF THE INTOLERANCE THAT YOU WANT TO UPDATE: "
						 * ); id = Integer.parseInt(consola.readLine()); //
						 * Hacer busqueda igual que en el case 3 // Con lo que
						 * de esa busqueda: intolerance =
						 * jpam.getIntoleranceFromID(id); System.out.println(
						 * "Insert the new name: "); String newName =
						 * consola.readLine();
						 * jpam.Update_intolerance_Name(newName, intolerance);
						 * // lo hacemos // sqlm.Update_illness(i); // Hacer
						 * UPDATE sobre lo que nos dio la busqueda // anterior
						 * // sqlm.Update_illness_Name(newName, i);
						 * 
						 */
						break;
					case 5:
						List<Symptoms> in2 = sqlm.printSymptoms();
						for (Symptoms i : in2) {
							System.out.println(i);
						}
						break;
					}

					break;
				}
				}} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public static void printMenu() {
		System.out.println("-----WELCOME-----");
		System.out.println("OPTION 1: ILLNESSES");
		System.out.println("OPTION 2: INTOLERANCE");
		System.out.println("OPTION 3: MEDICINES");
		System.out.println("OPTION 4: PATIENTS");
		System.out.println("OPTION 5: SIDE EFFECTS");
		System.out.println("OPTION 6: SYMPTOMS");

	}

	// Try catch
	/*
	 * try{ BufferedReader consola = new BufferedReader(new <<<<<<< HEAD
	 * InputStreamReader(System.in)); System.out.println(
	 * "Option 1: Insert an illness\n" + "Option 2: Delete an illness\n");
	 * System.out.println("Select an option: "); option =
	 * Integer.parseInt(consola.readLine()); return option; }catch(IOException
	 * ex){ ex.printStackTrace(); return 0; } =======
	 * InputStreamReader(System.in)); System.out.println(
	 * "Option 1: Insert an illness\n" + "Option 2: Delete an illness\n");
	 * System.out.println("Select an option: "); option =
	 * Integer.parseInt(consola.readLine()); return option; }catch(IOException
	 * ex){ ex.printStackTrace(); return 0; } >>>>>>> branch 'master' of
	 * https://github.com/Yorchman/illness-treatment.git
	 */

	static void menu2() {
		System.out.println("Introduce 1 to insert ");
		System.out.println("Introduce 2 to search");
		System.out.println("Introduce 3 to delete");
		System.out.println("Introduce 4 to update");
		System.out.println("Introduce 5 to print");
		System.out.println("Introduce 6 to exit");
	}

	/*
	 * static void inicilizeTables(){ try{ Illnesses ill = new Illnesses();
	 * ill.SQLCreate(); } catch(TableCreationException e ){ e.tableExists();
	 * 
	 * } try{ FunctionsDB<Nurse> nur = new DB_Nurse(); nur.SQLCreate(); }
	 * <<<<<<< HEAD catch(TableCreationException e ){ e.tableExists(); } try{
	 * FunctionsDB<Cells> cells = new DB_Cells(); cells.SQLCreate(); }
	 * catch(TableCreationException e ){ e.tableExists(); } try{
	 * FunctionsDB<Molecules> molecules = new DB_Molecules();
	 * molecules.SQLCreate(); } catch(TableCreationException e ){
	 * e.tableExists(); } try{ FunctionsDB<Symptoms> syn = new DB_Symptoms();
	 * syn.SQLCreate(); } catch(TableCreationException e ){ e.tableExists(); }
	 * try{ FunctionsDB<Illnes> ill = new DB_Illness(); ill.SQLCreate(); }
	 * ======= catch(TableCreationException e ){ e.tableExists(); } try{
	 * FunctionsDB<Cells> cells = new DB_Cells(); cells.SQLCreate(); }
	 * catch(TableCreationException e ){ e.tableExists(); } try{
	 * FunctionsDB<Molecules> molecules = new DB_Molecules();
	 * molecules.SQLCreate(); } catch(TableCreationException e ){
	 * e.tableExists(); } try{ FunctionsDB<Symptoms> syn = new DB_Symptoms();
	 * syn.SQLCreate(); } catch(TableCreationException e ){ e.tableExists(); }
	 * try{ FunctionsDB<Illnes> ill = new DB_Illness(); ill.SQLCreate(); }
	 * >>>>>>> branch 'master' of
	 * https://github.com/Yorchman/illness-treatment.git
	 * catch(TableCreationException e ){ e.tableExists(); } try{
	 * FunctionsDB<Patient> pat = new DB_Patient(); pat.SQLCreate(); }
	 * catch(TableCreationException e ){ e.tableExists(); }
	 * 
	 * 
	 * }
	 */

}

/*
 * { launch(args); }
 * 
 * 
 * 
 * Button btn;
 * 
 * @Override public void start (Stage primaryStage) { // Create the button btn =
 * new Button(); btn.setText("Click me please!"); btn.setOnAction(e ->
 * buttonClick()); // Add the button to a layout pane BorderPane pane = new
 * BorderPane(); pane.setCenter(btn); // Add the layout pane to a scene Scene
 * scene = new Scene(pane, 300, 250); // Finalize and show the stage
 * primaryStage.setScene(scene); primaryStage.setTitle("The Click Me App");
 * primaryStage.show(); } public void buttonClick() { if (btn.getText() ==
 * <<<<<<< HEAD "Click me please!") { btn.setText("You clicked me!"); } else {
 * btn.setText( "Click me please!"); } }
 * 
 * }
 * 
 * 
 * //YO creo los objetos y llamo al manager para que inserte movidas /*public
 * static void main(String args[]){ SQLManager manager; int option; manager =
 * new SQLManager(); //Load tables manager.createTables(); try{ BufferedReader
 * consola = new BufferedReader(new InputStreamReader(System.in));
 * System.out.println("Select an option: "); option =
 * Integer.parseInt(consola.readLine()); while (true){ printMenu();
 * switch(option){ case 1: System.out.println("Opción 1: Insert");
 * manager.createTables();
 * 
 * } }
 * 
 * 
 * }catch(IOException ex){ ex.printStackTrace(); } }
 * 
 * public static int printMenu(){ int option; try{ BufferedReader consola = new
 * BufferedReader(new InputStreamReader(System.in)); System.out.println(
 * "Option 1: Insert an illness\n" + "Option 2: Delete an illness\n");
 * System.out.println("Select an option: "); option =
 * Integer.parseInt(consola.readLine()); return option; }catch(IOException ex){
 * ex.printStackTrace(); return 0; } } } ======= "Click me please!") {
 * btn.setText("You clicked me!"); } else { btn.setText("Click me please!"); } }
 * 
 * }
 * 
 * 
 * //YO creo los objetos y llamo al manager para que inserte movidas /*public
 * static void main(String args[]){ SQLManager manager; int option; manager =
 * new SQLManager(); //Load tables manager.createTables(); try{ BufferedReader
 * consola = new BufferedReader(new InputStreamReader(System.in));
 * System.out.println("Select an option: "); option =
 * Integer.parseInt(consola.readLine()); while (true){ printMenu();
 * switch(option){ case 1: System.out.println("Opción 1: Insert");
 * manager.createTables();
 * 
 * } }
 * 
 * 
 * }catch(IOException ex){ ex.printStackTrace(); } }
 * 
 * public static int printMenu(){ int option; try{ BufferedReader consola = new
 * BufferedReader(new InputStreamReader(System.in)); System.out.println(
 * "Option 1: Insert an illness\n" + "Option 2: Delete an illness\n");
 * System.out.println("Select an option: "); option =
 * Integer.parseInt(consola.readLine()); return option; }catch(IOException ex){
 * ex.printStackTrace(); return 0; } } } >>>>>>> branch 'master' of
 * https://github.com/Yorchman/illness-treatment.git
 */
