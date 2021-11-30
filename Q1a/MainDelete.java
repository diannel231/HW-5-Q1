import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Professor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			
			Professor tempProfessor = session.get(Professor.class, 1);
			
			session.delete(tempProfessor);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
