import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.hibernate.model.Order;
import com.hibernate.model.Product;
import com.hibernate.model.OrderProduct;
import com.hibernate.model.Store;
import com.hibernate.model.StoreProduct;
import com.hibernate.model.User;
import com.hibernate.util.HibernateUtil;

public class MainTest {
	private static EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
	private static EntityTransaction tx = em.getTransaction();

	public static void main(String[] args) {
		tx.begin();

		TypedQuery<User> userQuery = em.createQuery("Select u from User u  ", User.class);
		List<User> users = userQuery.getResultList();
	
		
		  TypedQuery<Order> orderQuery = em .createQuery("Select o from Order o where o.employee.id=:id ",
		  Order.class);
		  orderQuery.setParameter("id", 2);
		  
		/*  TypedQuery<Store> storeQuery = em
		  .createQuery("Select s from Store s where s.id=:id ", Store.class);
		  storeQuery.setParameter("id", 2);*/
		 

		//create();
	/*	 Order order = em.find(Order.class, 2);
		 
		  for (OrderProduct orderproduct : order.getOrderProducts()) {
			Product p = orderproduct.getStoreProduct().getProduct();
			System.out.println(p);
				}*/
			
		
		  
		 
		 
		/*
		 * List<User> user = userQuery.getResultList(); User x = em.find(User.class, 5);
		 * for (Order u : x.getOrders()) { System.out.println(u.getClient()); }
		 */

		tx.commit();
		em.close();
	}
	
	
	public static void create() {
		StoreProduct sp = em.find(StoreProduct.class, 3);
		OrderProduct op=new OrderProduct();
		Order order = em.find(Order.class, 2);
		op.setOrder(order);
		op.setOrderquantity(3);
		op.setStoreProduct(sp);
		op.setPrice(sp.getProduct().getPrice());
		op.setValid(true);
		em.persist(op);
	}
}
