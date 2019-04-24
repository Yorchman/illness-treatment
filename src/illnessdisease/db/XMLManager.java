package illnessdisease.db;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import illnessdisease.pojo.Medicines;


public class XMLManager {
	private static EntityManager em1;
	private static final String PERSISTENCE_PROVIDER = "illness-treatment";
	private static EntityManagerFactory em2;

public void marshallingMedicines(Medicines med) {
	
	em1 = Persistence.createEntityManagerFactory("illness-treatment").createEntityManager();
	em1.getTransaction().begin();
	em1.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
	em1.getTransaction().commit();
	JAXBContext jaxbContext;
	try {
		jaxbContext = JAXBContext.newInstance(Medicines.class);
	
	Marshaller marshaller = jaxbContext.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
	
	File file = new File("./xmls/Sample-Medicines.xml");
	marshaller.marshal(med, file);
	marshaller.marshal(med, System.out);
} catch (JAXBException e) {
	e.printStackTrace();
}}
public void unmarshallingMedicines(File file) {
	JAXBContext jaxbContext;
	try {
		jaxbContext = JAXBContext.newInstance(Medicines.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Medicines med = (Medicines) unmarshaller.unmarshal(file);
		System.out.println(med);
		em2 = Persistence.createEntityManagerFactory(PERSISTENCE_PROVIDER);
		EntityManager em3 = em2.createEntityManager();
		em3.getTransaction().begin();
		em3.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em3.getTransaction().commit();
		
	} catch (JAXBException e) {
		e.printStackTrace();
	}
	
}
}
