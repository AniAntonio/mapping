import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.hibernate.pojo.Product;
import com.hibernate.util.HibernateUtil;

import model.Order;
import model.Role;
import model.Store;
import model.StoreProduct;
import model.User;

public class TestMain {
	private static EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
	private static EntityTransaction tx = em.getTransaction();

	public static void main(String[] args) {
		tx.begin();
		
	
		TypedQuery<User> userQuery = em
				.createQuery("Select u from User u  ", User.class);
		
		TypedQuery<Order> orderQuery = em
				.createQuery("Select o from Order o  ", Order.class);
		
		TypedQuery<Store> storeQuery = em
				.createQuery("Select s from Store s where s.id=:id ", Store.class);
		storeQuery.setParameter("id", 2);
		
		
		
/*	List<Order> order = orderQuery.getResultList();
		order.forEach(sp -> {
			
			User u = sp.getEmployee();	
			System.out.println(u);
			
		});*/
	/*	List<User> user = userQuery.getResultList();
		User x = em.find(User.class, 5);
		for (Order u : x.getOrders()) {
			System.out.println(u.getClient());
		}*/

		
		tx.commit();
		em.close();
	}

	
		public static void create() {
			User user = new User();
			Role role = em.find(Role.class, 3);
			user.setFirstname("newssUser");
			user.setLastname("12 s");
			user. setUsername("12 s");
			user.setMobile("+355s");
			user.setPassword("12 s");
			user.setAddress("12 s");
			user.setEmail("12 s");
			user.setRole(role);
			em.persist(user);
		}






}
