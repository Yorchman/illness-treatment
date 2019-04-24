package illnessdisease.db;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import illnessdisease.pojo.Medicines;

public class XMLManager {
	private static EntityManager em1;
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
	// TODO Auto-generated catch block
	e.printStackTrace();
}}

}
