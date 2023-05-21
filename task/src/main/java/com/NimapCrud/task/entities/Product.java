package com.NimapCrud.task.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Product {

	@Id
	private	int pid;
		private	String p_name;
		private	int p_price;
		private String p_discount;
		
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getP_name() {
			return p_name;
		}
		public void setP_name(String p_name) {
			this.p_name = p_name;
		}
		public int getP_price() {
			return p_price;
		}
		public void setP_price(int p_price) {
			this.p_price = p_price;
		}
		public String getP_discount() {
			return p_discount;
		}
		public void setP_discount(String p_discount) {
			this.p_discount = p_discount;
		}
		public Product(int pid, String p_name, int p_price, String p_discount) {
			super();
			this.pid = pid;
			this.p_name = p_name;
			this.p_price = p_price;
			this.p_discount = p_discount;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Product [pid=" + pid + ", p_name=" + p_name + ", p_price=" + p_price + ", p_discount=" + p_discount
					+ "]";
		}
		
		
		
		
		
		
}
