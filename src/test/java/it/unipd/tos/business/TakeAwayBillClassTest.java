////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;

import org.junit.Before;
import org.junit.Test;
public class TakeAwayBillClassTest {
    private static TakeAwayBillClass takeAwayBillClass=new TakeAwayBillClass();
    private static double price;
    private static List<MenuItem> itemsOrdered;
    

    @Before
    public void setUp() throws Exception {
        price=0.0D;
        itemsOrdered=new ArrayList<MenuItem>();
    }
    @Test
    public void testTotal() throws TakeAwayBillException {
        price=0.0D;
        itemsOrdered=new ArrayList<MenuItem>();
        for(int i=0;i<4;i++)
            itemsOrdered.add(new MenuItem(ItemType.Bevande,"Birra",2.5D));
            assertEquals(10.0D, takeAwayBillClass.getOrderPrice(itemsOrdered,new User(2, 19)),0D);

    }
    @Test(expected = TakeAwayBillException.class) 
    public void testCalcoloDelTotaleConListaNonInizializzata() throws TakeAwayBillException {
        price=takeAwayBillClass.getOrderPrice(null,new User(1,18)); 
    }

    @Test(expected = TakeAwayBillException.class)    
    public void testListaConValoriNulli() throws TakeAwayBillException{
        itemsOrdered.add(new MenuItem(ItemType.Gelati, "pistacchio", 2.5D));
        itemsOrdered.add(null);
        price=takeAwayBillClass.getOrderPrice(itemsOrdered,new User(1, 19));
    }
    @Test
    public void testScontoGelatoMenoCaro() throws TakeAwayBillException {
        for(int i=0;i<7;i++)
            itemsOrdered.add(new MenuItem(ItemType.Gelati,"pippo",3.0D));
        itemsOrdered.add(new MenuItem(ItemType.Gelati, "pluto", 2.0D));
        assertEquals(22.0D, takeAwayBillClass.getOrderPrice(itemsOrdered, new User(1,19)),0D);
    }
    
    @Test
    public void testScontoGelatiBudini50Euro() throws TakeAwayBillException {
        for(int i=0;i<10;i++)
        {
            itemsOrdered.add(new MenuItem(ItemType.Budini, "puffo", 4.0D));
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "mela", 4.0D));
            itemsOrdered.add(new MenuItem(ItemType.Bevande, "acqua", 1.0D));
        }
        assertEquals(79.2D, takeAwayBillClass.getOrderPrice(itemsOrdered, new User(1, 20)),1.0D);

    }
    @Test(expected = TakeAwayBillException.class)
    public void testNumeroMassimo30Item() throws TakeAwayBillException
    {
        for(int i=0;i<40;i++)
        {
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "picchio", 2.2D));
        }
        price=takeAwayBillClass.getOrderPrice(itemsOrdered,new User(1, 30));
    }
    @Test
    public void testOrdineSuperiore10Euro() throws TakeAwayBillException {
        itemsOrdered.add(new MenuItem(ItemType.Gelati, "fragola", 2.0D));
        itemsOrdered.add(new MenuItem(ItemType.Bevande, "coca", 2.0D));
        assertEquals(4.5D,takeAwayBillClass.getOrderPrice(itemsOrdered, new User(2, 19)),0D);
    }



   
}
