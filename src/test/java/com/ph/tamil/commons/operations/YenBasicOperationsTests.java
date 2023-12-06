package com.ph.tamil.commons.operations;

import com.ph.tamil.commons.exception.InvalidYenException;
import com.ph.tamil.commons.types.Yen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YenBasicOperationsTests {

    @Test
    @DisplayName("All Basic Operations Once")
    void allFlowOnce() throws InvalidYenException {
        Yen yen = new YenBasicOperations(new Yen("௧௨௩")) // 123
                .kalithal(new Yen("௪௫")) // 45
                .peruthal(new Yen(1)) // 1
                .vaguthal(new Yen("-௨")) // -2
                .end();
        assertEquals(yen.toInt(), -39);
        assertTrue(yen.toString().equals("-௩௯")); // -39
    }

}
