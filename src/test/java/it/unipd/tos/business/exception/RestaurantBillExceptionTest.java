package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestaurantBillExceptionTest {

    @Test
    public void restaurantBillExceptionTest() {
        
        assertEquals("K",new RestaurantBillException("K").getMessage());
        
    }
    
}
