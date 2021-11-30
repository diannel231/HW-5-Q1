import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
	
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
			
			Product tempProduct = new Product("Hotdog");
			
			session.save(tempProduct);
			
			List<Order> orders = session.createQuery("from Product").list();
			
			Order tempOrder1 = new Order(formatter.parse("21/12/1980"), "Adam");
			Order tempOrder2 = new Order(formatter.parse("21/12/1980"), "David");
			
			orders.add(tempOrder1);
			orders.add(tempOrder2);
			
			
			tempProduct.setOrders(orders);
			
			
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
