import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.hibernate.pojo.Product;
import com.hibernate.pojo.Role;
import com.hibernate.pojo.Store;
import com.hibernate.pojo.StoreProduct;
import com.hibernate.pojo.StoreProductId;
import com.hibernate.util.HibernateUtil;
import com.hibernate.pojo.User;

public class TestMain {
	private static EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
	private static EntityTransaction tx = em.getTransaction();

	public static void main(String[] args) {
		tx.begin();
		
		TypedQuery<User> userQuery = em
				.createQuery("Select s from User s  ", User.class);
		
		TypedQuery<Store> storeQuery = em
				.createQuery("Select s from Store s where s.id=:id ", Store.class);
		storeQuery.setParameter("id", 2);
	List<Store> store = storeQuery.getResultList();
		store.forEach(sp -> {
			System.out.println(sp);
			System.out.println(sp.getEmployee());
		});
		tx.commit();
		em.close();
	}

	public static void create() {

		User u1 = new User("testing","testing","testing","testing","testing","testing","testing");
		Role role = em.find(Role.class, 1);
		Store s = em.find(Store.class, 1);
		u1.setRole(role);
		u1.setStore(s);
		em.persist(u1);

	}

	public static void delete() {
		Store s = em.find(Store.class, 44);
		em.remove(s);
	}

	public static void test() {
		// Store store = new Store("Store1","tr","+355");
		Product product = new Product("patate", 150);
		// em.persist(product);
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setProduct(em.find(Product.class, 36));
		storeProduct.setStore(em.find(Store.class, 44));
		storeProduct.setQuantity(40);
		em.find(Store.class, 44).getStoreProduct().add(storeProduct);
		em.persist(em.find(Store.class, 44));

	}

	public static void deletesp() {
		em.find(Store.class, 37);
		em.find(Product.class, 36);
		StoreProductId pk = new StoreProductId();
		pk.setProduct(em.find(Product.class, 36));
		pk.setStore(em.find(Store.class, 37));
		StoreProduct sp = em.find(StoreProduct.class, pk);
		em.remove(sp);
	}

}
