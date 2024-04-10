import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DataframeTest {

    private class TestingData{
        int x;
        int y;

        public TestingData(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    private List<String> name = new ArrayList<>();
    private List<Column> datas = new ArrayList<>();
    @BeforeEach
    public void init(){
        for(int i =0; i < 3; i++)
            name.add("Colonne" + i);

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0 ; i < 5; i++){
            numbers.add(i);
        }
        List<String> names = new ArrayList<>();
        names.add("Fabien");
        names.add("Alban");
        names.add("Gaétan");
        names.add("Raphaël");

        List<Object> objets = new ArrayList<>();
        objets.add(new TestingData(1, 3));
        objets.add(new TestingData(3, 4));

    }
    @Test
    void constructorTest(){
        DataFrame df = new DataFrame(name, datas);
    }
}
