import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFrame {
    private List<String> columns;
    private List<Column> data;

    private int lengthCol;

    // Constructeur prenant une liste de colonnes en paramètre
    public DataFrame(List<String> columns, List<Column> data) throws TypeMismatchException{
        this.columns = columns;
        this.data = data;
        this.lengthCol = 0;
        for(Column col : data){
            if(col.length() > lengthCol){
                lengthCol = col.length();
            }
        }
        this.fill();

    }

    // Constructeur prenant un fichier CSV en entrée
    public DataFrame(String csvFilePath) throws IOException, TypeMismatchException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        columns = new ArrayList<>();
        data = new ArrayList<>();
        // Lecture de la première ligne pour récupérer les noms de colonnes
        if ((line = reader.readLine()) != null) { //Remplissage des noms
            columns = Arrays.asList(line.split(","));
        }

        if ((line = reader.readLine()) != null) { //Création des colonnes
            String[] values = line.split(",");
            for(int i =0; i < columns.size(); i++){
                Types column = Types.detectType(values[i]);
                switch (column){
                    case INT:
                        this.data.add(new Column<Integer>(column));
                        break;
                    case STRING:
                        this.data.add(new Column<String>(column));
                        break;
                    case FLOAT:
                        this.data.add(new Column<Float>(column));
                        break;
                    default:
                        throw new TypeMismatchException();
                }
            }
        }

        // Lecture des lignes suivantes pour récupérer les données
        if(line != null) {
            do {
                String[] values = line.split(",");
                for (int i = 0; i < columns.size(); i++) {
                    if(values[i].isEmpty()){
                        if(this.data.get(i).getType() == Types.INT || this.data.get(i).getType() == Types.FLOAT)
                        this.data.get(i).add(null);
                    }
                    else if (this.data.get(i).getType() == Types.detectType(values[i])) {
                        //Si tu es du même type que ta colonne
                        switch (this.data.get(i).getType()) {
                            case INT:
                                Integer intValue = (Integer) parseValue(values[i]);
                                this.data.get(i).add(intValue);
                                break;
                            case STRING:
                                String stringValue = (String) parseValue(values[i]);
                                this.data.get(i).add(stringValue);
                                break;
                            case FLOAT:
                                Float floatValue = (Float) parseValue(values[i]);
                                this.data.get(i).add(floatValue);
                                break;
                        }

                    } else {
                        throw new TypeMismatchException();
                    }
                }

            } while ((line = reader.readLine()) != null);
        }
        reader.close();

        for(Column col : data){
            if(col.length() > lengthCol){
                lengthCol = col.length();
            }
        }
        this.fill();
    }

    // Méthode pour détecter et parser les valeurs en int, float ou string
    private Object parseValue(String term){
        try {
            return Integer.parseInt(term);
        } catch (NumberFormatException e1) {
            try {
                return Float.parseFloat(term);
            } catch (NumberFormatException e2) {
                return term;
            }
        }
    }

    public String toString(){
        return displayAll();
    }

    public String displayAll(){
        String header = displayHeader();;
        String datas = "";
        for(int i = 0; i < this.lengthCol; i++ ){
            for(int j = 0; j < this.data.size(); j++){
                datas += this.data.get(j).getValue(i) + ";";
            }
            datas += "\n";

        }
        header += datas;
        return header;
    }

    public String display(int ligne){
        String header = displayHeader();
        String datas = "";

        for(int i = 0; i < this.lengthCol; i++ ){
            for(Column col : this.data){
                datas += col.getValue(i) + ";";
            }
            datas += "\n";

        }
        header += datas;
        return header;
    }

    public int getHeight(){
        return this.lengthCol;
    }

    private String displayHeader(){
        String header = "";
        for(String head : columns){
            header += head + ";";
        }
        header += "\n";
        return header;
    }

    private void fill() throws TypeMismatchException{
        for(Column col : this.data){
            if(col.length() < this.lengthCol){
                while(col.length() < this.lengthCol){
                    col.add(null);
                }
            }
        }
    }

    public List<String> getNames(){
        return this.columns;
    }

    public List<Column> getData(){
        return this.data;
    }
}
