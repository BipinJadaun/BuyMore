package com.shopping.guice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.multibindings.MapBinder;
import com.shopping.discount.DiscountOptions;
import com.shopping.discount.FestivalDiscount;
import com.shopping.discount.HappyHoursDiscount;
import com.shopping.discount.IDiscount;
import com.shopping.discount.NoDiscount;
import com.shopping.discount.WeekendDiscount;

public class DiscountProvider implements Provider<IDiscount> {
	
	/*Map<DiscountOptions, IDiscount> mapBinder;
	
	@Inject
	public DiscountProvider(Map<DiscountOptions, IDiscount> mapBinder) {
		this.mapBinder = mapBinder;
	}*/

	private final LocalDate currentDate = LocalDate.now();
	private final LocalTime currentTime = LocalTime.now();
	
	public IDiscount get() {
		if(isFestival()) {
			return new FestivalDiscount();
			//return mapBinder.get(DiscountOptions.FESTIVAL);
		}
		else if(isWeekend()) {
			return new WeekendDiscount();
			//return mapBinder.get(DiscountOptions.WEEKEND);
		}
			
		else if(isHappyHours()) {
			return new HappyHoursDiscount();
			//return mapBinder.get(DiscountOptions.HAPPY_HOURS);
		}

			return new NoDiscount();
			//return mapBinder.get(DiscountOptions.NONE);
	}
	
	private boolean isFestival() {
		LocalDate newYear = LocalDate.of(2018, 01, 01);
		LocalDate indepenceDay = LocalDate.of(2018, 8, 15);

		return currentDate.equals(newYear) || currentDate.equals(indepenceDay);
	}
	
	private boolean isWeekend() {
		DayOfWeek today = currentDate.getDayOfWeek();
		DayOfWeek sat = DayOfWeek.SATURDAY;
		DayOfWeek sun = DayOfWeek.SUNDAY;
		
		return today.equals(sat) || today.equals(sun);
	}
	
	private boolean isHappyHours() {
		int currentHour = currentTime.getHour();
		int happyHoursStart = 15;
		int happyHoursEnd = 20;
		
		return currentHour >= happyHoursStart && currentHour <= happyHoursEnd;
	}

}
