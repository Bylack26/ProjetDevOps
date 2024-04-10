

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ColumnTest {

    @Test
    public void constructorTest() {
        Types typeInt = Types.INT;
        Column<Integer> intColumn = new Column<Integer>(typeInt);
        assertTrue(intColumn != null);
    }

    public void constructorTest2() {
        Types typeInt = Types.FLOAT;
        Column<Integer> intColumn = new Column<Integer>(typeInt);
        assertTrue(intColumn != null);
    }
}

