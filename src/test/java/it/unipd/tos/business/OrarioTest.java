////////////////////////////////////////////////////////////////////
// [LORENZO] [MATTERAZZO] [1195360]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class OrarioTest {
    private static Orario Orario;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Orario=new Orario(18,0,0);
    }

    @Test
    public void testOre() {
        assertEquals(18, Orario.getOre());
    }
    @Test
    public void testMinuti() {
        assertEquals(0, Orario.getMinuti());
    }
    @Test
    public void testSecondi() {
        assertEquals(0, Orario.getSecondi());
    }

}
