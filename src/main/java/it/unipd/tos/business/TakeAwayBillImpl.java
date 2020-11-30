////////////////////////////////////////////////////////////////////
// [DANIELE] [GIACHETTO] [1201145]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImpl implements TakeAwayBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
            throws RestaurantBillException {
        // TODO Auto-generated method stub
        int sum = 0;
        for (MenuItem menuItem : itemsOrdered) {
            sum += menuItem.getPrice();
        }
        
        return sum;
    }

}
