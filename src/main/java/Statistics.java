public class Statistics {
    public static float mean(Column c) throws TypeMismatchException{
        float somme = 0;
        if(c.getType() != Types.STRING){
            for(int i = 0; i < c.length(); i++){
                somme += (float)c.getValue(i);
            }
            somme /= c.length();
        }else{
            throw new TypeMismatchException();
        }
        return somme;
    }
}
