package com.buymore.guice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import com.buymore.discount.DiscountOptions;
import com.buymore.discount.IDiscount;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DiscountProvider implements Provider<IDiscount> {
	
	Map<DiscountOptions, IDiscount> mapBinder;
	
	@Inject
	public DiscountProvider(Map<DiscountOptions, IDiscount> mapBinder) {
		this.mapBinder = mapBinder;
	}

	private final LocalDate currentDate = LocalDate.now();
	private final LocalTime currentTime = LocalTime.now();
	
	public IDiscount get() {
		if(isFestival()) {
			return mapBinder.get(DiscountOptions.FESTIVAL);
		}
		else if(isWeekend()) {
			return mapBinder.get(DiscountOptions.WEEKEND);
		}
			
		else if(isHappyHours()) {
			return mapBinder.get(DiscountOptions.HAPPY_HOURS);
		}

			return mapBinder.get(DiscountOptions.NONE);
	}
	
	private boolean isFestival() {
		LocalDate newYear = LocalDate.of(2018, 01, 01);
		LocalDate indepenceDay = LocalDate.of(2018, 8, 15);

		return currentDate.equals(newYear) || currentDate.equals(indepenceDay);
	}
	
	private boolean isWeekend() {
		DayOfWeek today = currentDate.getDayOfWeek();		
		return today.equals(DayOfWeek.SATURDAY) || today.equals(DayOfWeek.SUNDAY);
	}
	
	private boolean isHappyHours() {
		int currentHour = currentTime.getHour();
		int happyHoursStart = 15;
		int happyHoursEnd = 20;
		
		return currentHour >= happyHoursStart && currentHour <= happyHoursEnd;
	}

}
