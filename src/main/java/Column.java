import jdk.jshell.TypeDeclSnippet;

import java.lang.reflect.Type;
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
        this.columnType = null;
    }

    public T getValue(int i){
        return this.list.get(i);
    }

    public void add(T elm){
        if(elm == null){
            this.list.add(null);
        }else{
            Types t = Types.detectType(elm.toString());
            if(this.list.isEmpty() && this.columnType == null){
                this.columnType = t;
            }

            this.list.add(elm);
        }

    }

    public Types getType(){
        return columnType;
    }

    public int length(){
        return this.list.size();
    }

    public Column<T> split(List<Integer> indices){
        Column<T> cl = new Column<>(this.columnType);
        for(int i : indices){
            try {
                cl.add(this.getValue(i));
            }catch(Exception e){
                ;
            }
        }
        return cl;
    }

    public Column<T> split(int i, int j){
        Column<T> cl = new Column<>(this.columnType);
        for(;i < j; i++){
                cl.add(this.getValue(i));
        }
        return cl;
    }

}
