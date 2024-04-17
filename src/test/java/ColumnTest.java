import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

//-------------------------------------- TESTS GET_TYPE --------------------------------------

    @Test
    public void testGetType_Int(){
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        Types type = ColumnID.getType();
        assertTrue(type.equals(typeInt));
    }

    @Test
    public void testGetType_String(){
        Types typeInt = Types.STRING;
        Column<String> ColumnID = new Column<String>(typeInt);
        Types type = ColumnID.getType();
        assertTrue(type.equals(typeInt));
    }

    @Test
    public void testGetType_Float(){
        Types typeInt = Types.FLOAT;
        Column<Float> ColumnID = new Column<Float>(typeInt);
        Types type = ColumnID.getType();
        assertTrue(type.equals(typeInt));
    }

//-------------------------------------- TESTS ADD -------------------------------------------

    @Test
    public void testAdd_base(){
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        ColumnID.add(2);
        int res = ColumnID.getValue(0);
        assertTrue(res == 2);
    }

    @Test
    public void testAdd_Int(){
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        ColumnID.add(2);
        ColumnID.add(5);
        ColumnID.add(10);
        int res_1 = ColumnID.getValue(0);
        int res_2 = ColumnID.getValue(1);
        int res_3 = ColumnID.getValue(2);
        assertTrue(res_1 == 2);
        assertTrue(res_2 == 5);
        assertTrue(res_3 == 10);
    }

    @Test
    public void testAdd_String(){
        Types typeString = Types.STRING;
        Column<String> ColumnID = new Column<String>(typeString);
        ColumnID.add("a");
        ColumnID.add("b");
        ColumnID.add("c");
        String res_1 = ColumnID.getValue(0);
        String res_2 = ColumnID.getValue(1);
        String res_3 = ColumnID.getValue(2);
        assertTrue(res_1.equals("a"));
        assertTrue(res_2.equals("b"));
        assertTrue(res_3.equals("c"));
    }

    @Test
    public void testAdd_Float(){
        Types typeFloat = Types.FLOAT;
        Column<Float> ColumnID = new Column<Float>(typeFloat);
        ColumnID.add(12.0f);
        ColumnID.add(44.4f);
        ColumnID.add(18.99999f);
        ColumnID.add(18f);
        Float res_1 = ColumnID.getValue(0);
        Float res_2 = ColumnID.getValue(1);
        Float res_3 = ColumnID.getValue(2);
        Float res_4 = ColumnID.getValue(3);
        assertTrue(res_1 == 12.0f);
        assertTrue(res_2 == 44.4f);
        assertTrue(res_3 == 18.99999f);
        assertTrue(res_4 == 18f);
    }

//-------------------------------------- TESTS GET VALUE-------------------------------------------
    @Test
    public void testGetValue_String(){
        Types typeString = Types.STRING;
        Column<String> ColumnID = new Column<String>(typeString);
        ColumnID.add("a");
        ColumnID.add("b");
        ColumnID.add("c");
        String res_1 = ColumnID.getValue(0);
        String res_2 = ColumnID.getValue(1);
        String res_3 = ColumnID.getValue(2);
        assertTrue(res_1.equals("a"));
        assertTrue(res_2.equals("b"));
        assertTrue(res_3.equals("c"));
    }
    @Test
    public void testGetValue_Int(){
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        ColumnID.add(-15);
        ColumnID.add(0);
        ColumnID.add(121654864);
        int res_1 = ColumnID.getValue(0);
        int res_2 = ColumnID.getValue(1);
        int res_3 = ColumnID.getValue(2);
        assertTrue(res_1 == -15);
        assertTrue(res_2 == 0);
        assertTrue(res_3 == 121654864);
    }
    @Test
    public void testGetValue_Float(){
        Types typeFloat = Types.FLOAT;
        Column<Float> ColumnID = new Column<Float>(typeFloat);
        ColumnID.add(12.0f);
        ColumnID.add(44.4f);
        ColumnID.add(18.99999f);
        ColumnID.add(18f);
        Float res_1 = ColumnID.getValue(0);
        Float res_2 = ColumnID.getValue(1);
        Float res_3 = ColumnID.getValue(2);
        Float res_4 = ColumnID.getValue(3);
        assertTrue(res_1 == 12.0f);
        assertTrue(res_2 == 44.4f);
        assertTrue(res_3 == 18.99999f);
        assertTrue(res_4 == 18f);
    }
//----------------------------------TEST GET SIZE --------------------------------------------------
    @Test
    public void testLength_Float(){
        Types typeFloat = Types.FLOAT;
        Column<Float> ColumnID = new Column<Float>(typeFloat);
        ColumnID.add(12.0f);
        ColumnID.add(44.4f);
        ColumnID.add(18.99999f);
        ColumnID.add(18f);
        int size = ColumnID.length();
        assertTrue(size  == 4);
    }

    @Test
    public void testLength_Int(){
        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);
        ColumnID.add(-15);
        ColumnID.add(0);
        ColumnID.add(121654864);
        int size = ColumnID.length();
        assertTrue(size  == 3);
    }

    @Test
    public void testLength_String(){
        Types typeString = Types.STRING;
        Column<String> ColumnID = new Column<String>(typeString);
        ColumnID.add("a");
        ColumnID.add("b");
        ColumnID.add("c");
        ColumnID.add("d");
        ColumnID.add("e");
        int size = ColumnID.length();
        assertTrue(size  == 5);
    }
}

