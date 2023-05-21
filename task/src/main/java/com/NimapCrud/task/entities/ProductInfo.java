package com.NimapCrud.task.entities;

public class ProductInfo {

	
	int pid;
	String p_pname;
	int p_price;
	String p_discount;
	int cid;
	String cname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getP_pname() {
		return p_pname;
	}
	public void setP_pname(String p_pname) {
		this.p_pname = p_pname;
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
	public ProductInfo(int pid, String p_pname, int p_price, String p_discount, int cid, String cname) {
		super();
		this.pid = pid;
		this.p_pname = p_pname;
		this.p_price = p_price;
		this.p_discount = p_discount;
		this.cid = cid;
		this.cname = cname;
	}
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductInfo [pid=" + pid + ", p_pname=" + p_pname + ", p_price=" + p_price + ", p_discount="
				+ p_discount + ", cid=" + cid + ", cname=" + cname + "]";
	}

	
	
	
}
