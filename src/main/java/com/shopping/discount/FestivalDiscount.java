package com.shopping.discount;

public class FestivalDiscount implements IDiscount {

	public double getDiscount() {
		return 0.35;
	}

	@Override
	public String toString() {
		return "Festival Discount";
	}
	
	

}
