import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFrame {
    private List<String> columns;
    private List<List<Object>> data;

    // Constructeur prenant une liste de colonnes en paramètre
    public DataFrame(List<String> columns, List<List<Object>> data) {
        this.columns = columns;
        this.data = data;
    }


}
