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
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",10));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",18));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",5));
        
        
        try {
            assertEquals(33,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
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
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",3));
        
        try {
            assertEquals(17.8,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testFivePlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Budini,"Fesa",3));
        
        try {
            assertEquals(19.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testSixPlusOne() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",3));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",3));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",3));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",3));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        
        try {
            assertEquals(18.8,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    
    public void testPrimoSconto10() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Gelati,"Stefa",38));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
        lista.add(new MenuItem(ItemType.Gelati,"Sasa",22));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",7));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        
        try {
            assertEquals(85.635,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
    }
    @Test
    
    public void testSecSconto10() {
        
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Bevande,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",38));
        lista.add(new MenuItem(ItemType.Bevande,"Sasso",5));
        lista.add(new MenuItem(ItemType.Bevande,"Sasa",22));
        lista.add(new MenuItem(ItemType.Bevande,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Bevande,"Fesa",7));
        lista.add(new MenuItem(ItemType.Bevande,"Fest",1));
        
        try {
            assertEquals(97.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
        
    }
    
    @Test
    public void testTerSconto10() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Bevande,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",38));
        lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
        lista.add(new MenuItem(ItemType.Bevande,"Sasa",22));
        lista.add(new MenuItem(ItemType.Gelati,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Gelati,"Fesa",7));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        
        try {
            assertEquals(97.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
    }
    @Test
    public void testQuarSconto10() {
        
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Budini,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Budini,"Stefa",38));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",5));
        lista.add(new MenuItem(ItemType.Budini,"Sasa",22));
        lista.add(new MenuItem(ItemType.Budini,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Budini,"Fesa",7));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        
        try {
            assertEquals(87.57,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.now())),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    
}