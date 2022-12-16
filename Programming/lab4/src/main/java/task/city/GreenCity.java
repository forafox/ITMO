package task.city;

import java.util.ArrayList;

public class GreenCity extends City{
    private static GreenCity INSTANCEGCITY;
    private GreenCity() {
        super("Зеленый город");
    }
    public static GreenCity getInstance() {
        if (INSTANCEGCITY == null) {
            INSTANCEGCITY = new GreenCity();
        }
        return INSTANCEGCITY;
    }

    public static class Everywhere{
            static ArrayList<String> situation = new ArrayList<>();
            public static void addSituation(String ... newSituationArguments){
                for(String x :newSituationArguments) situation.add(x);
            }
            public static String getSituation(){
                var result = new StringBuilder();
                for(var situationArguments : situation)
                    result.append(situationArguments).append(", ");
                if((""+result).length()>2) return String.format(" Всюду был "+result.substring(0,result.length() - 2));
                else return " Всюду ничего не было ";
            }
            public static String checkClear(){
                return (getSituation()==" Всюду ничего не было ") ? " Всюду был образцовый порядок и чистота " : " Всюду не было образцового порядка и чистоты ";
            }

            }

}
