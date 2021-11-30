import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Order.class)
								.addAnnotatedClass(Product.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Order tempOrder = new Order(formatter.parse("21/12/1980"), "Bob");
			
			session.save(tempOrder);
			
			List<Product> products = session.createQuery("from Order").list();
			
			Product tempProduct1 = new Product("Sandwich");
			Product tempProduct2 = new Product("Water");
			
			products.add(tempProduct1);
			products.add(tempProduct2);
			
			tempOrder.setProducts(products);
			
			
			session.getTransaction().commit();

			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}
	

}
