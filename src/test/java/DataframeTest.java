import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataframeTest {

    private List<String> name = new ArrayList<>();
    private List<Column> datas = new ArrayList<>();

    @BeforeEach
    public void init() {

        Types typeInt = Types.INT;
        Column<Integer> ColumnID = new Column<Integer>(typeInt);

        Types typeStringNom = Types.STRING;
        Column<String> ColumnNom = new Column<String>(typeStringNom);

        Types typeStringPrenom = Types.STRING;
        Column<String> ColumnPrenom = new Column<String>(typeStringPrenom);

        Types typeFloat = Types.FLOAT;
        Column<Float> ColumnNote = new Column<Float>(typeFloat);

        for (int i = 0; i < 4; i++) {
            ColumnID.add(i + 1);
        }

        ColumnPrenom.add("Alban");
        ColumnPrenom.add("Gaetan");
        ColumnPrenom.add("Fabien");
        ColumnPrenom.add("Raphael");

        ColumnNom.add("Faurie");
        ColumnNom.add("Combe");
        ColumnNom.add("Vial");
        ColumnNom.add("Balssa");

        ColumnNote.add((float) 45.2);
        ColumnNote.add((float) 48.0);
        ColumnNote.add((float) 0.1);
        ColumnNote.add((float) 1257854.987457);

        datas.add(ColumnID);
        datas.add(ColumnPrenom);
        datas.add(ColumnNom);
        datas.add(ColumnNote);

        List<String> names = new ArrayList<String>();
        names.add("ID");
        names.add("Prenom");
        names.add("Nom");
        names.add("Note");
    }

    @Test /* Test qui prend 4 colonnes non vides de meme taille et des 3 types possibles  */
    void constructorTestParCol3Types() {
        assertDoesNotThrow(() -> {
            DataFrame df = new DataFrame(name, datas);
        });
    }

    @Test /* Test qui prend 3 colonnes non vides  */
    void constructorTestColElementNull() {
        assertDoesNotThrow(() -> {
            Types typeInt = Types.INT;
            Column<Integer> ColumnID = new Column<Integer>(typeInt);

            Types typeStringNom = Types.STRING;
            Column<String> ColumnNom = new Column<String>(typeStringNom);

            Types typeStringPrenom = Types.STRING;
            Column<String> ColumnPrenom = new Column<String>(typeStringPrenom);

            Types typeFloat = Types.FLOAT;
            Column<Float> ColumnNote = new Column<Float>(typeFloat);

            for (int i = 0; i < 4; i++) {
                ColumnID.add(i + 1);
            }

            ColumnPrenom.add("Alban");
            ColumnPrenom.add("Gaetan");
            ColumnPrenom.add("Fabien");
            ColumnPrenom.add("Raphael");

            ColumnNom.add("Faurie");
            ColumnNom.add("Combe");
            ColumnNom.add(null);
            ColumnNom.add("Balssa");

            ColumnNote.add((float) 45.2);
            ColumnNote.add((float) 48.0);
            ColumnNote.add((float) 0.1);
            ColumnNote.add((float) 1257854.987457);

            datas.add(ColumnID);
            datas.add(ColumnPrenom);
            datas.add(ColumnNom);
            datas.add(ColumnNote);

            List<String> names = new ArrayList<String>();
            names.add("ID");
            names.add("Prenom");
            names.add("Nom");
            names.add("Note");

            DataFrame df = new DataFrame(name, datas);
        });
    }

    @Test
    public void testColVide() {
        assertDoesNotThrow(() -> {
            Types typeInt = Types.INT;
            Column<Integer> ColumnID = new Column<Integer>(typeInt);

            Types typeStringNom = Types.STRING;
            Column<String> ColumnNom = new Column<String>(typeStringNom);

            Types typeStringPrenom = Types.STRING;
            Column<String> ColumnPrenom = new Column<String>(typeStringPrenom);

            Types typeFloat = Types.FLOAT;
            Column<Float> ColumnNote = new Column<Float>(typeFloat);

            for (int i = 0; i < 4; i++) {
                ColumnID.add(i + 1);
            }

            ColumnNom.add("Faurie");
            ColumnNom.add("Combe");
            ColumnNom.add(null);
            ColumnNom.add("Balssa");

            ColumnNote.add((float) 45.2);
            ColumnNote.add((float) 1257854.987457);

            datas.add(ColumnID);
            datas.add(ColumnPrenom);
            datas.add(ColumnNom);
            datas.add(ColumnNote);

            List<String> names = new ArrayList<String>();
            names.add("ID");
            names.add("Prenom");
            names.add("Nom");
            names.add("Note");

            DataFrame df = new DataFrame(name, datas);

        });
    }

    @Test
    public void testnamesizePlusPetitVide() {

        assertDoesNotThrow(() -> {
            Types typeInt = Types.INT;
            Column<Integer> ColumnID = new Column<Integer>(typeInt);

            Types typeStringNom = Types.STRING;
            Column<String> ColumnNom = new Column<String>(typeStringNom);

            Types typeStringPrenom = Types.STRING;
            Column<String> ColumnPrenom = new Column<String>(typeStringPrenom);

            Types typeFloat = Types.FLOAT;
            Column<Float> ColumnNote = new Column<Float>(typeFloat);

            for (int i = 0; i < 4; i++) {
                ColumnID.add(i + 1);
            }

            ColumnPrenom.add("Alban");
            ColumnPrenom.add("Gaetan");
            ColumnPrenom.add("Fabien");
            ColumnPrenom.add("Raphael");

            ColumnNom.add("Faurie");
            ColumnNom.add("Combe");
            ColumnNom.add("Vial");
            ColumnNom.add("Balssa");

            ColumnNote.add((float) 45.2);
            ColumnNote.add((float) 48.0);
            ColumnNote.add((float) 0.1);
            ColumnNote.add((float) 1257854.987457);

            datas.add(ColumnID);
            datas.add(ColumnPrenom);
            datas.add(ColumnNom);

            List<String> names = new ArrayList<String>();
            names.add("ID");
            names.add("Prenom");
            names.add("Nom");
            names.add("Note");

            DataFrame df = new DataFrame(name, datas);
        });
    }

    @Test
    public void testfichier3types() {
        assertDoesNotThrow(() -> {
            DataFrame df = new DataFrame("./src/test/resources/test3typesDiff.csv");
        });
    }

    @Test
    public void testfichier2Types() {

        assertDoesNotThrow(() -> {
            DataFrame df = new DataFrame("./src/test/resources/test2String1Int.csv");
        });

    }

    @Test
    public void testfichierVide() {

        assertDoesNotThrow(() -> {
            DataFrame df = new DataFrame("./src/test/resources/testVide.csv");
        });

    }

    @Test
    public void testfichierNullValue() {

        assertDoesNotThrow(() -> {
            DataFrame df = new DataFrame("./src/test/resources/testnullvaleur.csv");
        });

    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(TypeMismatchException.class, () -> {
            DataFrame df = new DataFrame("./src/test/resources/testWrongType.csv");
        });

    }

    @Test
    public void testDisplay() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testlongfile.csv");
            String resultfunc = df.displayAll();
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Alice,30,Paris,1500.5,\n" +
                    "Bob,25,New York,2000.75,\n" +
                    "Charlie,35,Londres,1800.0,\n" +
                    "David,40,Tokyo,2200.25,\n" +
                    "Emma,28,Berlin,1900.8,\n" +
                    "Frank,33,Sydney,1700.3,\n" +
                    "Grace,45,Amsterdam,2500.5,\n" +
                    "Hannah,29,Barcelone,2100.2,\n" +
                    "Isaac,38,Rome,2300.75,\n" +
                    "Julia,31,Moscou,1950.6,\n" +
                    "Kevin,27,Los Angeles,1850.45,\n" +
                    "Lily,36,Hong Kong,2400.9,\n" +
                    "Mia,32,Seoul,1750.7,\n" +
                    "Nathan,42,Mumbai,2650.25,\n" +
                    "Olivia,26,Singapour,2000.0,\n" +
                    "Paul,34,Toronto,2250.35,\n" +
                    "Rachel,39,Lima,2700.4,\n" +
                    "Samuel,37,Dubaï,2450.55,\n" +
                    "Tina,41,Le Caire,2800.65,\n" +
                    "Victoria,43,Paris,2550.7,\n" +
                    "William,44,New York,2900.75,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }

    }

    @Test
    public void testDisplayNullValue() {
        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/tesnullvaleur.csv");
            String resultfunc = df.displayAll();
            String result = "Nom,Prenom,Age,Taille,Poids,\n" +
                    "John,Doe,25,1.78,75.5,\n" +
                    "Alice,Smith,25,null,60.2,\n" +
                    "null,null,35,null,80.0,\n";

            assertEquals(result, resultfunc);
        } catch (Exception e) {
            // Gérer l'exception si nécessaire
        }

    }

    @Test
    public void testDisplayDataVide() {
        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/tesnullvaleur.csv");
            String resultfunc = df.displayAll();
            String result = "Nom,Prenom,Age,Ville,\n";

            assertEquals(result, resultfunc);
        } catch (Exception e) {
            // Gérer l'exception si nécessaire
        }
    }

    @Test
    public void testDisplayline1() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testlongfile.csv");
            String resultfunc = df.display(1);
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Alice,30,Paris,1500.5,\n" +
                    "Bob,25,New York,2000.75,\n" +
                    "Charlie,35,Londres,1800.0,\n" +
                    "David,40,Tokyo,2200.25,\n" +
                    "Emma,28,Berlin,1900.8,\n" +
                    "Frank,33,Sydney,1700.3,\n" +
                    "Grace,45,Amsterdam,2500.5,\n" +
                    "Hannah,29,Barcelone,2100.2,\n" +
                    "Isaac,38,Rome,2300.75,\n" +
                    "Julia,31,Moscou,1950.6,\n" +
                    "Kevin,27,Los Angeles,1850.45,\n" +
                    "Lily,36,Hong Kong,2400.9,\n" +
                    "Mia,32,Seoul,1750.7,\n" +
                    "Nathan,42,Mumbai,2650.25,\n" +
                    "Olivia,26,Singapour,2000.0,\n" +
                    "Paul,34,Toronto,2250.35,\n" +
                    "Rachel,39,Lima,2700.4,\n" +
                    "Samuel,37,Dubaï,2450.55,\n" +
                    "Tina,41,Le Caire,2800.65,\n" +
                    "Victoria,43,Paris,2550.7,\n" +
                    "William,44,New York,2900.75,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }

    @Test
    public void testDisplayline0() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testlongfile.csv");
            String resultfunc = df.display(0);
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Alice,30,Paris,1500.5,\n" +
                    "Bob,25,New York,2000.75,\n" +
                    "Charlie,35,Londres,1800.0,\n" +
                    "David,40,Tokyo,2200.25,\n" +
                    "Emma,28,Berlin,1900.8,\n" +
                    "Frank,33,Sydney,1700.3,\n" +
                    "Grace,45,Amsterdam,2500.5,\n" +
                    "Hannah,29,Barcelone,2100.2,\n" +
                    "Isaac,38,Rome,2300.75,\n" +
                    "Julia,31,Moscou,1950.6,\n" +
                    "Kevin,27,Los Angeles,1850.45,\n" +
                    "Lily,36,Hong Kong,2400.9,\n" +
                    "Mia,32,Seoul,1750.7,\n" +
                    "Nathan,42,Mumbai,2650.25,\n" +
                    "Olivia,26,Singapour,2000.0,\n" +
                    "Paul,34,Toronto,2250.35,\n" +
                    "Rachel,39,Lima,2700.4,\n" +
                    "Samuel,37,Dubaï,2450.55,\n" +
                    "Tina,41,Le Caire,2800.65,\n" +
                    "Victoria,43,Paris,2550.7,\n" +
                    "William,44,New York,2900.75,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }

    }

    @Test
    public void testDisplayline5() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testlongfile.csv");
            String resultfunc = df.display(5);
            String result = "Nom,Age,Ville,Argent,\n" +
                    "Emma,28,Berlin,1900.8,\n" +
                    "Frank,33,Sydney,1700.3,\n" +
                    "Grace,45,Amsterdam,2500.5,\n" +
                    "Hannah,29,Barcelone,2100.2,\n" +
                    "Isaac,38,Rome,2300.75,\n" +
                    "Julia,31,Moscou,1950.6,\n" +
                    "Kevin,27,Los Angeles,1850.45,\n" +
                    "Lily,36,Hong Kong,2400.9,\n" +
                    "Mia,32,Seoul,1750.7,\n" +
                    "Nathan,42,Mumbai,2650.25,\n" +
                    "Olivia,26,Singapour,2000.0,\n" +
                    "Paul,34,Toronto,2250.35,\n" +
                    "Rachel,39,Lima,2700.4,\n" +
                    "Samuel,37,Dubaï,2450.55,\n" +
                    "Tina,41,Le Caire,2800.65,\n" +
                    "Victoria,43,Paris,2550.7,\n" +
                    "William,44,New York,2900.75,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }


    @Test
    public void testDisplaylinefileVide() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testVide.csv");
            String resultfunc = df.display(0);
            String result = "Nom,Prenom,Age,Ville,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }

    @Test
    public void testDisplaylinenullValue() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testnullvaleur.csv");
            String resultfunc = df.display(0);
            String result = "Nom,Prenom,Age,Taille,Poids,\n" +
                    "John,Doe,25,1.78,75.5,\n" +
                    "Alice,Smith,25,null,60.2,\n" +
                    "null,null,35,null,80.0,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }
    
    @Test
    public void testDisplaylinenullValue() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testnullvaleur.csv");
            String resultfunc = df.display(3);
            String result = "Nom,Prenom,Age,Taille,Poids,\n" +
            "null,null,35,null,80.0,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }


    @Test
    public void testDisplayHeader() {

        DataFrame df;
        try {
            df = new DataFrame("./src/test/resources/testnullvaleur.csv");
            String resultfunc = df.displayHeader();
            String result = "Nom,Prenom,Age,Taille,Poids,\n";
            assertEquals(result, resultfunc);
        } catch (Exception e) {

        }
    }
}
