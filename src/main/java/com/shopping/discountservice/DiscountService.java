package com.shopping.discountservice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.shopping.discount.IDiscount;

public class DiscountService {
	private final IDiscount discount;
	//private final Provider<IDiscount> discount;

	@Inject
	public DiscountService(IDiscount discount) {
		this.discount = discount;
	}
	
	/*@Inject
	public DiscountService(Provider<IDiscount> discount) {
		this.discount = discount;
	}*/
	
	public double checkout(double shoppingCartTotal){
		System.out.println("Discount Type = "+ discount.toString());
		double totalDiscount = discount.getDiscount();
		//System.out.println("Discount Type = "+ discount.get().toString());
		//double totalDiscount = discount.get().getDiscount();
		
		double totalAmountAfterDiscount = shoppingCartTotal - (shoppingCartTotal * totalDiscount);
		
		System.out.println("shopping cart total = "+ shoppingCartTotal);
		System.out.println("shopping discount = "+ totalDiscount*100 +"%");
		System.out.println("Payable amount after discount = "+ totalAmountAfterDiscount);		
		
		return totalAmountAfterDiscount;
		
	}

}
