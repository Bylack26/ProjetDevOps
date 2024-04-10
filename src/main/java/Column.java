import java.util.ArrayList;


public class Column<T> {

    Types columnType;
    private ArrayList<T> list;

    public Column(Types type){
        this.columnType = type;
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

}
