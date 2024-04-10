

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ColumnTest {

    @Test
    public void constructorInt() {
        Types typeInt = Types.INT;
        Column<Integer> Column = new Column<Integer>(typeInt);
        Types colType = Column.getType();
        assertTrue(Types.INT == colType);
    }

    public void constructorFloat() {
        Types typeFloat = Types.FLOAT;
        Column<Integer> Column = new Column<Integer>(typeFloat);
        Types colType = Column.getType();
        assertTrue(Types.FLOAT == colType);
    }
    public void constructorTest() {
        Types typeInt = Types.FLOAT;
        Column<Integer> Column = new Column<Integer>(typeInt);
        Types colType = Column.getType();
        assertTrue(Types.STRING == colType);
    }
}

