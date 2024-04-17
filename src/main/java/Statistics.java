public class Statistics {
    
    public static float mean(Column c) throws TypeMismatchException{
        float somme = 0;
        if(c.getType() != Types.STRING){
            for(int i = 0; i < c.length(); i++){
                somme += (int)c.getValue(i);
            }
            somme /= (float)c.length();
        }else{
            throw new TypeMismatchException();
        }
        return somme;
    }
}
