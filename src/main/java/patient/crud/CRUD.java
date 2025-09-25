package patient.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import patient.entity.Patient;
import patient.utility.Patient_Utility;

public class CRUD {
	
	
	public void add() {
		Patient p=new Patient();
		
		SessionFactory factory=Patient_Utility.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Patient Name :");
		String n=sc.next();
		p.setName(n);
		
		System.out.println("Enter Patient Age :");
		int i=sc.nextInt();
		p.setAge(i);
		
		System.out.println("Enter Patient Disease :");
		String d=sc.next();
		p.setDisease(d);
		
		System.out.println("Enter Patient Admitted Date");
		String a=sc.next();
		p.setAdmittedDate(a);
		
		session.persist(p);
		transaction.commit();
		session.close();
	}
	
	public void getAll() {
		
		Patient p=new Patient();
		
		SessionFactory factory=Patient_Utility.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		List<Patient> pList=session.createQuery("select a from Patient a",Patient.class).getResultList();
		
		pList.stream().forEach(k->System.out.println(k));
		
		
		transaction.commit();
		session.close();
		
	}
	
	public void update() {
		
		Patient p=new Patient();
		
		SessionFactory factory=Patient_Utility.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Admitted Date :");
		String d=sc.next();
		
		Patient pr=session.find(Patient.class, d);
		
		System.out.println("Enter Updated Admitted Date :");
		String q=sc.next();
		p.setAdmittedDate(q);
		
		session.persist(p);
		transaction.commit();
		session.close();
	}
	
	public void delete() {
		Patient p=new Patient();
		
		SessionFactory factory=Patient_Utility.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction =session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Patient id :");
		int i=sc.nextInt();
		Patient pi=session.find(Patient.class, i);
		
		session.remove(pi);
		transaction.commit();
		session.close();
		
	}

}
