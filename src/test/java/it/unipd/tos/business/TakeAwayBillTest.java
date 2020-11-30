package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillTest {
    
    private TakeAwayBillImpl test;
    
    @Before
    public void BeforeClass() {
        test = new TakeAwayBillImpl();
    }
    
    @Test
    public void testPieno() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",38));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",5));
        
        
        try {
            assertEquals(63,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testVuoto() {
        List<MenuItem> emptyList = new ArrayList<MenuItem>();
        try {
            assertEquals(0,test.getOrderPrice(emptyList, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testVuoto");
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSix() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",38));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",22));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",7));
        
        try {
            assertEquals(94.15,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testFivePlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",38));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",22));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Budini,"Fesa",7));
        
        try {
            assertEquals(96.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testSixPlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",38));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",22));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",7));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        
        try {
            assertEquals(95.15,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    
    
    
}