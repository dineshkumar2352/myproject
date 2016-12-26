package com.niit.model;

import java.io.Serializable;
import java.util.List;

public class cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<cartProduct> CartProduct;
	private long grandTotal;
	private int proCount;
	
	
	public List<cartProduct> getCartProduct() {
		return CartProduct;
	}
	public void setCartProduct(List<cartProduct> cartProduct) {
		CartProduct = cartProduct;
	}
	public long getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getProCount() {
		return proCount;
	}
	public void setProCount(int proCount) {
		this.proCount = proCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void calcGrandTotal()
	{
		long tot=0;
		
		for(int i=0;i<CartProduct.size();i++)
		{
			tot+=CartProduct.get(i).getTotalCost();
		}
		this.grandTotal=tot;
		
	}
	
}
