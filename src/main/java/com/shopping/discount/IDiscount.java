package com.shopping.discount;

import com.google.inject.ImplementedBy;
import com.google.inject.ProvidedBy;
import com.shopping.guice.DiscountProvider;

//@ImplementedBy(NoDiscount.class)
//@ProvidedBy(DiscountProvider.class)
public interface IDiscount {
	
	double getDiscount();

}
