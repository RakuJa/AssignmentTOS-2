package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {
    
    
 private MenuItem test;
    
    @Before
    public void BeforeClass() {
        test = new MenuItem(ItemType.Gelati,"ciao",20);
    }
    
    @Test
    public void testItemType() {
        assertEquals(ItemType.Gelati,test.getItemType());
    }
    
    @Test
    
    public void testName() {
        assertEquals("ciao",test.getName());
    }
    
    @Test
    
    public void testPrice() {
        assertEquals(20,test.getPrice(),0);
    }

}
