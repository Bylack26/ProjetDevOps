public enum Types {

    INT, STRING, FLOAT;

    public static Types detectType(String term){
        try {
            Integer a = Integer.parseInt(term);
            return INT;
        } catch (NumberFormatException e1) {
            try {
                Float f = Float.parseFloat(term);
                return FLOAT;
            } catch (NumberFormatException e2) {
                return STRING;
            }
        }
    }

}
