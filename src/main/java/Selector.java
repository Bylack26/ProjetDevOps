import java.util.ArrayList;
import java.util.List;

public class Selector {
    public static DataFrame selectRows(DataFrame dataframe, List<Integer> indices){
        List<String> ls = dataframe.getNames();
        List<Column> lc = new ArrayList<>();
        List<Column> datas = dataframe.getData();
        for(int i = 0; i < ls.size(); i++){
            lc.add(datas.get(i).split(indices));
        }

        try {
            return new DataFrame(ls, lc);
        } catch (TypeMismatchException e) {
            return null;
        }
    }

    public static DataFrame selectRows(DataFrame dataframe, int rangeStart, int rangeEnd){
        List<String> ls = dataframe.getNames();
        List<Column> lc = new ArrayList<>();
        List<Column> datas = dataframe.getData();
        for(int i = 0; i < ls.size(); i++){
            lc.add(datas.get(i).split(rangeStart, rangeEnd));
        }

        try {
            return new DataFrame(ls, lc);
        } catch (TypeMismatchException e) {
            return null;
        }
    }

    public static DataFrame selectCols(DataFrame dataframe, List<String> labels){
        List<String> ls = dataframe.getNames();
        List<String> names = new ArrayList<>();
        List<Column> lc = new ArrayList<>();
        List<Column> datas = dataframe.getData();
        int i =0;
        int j =0;
        //Pour chaque label
        for (String s : labels) {
            j = 0;
            //recherche de l'indice du label dans le dataframe
            while (j < ls.size() && !ls.get(j).equals(s)) {

                j++;
            }
            //Si le label est dans le dataframe ajout d'une colonne de nom "label" et dont les données sont celle du dataframe
            if (j < ls.size()) {
                names.add(s);
                lc.add(datas.get(j));
            }
        }
        try {
            return new DataFrame(names, lc);
        } catch (TypeMismatchException e) {
            return null;
        }

    }

}
