  package bunny.HyberNet;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
        Metadata md = new MetadataSources().getMetadataBuilder(ssr).build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t;
    
		
		  Student s1 = new Student();
		  s1.setName("Bunny");
		  t = s.beginTransaction();
		  s.save(s1);
		  t.commit();
		  System.out.println("Data Inserted");
		 
        
		
		  Acceleration ac = new Acceleration();
		  ac.setName("Gnani");
		  ac.setCourse("Jfsd"); 
		  ac.setResult("Pass");
		  t = s.beginTransaction();
		  s.save(ac);
		  t.commit();
		  System.out.println("Data Inserted!!!!");
		 
        
		
//		
//		  OddSemester od = new OddSemester();
//		  od.setCourse("Mswd");
//		  od.setName("Tharun"); 
//		  od.setRegistration("Yes"); 
//		  t = s.beginTransaction();
//		  s.save(od); 
//		  t.commit();
//		  System.out.println("Data inserted in OddSemister!!!");
		 
		 
		  Student s2=s.find(Student.class, 20);
		  s2.setName("Xyz");
		  t=s.beginTransaction();
		  s.update(s2);
		  s.delete(s2);
		  t.commit();
		  System.out.println("Deleted  Successfully!!!");
		  
		  Criteria c = s.createCriteria(Student.class);
		  c.add(Restrictions.gt("id", 3));
		  List<Student> l=c.list();
		  for(Student s3 : l)
		  {
			  System.out.println("id = " + s3.getId() + ", name = " + s3.getName());
		  }
		  
		  Query<Student> qry = s.createQuery("select ST from Student ST where ST.id > 3", Student.class);
		  List<Student> l1=qry.list();
		  for(Student s3 : l1)
		  {
			  System.out.println("id = " + s3.getId() + ", name = " + s3.getName());
		  }
		 


    }
}
