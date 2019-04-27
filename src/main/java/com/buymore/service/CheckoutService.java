package com.buymore.service;

import com.buymore.discount.IDiscount;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CheckoutService {
	
	/*private final IDiscount discount;
	@Inject
	public DiscountService(IDiscount discount) {
		this.discount = discount;
	}*/
	
	private final Provider<IDiscount> discountProvider;	
	@Inject
	public CheckoutService(Provider<IDiscount> discountProvider) {
		this.discountProvider = discountProvider;
	}
	
	public double checkout(double shoppingCartTotal){
		/*System.out.println("Discount Type = "+ discount.toString());
		double totalDiscount = discount.getDiscount();*/
		
		System.out.println("Discount Type = "+ discountProvider.get().toString());
		double totalDiscount = discountProvider.get().getDiscount();
		
		double totalAmountAfterDiscount = shoppingCartTotal - (shoppingCartTotal * totalDiscount);
		
		System.out.println("shopping cart total = "+ shoppingCartTotal);
		System.out.println("shopping discount = "+ totalDiscount*100 +"%");
		System.out.println("Payable amount after discount = "+ totalAmountAfterDiscount);		
		
		return totalAmountAfterDiscount;
		
	}

}
