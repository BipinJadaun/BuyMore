package com.shopping.discount;

public class NoDiscount implements IDiscount {

	public double getDiscount() {
		return 0;
	}

	@Override
	public String toString() {
		return "No Discount";
	}

}
