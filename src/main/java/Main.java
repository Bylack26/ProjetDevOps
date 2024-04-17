import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Affichage des informations de l'equipe via le dataframe");
        List<String> labels = new ArrayList<>();
        labels.add("Nom");
        labels.add("Prenom");
        labels.add("Age");
        List<Column> datas = new ArrayList<>();
        Column<String> noms = new Column<>();
        noms.add("Faurie");
        noms.add("Vial");
        noms.add("Balssa");
        noms.add("Combe");
        Column<String> prenoms = new Column<>();
        prenoms.add("Alban");
        prenoms.add("Fabien");
        prenoms.add("Raphael");
        prenoms.add("Gaetan");
        Column<Integer> ages = new Column<>();
        ages.add(23);
        ages.add(21);
        ages.add(22);
        ages.add(24);
        datas.add(noms);
        datas.add(prenoms);
        datas.add(ages);
        try {
        DataFrame df = new DataFrame(labels, datas);
        System.out.println(df.displayAll());
        System.out.println("Moyenne d'age du groupe:");
        List<String> l = new ArrayList<>();
        l.add("Age");

            System.out.println(Statistics.mean(Selector.selectCols(df, l).getData().get(0)));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
