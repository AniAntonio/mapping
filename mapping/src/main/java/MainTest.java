import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Order;
import entities.OrderProduct;
import entities.Product;
import entities.Role;
import entities.State;
import entities.Store;
import entities.StoreProduct;
import entities.User;
import utility.HibernateUtil;

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
		 

		  createOrderProduct();
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
	
	
	public static void createStore() {
		Store store = new Store("Store1","Tirane","+355692884299");
		store.setValid(true);
		em.persist(store);
	}
	
	public static void createProduct() {
		Product product = new Product("Hat",600);
		product.setValid(true);
		em.persist(product);
	}
	
	public static void createStoreProduct() {
		Store store = em.find(Store.class, 7);
		Product product = em.find(Product.class, 1);
		StoreProduct storeproduct = new StoreProduct();
		storeproduct.setQuantity(200);
		storeproduct.setValid(true);
		storeproduct.setStore(store);
		storeproduct.setProduct(product);
		em.persist(storeproduct);
	}
	
	public static void createUser() {
		User user = new User("miri","123","Miri","Hoxha","tirane","miri@gmail.com","+355672001400");
		Role role = em.find(Role.class, 2);
		user.setRole(role);
		user.setValid(true);
		em.persist(user);
	}
	
	public static void createOrder() {
		Order order = new Order();
		order.setDate("05-02-2019");
		order.setOrderprice(1200);
		order.setState(em.find(State.class, 1));
		order.setStore(em.find(Store.class, 7));
		order.setValid(true);
		order.setClient(em.find(User.class, 35));
		order.setEmployee(em.find(User.class, 37));
		em.persist(order);
	}
	
	public static void createOrderProduct() {
		OrderProduct orderProduct = new OrderProduct();
		StoreProduct sp = em.find(StoreProduct.class, 2);
		orderProduct.setStoreProduct(sp);
		orderProduct.setOrder(em.find(Order.class, 3));
		orderProduct.setPrice(sp.getProduct().getPrice());
		orderProduct.setOrderquantity(2);
		orderProduct.setValid(true);
		em.persist(orderProduct);
	} 
}
