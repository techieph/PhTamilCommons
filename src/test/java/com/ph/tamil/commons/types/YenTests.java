package com.ph.tamil.commons.types;

import com.ph.tamil.commons.exception.InvalidYenException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class YenTests {

    @Test
    @DisplayName("Positive yen from string")
    void yenPostivieYenFromStringTest() throws InvalidYenException {
        Yen yen = new Yen("௩௪௫");
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toInt(), 345);
    }

    @Test
    @DisplayName("Negative yen from string")
    void yenNegativeYenFromStringTest() throws InvalidYenException {
        Yen yen = new Yen("-௩௪௫");
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toInt(), -345);
    }

    @Test
    @DisplayName("Positive yen from number")
    void yenPostivieYenFromNumberTest() throws InvalidYenException {
        Yen yen = new Yen(345);
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toString(), "௩௪௫");
    }

    @Test
    @DisplayName("Negative yen from number")
    void yenNegativeYenFromNumberTest() throws InvalidYenException {
        Yen yen = new Yen(-345);
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toString(), "-௩௪௫");
    }

    @Test
    @DisplayName("Positive yen boundary from string")
    void yenPostivieYenBoundaryFromStringTest() throws InvalidYenException {
        Yen yen = new Yen("௧௨௬௭௮௯௦");
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toInt(), 1267890);
    }

    @Test
    @DisplayName("Negative yen boundary from string")
    void yenNegativeYenBoundaryFromStringTest() throws InvalidYenException {
        Yen yen = new Yen("-௧௨௬௭௮௯௦");
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertEquals(yen.toInt(), -1267890);
    }

    @Test
    @DisplayName("Positive yen boundary from number")
    void yenPostivieYenBoundaryFromNumberTest() throws InvalidYenException {
        Yen yen = new Yen(1267890);
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertTrue(yen.toString().equals("௧௨௬௭௮௯௦"));
    }

    @Test
    @DisplayName("Negative yen boundary from number")
    void yenNegativeYenBoundaryFromNumberTest() throws InvalidYenException {
        Yen yen = new Yen(-1267890);
        assertEquals(yen.toInt(), Integer.parseInt(yen.toString()));
        assertTrue(yen.toString().equals("-௧௨௬௭௮௯௦"));
    }

    @Test
    @DisplayName("Testing Sorting in Yen")
    void testSorting() throws InvalidYenException {
        Yen[] yengal = new Yen[]{new Yen(12), new Yen(-12),new Yen("௬௭"), new Yen("-௭"), new Yen("௦")};
        Arrays.sort(yengal);
        assertEquals(yengal[0].toInt(),-12 );
        assertEquals(yengal[1].toInt(),-7 );
        assertEquals(yengal[2].toInt(),0 );
        assertEquals(yengal[3].toInt(), 12);
        assertEquals(yengal[4].toInt(), 67);
    }

}
