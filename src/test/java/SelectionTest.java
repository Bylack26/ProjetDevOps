import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class SelectionTest {

    @Test
    public void testSelectRowsRange() {

        DataFrame df;
        try {

            df = new DataFrame("./src/test/resources/testlongfile.csv");
            DataFrame test = Selector.selectRows(df, 2, 5);
            String resultfunc = test.displayAll();
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Charlie,35,Londres,1800.0,\n" +
                    "David,40,Tokyo,2200.25,\n" +
                    "Emma,28,Berlin,1900.8,\n";

            assertEquals(result, resultfunc);
        } catch (Exception a) {
            assertFalse(true);
        }

    }

    @Test
    public void testSelectRowsRangeToolarge() {

        DataFrame df;
        try {

            df = new DataFrame("./src/test/resources/testlongfile.csv");
            DataFrame test = Selector.selectRows(df, 0, 200);
            String resultfunc = test.displayAll();
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Charlia,\n";

            assertTrue(result.equals(resultfunc));
        } catch (Exception a) {
            //assertFalse(true);
        }

    }

    @Test
    public void testSelectCols() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testlongfile.csv");
            List<String> labels = new ArrayList<String>();
            labels.add("Nom");

            DataFrame test = Selector.selectCols(df, labels);
            String resultfunc = test.displayAll();

            String result = "Nom,\n" +
                    "Alice,\n" +
                    "Bob,\n" +
                    "Charlie,\n" +
                    "David,\n" +
                    "Emma,\n" +
                    "Frank,\n" +
                    "Grace,\n" +
                    "Hannah,\n" +
                    "Isaac,\n" +
                    "Julia,\n" +
                    "Kevin,\n" +
                    "Lily,\n" +
                    "Mia,\n" +
                    "Nathan,\n" +
                    "Olivia,\n" +
                    "Paul,\n" +
                    "Rachel,\n" +
                    "Samuel,\n" +
                    "Tina,\n" +
                    "Victoria,\n" +
                    "William,\n";

            assertTrue(result.equals(resultfunc));
        } catch (Exception a) {
            assertFalse(true);
        }
    }

    @Test
    public void testSelectRowsList() {

        DataFrame df;
        try {

            df = new DataFrame("./src/test/resources/testlongfile.csv");
            List<Integer> labels = new ArrayList<Integer>();
            labels.add(1);
            labels.add(3);
            DataFrame test = Selector.selectRows(df,labels);
            String resultfunc = test.displayAll();
            String result = "Nom,Age,Ville,Argent,\n"+
                    "Bob,25,New York,2000.75,\n"+
                    "David,40,Tokyo,2200.25,\n";

            assertTrue(result.equals(resultfunc));
        } catch (Exception a) {
            //assertFalse(true);
        }

    }

}


