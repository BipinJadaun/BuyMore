package com.buymore.main;

import com.buymore.guice.DiscountModule;
import com.buymore.service.CheckoutService;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello!, Welcome to BuyMore" );
        Injector injector = Guice.createInjector(new DiscountModule());
        CheckoutService service = injector.getInstance(CheckoutService.class);
        
        service.checkout(100);
    }
}
