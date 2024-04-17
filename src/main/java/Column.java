import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Column<T> {

    Types columnType;
    private ArrayList<T> list;
    public Column(Types type){
        this.columnType = type;
        this.list = new ArrayList<T>();
    }

    public Column(){
        this.list = new ArrayList<T>();
    }

    public T getValue(int i){
        return this.list.get(i);
    }

    public void add(T elm){
        this.list.add(elm);
    }

    public Types getType(){
        return columnType;
    }

    public int length(){
        return this.list.size();
    }

    public int length(){
        return this.list.size();
    }

    public Column<T> split(List<Integer> indices){
        Column<T> cl = new Column<>();
        for(int i : indices){
            cl.add(this.getValue(i));
        }
        return cl;
    }

    public Column<T> split(int i, int j){
        Column<T> cl = new Column<>();
        for(;i < j; i++){
            cl.add(this.getValue(i));
        }
        return cl;
    }

}
