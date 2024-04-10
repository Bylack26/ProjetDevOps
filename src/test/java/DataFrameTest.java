import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


public class DataFrameTest {




    private List<String> name = new ArrayList<>();
    private List<Column> datas = new ArrayList<>();

    @BeforeAll
    public void init() {
        for (int i = 0; i < 3; i++)
            name.add("Colonne" + i);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(i);
        }
        List<String> names = new ArrayList<>();
        names.add("NomFamille");
        names.add("Prénom");
        names.add("Date");
        names.add("Note");

        Types typeDate = Types.INT;
        Types typeNote = Types.FLOAT;
        Types typeNom = Types.STRING;
        Types typePrenom = Types.STRING;

        Column<String> colNom = new Column<String>(typeNom);
        Column<Integer> colDate = new Column<Integer>(typeDate);
        Column<Float> colNote = new Column<Float>(typeNote);
        Column<String> colPrenom = new Column<String>(typePrenom);

        colDate.add(25022002);
        colDate.add(06022001);
        colDate.add(30042002);
        colDate.add(14012000);

        colNote.add(19.4f);
        colNote.add(0f);
        colNote.add(15.4f);
        colNote.add(18.4f);

        colNom.add("Combe");
        colNom.add("Faurie");
        colNom.add("Vial");
        colNom.add("Balssa");

        colPrenom.add("Gaétan");
        colPrenom.add("Alban");
        colPrenom.add("Fabien");
        colPrenom.add("Raphaël");

        datas.add(colNom);
        datas.add(colPrenom);
        datas.add(colDate);
        datas.add(colNote);
    }
  
    @Test
    void constructorTest(){
        DataFrame df = new DataFrame(name, datas);
    }
}
