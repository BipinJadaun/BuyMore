package com.shopping;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.shopping.discountservice.DiscountService;
import com.shopping.guice.DiscountModule;

/**
 * Hello world!
 *
 */
public class AppMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello!, Welcome to BuyMore" );
        Injector injector = Guice.createInjector(new DiscountModule());
        DiscountService service = injector.getInstance(DiscountService.class);
        
        service.checkout(100);
    }
}
