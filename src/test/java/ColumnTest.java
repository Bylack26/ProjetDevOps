

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ColumnTest {

    @Test /* test le constructeur avec un type int */
    public void constructorInt() { 
        Types typeInt = Types.INT;
        Column<Integer> Column = new Column<Integer>(typeInt);
        Types colType = Column.getType();
        assertTrue(Types.INT == colType);
    }

    @Test /* test le constructeur avec un type float */
    public void constructorFloat() {
        Types typeFloat = Types.FLOAT;
        Column<Integer> Column = new Column<Integer>(typeFloat);
        Types colType = Column.getType();
        assertTrue(Types.FLOAT == colType);
    }

    @Test /* test le constructeur avec un type string */
    public void constructorTest() {
        Types typeInt = Types.STRING;
        Column<String> Column = new Column<String>(typeInt);
        Types colType = Column.getType();
        assertTrue(Types.STRING == colType);
    }
}

