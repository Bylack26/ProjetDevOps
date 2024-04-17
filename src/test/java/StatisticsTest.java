import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    @Test
    public void Stats_1() {
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        ColumnID.add(3);
        ColumnID.add(5);
        ColumnID.add(10);

        float resultat = 6.f;
        try {
            float res = Statistics.mean(ColumnID);
            assertTrue(res == resultat);
        } catch (TypeMismatchException e) {
            e.printStackTrace();
        }
    }

}
