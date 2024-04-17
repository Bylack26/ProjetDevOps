import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.*;

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
    

    

}
