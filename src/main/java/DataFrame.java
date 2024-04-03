import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFrame {
    private List<String> columns;
    private ArrayList<ArrayList<Object>> data;

    // Constructeur prenant une liste de colonnes en paramètre
    public DataFrame(List<String> columns, ArrayList<ArrayList<Object>> data) {
        this.columns = columns;
        this.data = data;
    }

    // Constructeur prenant un fichier CSV en entrée
    public DataFrame(String csvFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        columns = new ArrayList<>();
        data = new ArrayList<ArrayList<Object>>();

        // Lecture de la première ligne pour récupérer les noms de colonnes
        if ((line = reader.readLine()) != null) {
            columns = Arrays.asList(line.split(","));
        }
        for(int i = 0; i< columns.size();i++){
            ArrayList<Object> row = new ArrayList<>();
            data.add(row);
        }
        // Lecture des lignes suivantes pour récupérer les données
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            for (int i = 0; i< columns.size();i++) {
                Object parsedValue = parseValue(values[i]);
                data.get(i).add(parsedValue);
            }
        }
        reader.close();
    }

    // Méthode pour détecter et parser les valeurs en int, float ou string
    private Object parseValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e1) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e2) {
                return value;
            }
        }
    }
}
