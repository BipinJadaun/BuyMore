package com.buymore.discount;

import com.buymore.guice.DiscountProvider;
import com.google.inject.ImplementedBy;
import com.google.inject.ProvidedBy;

//@ImplementedBy(NoDiscount.class)
//@ProvidedBy(DiscountProvider.class)
public interface IDiscount {
	
	double getDiscount();

}
