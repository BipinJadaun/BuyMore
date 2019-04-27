package com.buymore.guice;

import com.buymore.discount.DiscountOptions;
import com.buymore.discount.FestivalDiscount;
import com.buymore.discount.HappyHoursDiscount;
import com.buymore.discount.IDiscount;
import com.buymore.discount.NoDiscount;
import com.buymore.discount.WeekendDiscount;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class DiscountModule extends AbstractModule {

	public void configure() {
		
		bind(IDiscount.class).toProvider(DiscountProvider.class);
		
		MapBinder<DiscountOptions, IDiscount> mapBinder = MapBinder.newMapBinder(binder(), DiscountOptions.class, IDiscount.class);
		
		mapBinder.addBinding(DiscountOptions.FESTIVAL).to(FestivalDiscount.class);
		mapBinder.addBinding(DiscountOptions.HAPPY_HOURS).to(HappyHoursDiscount.class);
		mapBinder.addBinding(DiscountOptions.WEEKEND).to(WeekendDiscount.class);
		mapBinder.addBinding(DiscountOptions.NONE).to(NoDiscount.class);
	}

}
