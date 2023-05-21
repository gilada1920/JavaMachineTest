package com.NimapCrud.task.entities;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	private int cid;
	     private String cname;
	    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	 	@JoinColumn(name="cid")
	     List<Product> product;
	     
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public List<Product> getProduct() {
			return product;
		}
		public void setProduct(List<Product> product) {
			this.product = product;
		}
		@Override
		public String toString() {
			return "Category [cid=" + cid + ", cname=" + cname + ", product=" + product + "]";
		}
		public Category(int cid, String cname, List<Product> product) {
			super();
			this.cid = cid;
			this.cname = cname;
			this.product = product;
		}
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
	     
	     

	
}
