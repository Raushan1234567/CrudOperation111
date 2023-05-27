package com.masai.Maven233;
import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
	
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("Raushan");
	}
	
	
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);
       int c;
       do {
    	   System.out.println("1. Add Details");
    	   System.out.println("2. Update Details");
    	   System.out.println("3. Delete Details");
    	   System.out.println("4. Serch by id");
    	   System.out.println("5. Serch by salary range");
    	   System.out.println("0. Exit");
    	   
    	   c=sc.nextInt();
    	   switch(c) {
    	   case 1:
    		   Add(sc);
    		   break;
    	   case 2:
    		   Udate(sc);
    		   break;
    	   case 3:
    		  Delete(sc);
    		   break;
    	   case 4:
    		   Serchbyid(sc);
    		   break;
    	   case 5:
    		   Serchbysalary(sc);
    		   break;
    	   case 0:
    		 System.out.println("thanks");
    		   break;
    		   default :
    			   System.out.println("Invavalid");
    			   break;
    		   
    		   
    	   }
    			   
    	   
       }while(c!=0);
       sc.close();
    }


	private static void Add(Scanner sc) {
		
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter joining date");
	LocalDate jdate=LocalDate.parse(sc.next());
		System.out.println("Enter salary");
		double salary=sc.nextDouble();
		System.out.println("Enter Adhar");
		long adhar=sc.nextLong();
		
		Labour a=new Labour(name,address,jdate,salary,adhar);
		
		Addprompt(a);
		
		
		
	}


	private static void Addprompt(Labour a) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
		et.commit();
		em.close();
		
	}


	private static void Udate(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		int id=sc.nextInt();
		System.out.println("Enter salary");
		double salary=sc.nextDouble();
		System.out.println("Enter Salary");
		long adhar=sc.nextLong();
		
		UpdatePrompt(id,salary,adhar);
		
		
	}


	private static void UpdatePrompt(int id, double salary, long adhar) {
		
		EntityManager em=emf.createEntityManager();
		Labour t=em.find(Labour.class, id);
		if(t==null)
		{
			System.out.println("Labour not found for this specifi id");
		}
		else {
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		t.setSalary(salary);
		t.setAdharno(adhar);
		et.commit();
		}
		em.close();
		
		
	}


	private static void Delete(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		DeletePrompt(id);
		
	}


	private static void DeletePrompt(int id) {
		EntityManager em=emf.createEntityManager();
		Labour t=em.find(Labour.class, id);
		if(t==null)
		{
			System.out.println("Labour not found for this specific id");
		}
		else {
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
        em.remove(t);

		et.commit();
		}
		em.close();
		
	}


	private static void Serchbyid(Scanner sc) {
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		SearchPrompt(id);
		
	}


	private static void SearchPrompt(int id) {
		EntityManager em=emf.createEntityManager();
		Labour t=em.find(Labour.class, id);
		if(t==null)
		{
			System.out.println("Labour not found for this specific id");
		}else {
			System.out.println("id :"+t.getId() +" name :"+t.getName() +" address :"+t.getAddress() +" jdate :"+t.getJoindate() +" Salary: "+ t.getSalary()+" adhar: "+ t.getAdharno());
		}
		em.close();
		
	}


	private static void Serchbysalary(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
}
