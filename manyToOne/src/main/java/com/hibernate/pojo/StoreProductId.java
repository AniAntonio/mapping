package com.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Embeddable
public class StoreProductId implements Serializable {

	private Product product;
	private Store store;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
		
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreProductId that = (StoreProductId) o;

        if (store != null ? !store.equals(that.store) : that.store != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (store != null ? store.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
	
	



}
