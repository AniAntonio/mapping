package com.hibernate.pojo;

import java.util.Objects;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "storeproducts")
@AssociationOverrides({
    @AssociationOverride(name = "primarykey.store",
        joinColumns = @JoinColumn(name = "idstore")),
    @AssociationOverride(name = "primarykey.product",
        joinColumns = @JoinColumn(name = "idproduct")) })
public class StoreProduct {
	
	private StoreProductId primarykey = new StoreProductId();

	private int quantity;
	
	
	@EmbeddedId
	public StoreProductId getPrimarykey() {
		return primarykey;
	}
	public void setPrimarykey(StoreProductId primarykey) {
		this.primarykey = primarykey;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	 @Transient
	 public Store getStore() {
		 return getPrimarykey().getStore();
	 }
	 public void setStore(Store store) {
		  getPrimarykey().setStore(store);
	 }
	 
	 @Transient
	 public Product getProduct() {
		 return getPrimarykey().getProduct();
	 }
	 public void setProduct(Product product) {
		  getPrimarykey().setProduct(product);
	 }

	 
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			StoreProduct that = (StoreProduct) o;

			if (getPrimarykey() != null ? !getPrimarykey().equals(that.getPrimarykey())
					: that.getPrimarykey() != null)
				return false;

			return true;
		}

		public int hashCode() {
			return (getPrimarykey() != null ?getPrimarykey().hashCode() : 0);
		}
	
	

}
