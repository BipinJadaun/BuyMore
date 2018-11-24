package com.shopping.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.shopping.discount.DiscountOptions;
import com.shopping.discount.FestivalDiscount;
import com.shopping.discount.HappyHoursDiscount;
import com.shopping.discount.IDiscount;
import com.shopping.discount.NoDiscount;
import com.shopping.discount.WeekendDiscount;

public class DiscountModule extends AbstractModule {

	public void configure() {
		
		bind(IDiscount.class).to(FestivalDiscount.class);
		
		/*bind(IDiscount.class).toProvider(DiscountProvider.class);
		
		MapBinder<DiscountOptions, IDiscount> mapBinder = MapBinder.newMapBinder(binder(), DiscountOptions.class, IDiscount.class);
		
		mapBinder.addBinding(DiscountOptions.FESTIVAL).to(FestivalDiscount.class);
		mapBinder.addBinding(DiscountOptions.HAPPY_HOURS).to(HappyHoursDiscount.class);
		mapBinder.addBinding(DiscountOptions.WEEKEND).to(WeekendDiscount.class);
		mapBinder.addBinding(DiscountOptions.NONE).to(NoDiscount.class);*/
	}

}
