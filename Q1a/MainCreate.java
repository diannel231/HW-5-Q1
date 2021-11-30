import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	
	public static void main(String[] args) {
		
		Customer tempCustomer = new Customer("Bob", "123 Elm Street");
		
		Professor tempProfessor = new Professor("8-50", "Machine Learning");
		
		tempProfessor.setCustomer(tempCustomer);
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(Professor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			session.save(tempProfessor);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			session.close();
			
			factory.close();
		}
	}

}
