package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalTime;
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
        TakeAwayBillImpl.lotteryCounter = 10;
    }
    
    @Test
    public void testPieno() {
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",10));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",18));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",5));
        
        
        try {
            assertEquals(33,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testVuoto() {
        List<MenuItem> emptyList = new ArrayList<MenuItem>();
        try {
            assertEquals(0,test.getOrderPrice(emptyList, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(17.8,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(19.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(18.8,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(85.635,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(97.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(97.3,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
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
            assertEquals(87.57,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
        
    }
    
    
    @Test(expected = RestaurantBillException.class)
    public void testException() throws RestaurantBillException{
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Budini,"Ciccio",20));
        lista.add(new MenuItem(ItemType.Budini,"Stefa",38));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",5));
        lista.add(new MenuItem(ItemType.Budini,"Sasa",22));
        lista.add(new MenuItem(ItemType.Budini,"Mesa",4.3));
        lista.add(new MenuItem(ItemType.Budini,"Fesa",7));
        lista.add(new MenuItem(ItemType.Budini,"Fest",1));
        lista.add(new MenuItem(ItemType.Budini,"1",20));
        lista.add(new MenuItem(ItemType.Budini,"2",38));
        lista.add(new MenuItem(ItemType.Budini,"3",5));
        lista.add(new MenuItem(ItemType.Budini,"4",22));
        lista.add(new MenuItem(ItemType.Budini,"5",4.3));
        lista.add(new MenuItem(ItemType.Budini,"6",7));
        lista.add(new MenuItem(ItemType.Budini,"7",1));
        lista.add(new MenuItem(ItemType.Budini,"8",20));
        lista.add(new MenuItem(ItemType.Budini,"9",38));
        lista.add(new MenuItem(ItemType.Budini,"232",5));
        lista.add(new MenuItem(ItemType.Budini,"Sas132a",22));
        lista.add(new MenuItem(ItemType.Budini,"234",4.3));
        lista.add(new MenuItem(ItemType.Budini,"5",7));
        lista.add(new MenuItem(ItemType.Budini,"Fe3456st",1));
        lista.add(new MenuItem(ItemType.Budini,"34Stefa",38));
        lista.add(new MenuItem(ItemType.Budini,"Sa3423sso",5));
        lista.add(new MenuItem(ItemType.Budini,"S3232asa",22));
        lista.add(new MenuItem(ItemType.Budini,"Me4sa",4.3));
        lista.add(new MenuItem(ItemType.Budini,"23",7));
        lista.add(new MenuItem(ItemType.Budini,"F434est",1));
        lista.add(new MenuItem(ItemType.Budini,"Cic344cio",20));
        lista.add(new MenuItem(ItemType.Budini,"St3423efa",38));
        lista.add(new MenuItem(ItemType.Budini,"St3423efa",38));
        lista.add(new MenuItem(ItemType.Budini,"St3423efa",38));

        test.getOrderPrice(lista,new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)); 
        
    }
    
    @Test
    
    public void testPrimaCommissione() {
        
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",2));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",2));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",2));
        
        
        try {
            assertEquals(6.5,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }
        
    }
    
   @Test
    
    public void testSecCommissione() {
        
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati,"Ciccio",3));
        lista.add(new MenuItem(ItemType.Bevande,"Stefa",3));
        lista.add(new MenuItem(ItemType.Budini,"Sasso",3));
        lista.add(new MenuItem(ItemType.Budini,"Sasse",1));     
        try {
            assertEquals(10,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
        } catch (RestaurantBillException e) {
            fail("Failed testPieno");
            e.printStackTrace();
        }     
    }
   
   
   @Test 
   public void testThirdCommissione() {
       
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stwwefa",5));

       try {
           assertEquals(10,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
       } catch (RestaurantBillException e) {
           fail("Failed testPieno");
           e.printStackTrace();
       }
       
   }
   
   @Test
   public void testQuarCommissione() {
       
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stwwefa",6));

       try {
           assertEquals(10.5,test.getOrderPrice(lista, new User("forse","si","no",LocalDate.of(1999,10,10)),LocalTime.of(20,0,0)),0);
       } catch (RestaurantBillException e) {
           fail("Failed testPieno");
           e.printStackTrace();
       }
       
   }
   
   
   
   @Test 
   public void testFirstRandomUnder() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Budini,"Stwwefa",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(18,0,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }   
       assertEquals(900,x,0);    
   }
   
   
   @Test 
   public void testSecondRandomUnder() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Budini,"Stwwefa",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(17,59,59));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }
       
       assertEquals(1000,x,0);    
   }
   
   
   @Test 
   public void testTerRandomUnder() {

       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Budini,"Stwwefa",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(19,0,1));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }
       
       assertEquals(1000,x,0);    
   }
   
   
   @Test 
   public void testQuarRandomUnder() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Budini,"Stwwefa",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(19,0,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }   
       assertEquals(900,x,0);    
   }
   
   @Test
   public void testRandomOver() {
       
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",1));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",1));
       lista.add(new MenuItem(ItemType.Gelati,"Sasse",1));
       lista.add(new MenuItem(ItemType.Gelati,"we",1));
       lista.add(new MenuItem(ItemType.Budini,"Stwwefa",5));
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.of(1999,10,10)),LocalTime.of(18,3,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }   
       assertEquals(1000,x,0);    
       
       
   }
   
   
   @Test
   public void testSixPlusRandom() {
       
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",3));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",3));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",3));
       lista.add(new MenuItem(ItemType.Gelati,"Sasa",3));
       lista.add(new MenuItem(ItemType.Gelati,"Mesa",4));
       lista.add(new MenuItem(ItemType.Gelati,"Fesa",3));
       
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(18,3,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }
       assertEquals(1575,x,0);  
   }
   
   @Test
   public void testCommissionePlusRandom() {
       
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",2));
       lista.add(new MenuItem(ItemType.Bevande,"Stefa",2));
       lista.add(new MenuItem(ItemType.Budini,"Sasso",2));
       
       
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(18,3,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }
       
       assertEquals(585,x,0);
       
   }
   
   @Test
   public void testSconto10PlusRandom() {
       List<MenuItem> lista = new ArrayList<MenuItem>();
       lista.add(new MenuItem(ItemType.Gelati,"Ciccio",20));
       lista.add(new MenuItem(ItemType.Gelati,"Stefa",38));
       lista.add(new MenuItem(ItemType.Gelati,"Sasso",5));
       lista.add(new MenuItem(ItemType.Gelati,"Sasa",22));
       lista.add(new MenuItem(ItemType.Gelati,"Mesa",4));
       lista.add(new MenuItem(ItemType.Gelati,"Fesa",7));
       lista.add(new MenuItem(ItemType.Budini,"Fest",1));
       
       double x = 0;
       for (int i = 0;i<100;++i) {          
           try {
            x+=test.getOrderPrice(lista, new User("Forse","Si","No",LocalDate.now()),LocalTime.of(18,3,0));
        } catch (RestaurantBillException e) {
            e.printStackTrace();
        }
           
       }
       
       assertEquals(7695,x,0);
       
   }
   
   
    
    
    
    
    
    
}